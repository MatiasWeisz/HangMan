package Ej13;

import java.util.Locale;
import java.util.Scanner;

public class AhorcadoService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public void menuDeOpciones(Ahorcado ahorcado) {

        int op;

        System.out.println("AHORCADO");

        do {
            System.out.println();
            System.out.println("MENÚ DE OPCIONES");
            System.out.println("1- Crear Ahorcado");
            System.out.println("2- Jugar Ahorcado");
            System.out.println("3- Salir");
            System.out.println();
            System.out.println("Qué desea realizar? Ingrese el número de la opción "
                    + "correspondiente.");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    ahorcado = crearAhorcado();
                    break;
                case 2:
                    if (ahorcado.getPalabra() == null) {
                        System.out.println("Primero debe crear el Ahorcado. "
                                + "Elija primero la opción 1.");
                    } else {
                        jugarAhorcado(ahorcado);
                    }
                    break;
                case 3:
                    System.out.println("Hasta Luego!");
                    break;
                default:
                    System.out.println("Debe ingresar una opción válida (1,2 o 3)");
                    break;
            }

        } while (op != 3);

    }

//  CREA UN OBJETO DE LA CLASE AHORCADO (ahorcado) y lo inicializa con una función.
    public Ahorcado crearAhorcado() {

        Ahorcado ahorcado = new Ahorcado();
        String adivinanza;
        int errores;
        int n;

        System.out.println();

        System.out.println("Ingrese la palabra a adivinar");
        adivinanza = sc.next().toUpperCase();

        n = adivinanza.length();

        String[] palabra = new String[n];

        System.out.println("Ingrese la cantidad de errores que se puede tener");
        errores = sc.nextInt();

        for (int i = 0; i < n; i++) {
            palabra[i] = adivinanza.substring(i, i + 1);
            System.out.print(palabra[i] + " ");
        }

        ahorcado.setPalabra(palabra);
        ahorcado.setErrores(errores);

        for (int i = 0; i < 33; i++) {
            System.out.println();
        }
        return ahorcado;
    }

    public void jugarAhorcado(Ahorcado ahorcado) {
        int n = longitud(ahorcado);
        int pifies = 0;
        int encontradas = 0;
        String letra;

        String[] vector = new String[n];
        for (int i = 0; i < n; i++) {
            vector[i] = "_";
        }

        System.out.println();
        System.out.println("Longitud de la palabra: " + longitud(ahorcado));

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println();

        do {

            System.out.println("Ingrese una letra");
            letra = sc.next().toUpperCase();

            if (buscarLetra(ahorcado, letra)) {
                System.out.println("Mensaje: La letra pertenece a la palabra.");
            } else {
                System.out.println("Mensaje: La letra NO pertenece a la palabra.");
                pifies++;
            }

            mostrarPalabra(ahorcado, letra, vector);
            System.out.println();
            opRestantes(ahorcado, pifies);

            encontradas = encontradas + aciertos(ahorcado, letra);
            System.out.println("Número de letras (encontradas,faltantes): "
                    + "(" + encontradas + "," + (n - encontradas) + ")");

            System.out.println();
            System.out.println("----------------------------------------------");
            System.out.println();

            if (encontradas == n) {
                System.out.println("----------------------------------------------");
                System.out.println("FELICITACIONES! ENCONTRASTE LA PALABRA!!! :D");
                System.out.println("----------------------------------------------");
                break;
            }

        } while (pifies < ahorcado.getErrores());

        if (pifies == ahorcado.getErrores()) {
            System.out.println("----------------------------------------------");
            System.out.println("AGOTASTE LOS INTENTOS! GAME OVER!!! :(");
            System.out.println("----------------------------------------------");
        }
    }

    public int longitud(Ahorcado ahorcado) {
        int longitud = ahorcado.getPalabra().length;

        return longitud;
    }

    public boolean buscarLetra(Ahorcado ahorcado, String letra) {
        boolean esParte = false;
        int n = longitud(ahorcado);

        String[] palabra = new String[n];
        palabra = ahorcado.getPalabra();

        for (int i = 0; i < n; i++) {
            if (palabra[i].equals(letra)) {
                esParte = true;
            }
        }
        return esParte;
    }

    public int aciertos(Ahorcado ahorcado, String letra) {
        int n = longitud(ahorcado);
        int aciertos = 0;

        String[] palabra = new String[n];
        palabra = ahorcado.getPalabra();

        for (int i = 0; i < n; i++) {
            if (palabra[i].equals(letra)) {
                aciertos++;
            }
        }
        return aciertos;
    }

    public void opRestantes(Ahorcado ahorcado, int pifies) {
        int oportunidades = ahorcado.getErrores() - pifies;
        System.out.println("Número de oportunidades restantes: " + oportunidades);
    }

    public void mostrarPalabra(Ahorcado ahorcado, String letra, String[] vector) {
        int n = longitud(ahorcado);

        System.out.println("ESTADO ACTUAL");
        for (int i = 0; i < n; i++) {
            if (ahorcado.getPalabra()[i].equals(letra)) {
                vector[i] = letra;
            }
            System.out.print(" " + vector[i] + " ");
        }

    }
}
