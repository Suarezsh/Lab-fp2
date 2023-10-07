public class Soldado {
    String nombre;
    int vida;

    public Soldado(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    String getNombre() {
        return nombre;
    }

    int getVida() {
        return vida;
    }
}
