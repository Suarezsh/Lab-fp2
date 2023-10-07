//Laboratorio 6
//Autor: MARCO ANTONIO SUAREZ HUAMANI
//==================================
public class Soldado {
    private String nombre;
    private int vida;
    private int fila;
    private int columna;

    public Soldado(String nombre, int vida, int fila, int columna) {
        this.nombre = nombre;
        this.vida = vida;
        this.fila = fila;
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return "Soldado{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}

