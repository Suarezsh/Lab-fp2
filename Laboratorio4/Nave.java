//Laboratorio 4
//Autor: MARCO ANTONIO SUAREZ HUAMANI
//================================
public class Nave {
    private String nombre;
    private int fila;
    private String columna;
    private boolean estado;
    private int puntos;

    public void setNombre(String n) {
        nombre = n;
    }

    public void setFila(int f) {
        fila = f;
    }

    public void setColumna(String c) {
        columna = c;
    }

    public void setEstado(boolean e) {
        estado = e;
    }

    public void setPuntos(int p) {
        puntos = p;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFila() {
        return fila;
    }

    public String getColumna() {
        return columna;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getPuntos() {
        return puntos;
    }

    public Nave(String nombre, int fila, String columna, boolean estado, int puntos) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
        this.puntos = puntos;
    }
}
