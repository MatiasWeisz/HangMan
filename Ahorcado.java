package Ej13;

public class Ahorcado {
    
    private String[] palabra;
    private int errores;
    
    public Ahorcado(){
        
    }

    public Ahorcado (String[] palabra, int errores){
        this.palabra = palabra;
        this.errores = errores;        
    }

    public String[] getPalabra() {
        return palabra;
    }

    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

   
}