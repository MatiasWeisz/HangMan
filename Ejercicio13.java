package Ej13;

import java.util.Locale;
import java.util.Scanner;

/**
 * Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá
 * contener un vector con la palabra a buscar y la cantidad jugadas máximas que
 * puede realizar el usuario.
 */
public class Ejercicio13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        AhorcadoService metodos = new AhorcadoService();
        
        Ahorcado ahorcado = new Ahorcado();                
       
        metodos.menuDeOpciones(ahorcado);
    }
}