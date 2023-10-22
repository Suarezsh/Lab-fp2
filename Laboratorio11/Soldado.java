import java.util.Random;

public class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;

    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = nivelVida;
        this.velocidad = 0;
        this.actitud = "defensiva";
        this.vive = true;
    }

    public void atacar() {
        if (vive) {
            actitud = "ofensiva";
            velocidad++;
        }
    }

    public void defender() {
        if (vive) {
            actitud = "defensiva";
            velocidad = 0;
        }
    }

    public void avanzar() {
        if (vive) {
            velocidad++;
        }
    }

    public void retroceder() {
        if (vive) {
            if (velocidad > 0) {
                defender();
            } else {
                velocidad--;
            }
        }
    }

    public void serAtacado() {
        if (vive) {
            vidaActual -= 1;
            if (vidaActual <= 0) {
                morir();
            }
        }
    }

    public void huir() {
        if (vive) {
            actitud = "fuga";
            velocidad += 2;
        }
    }

    public void morir() {
        vive = false;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public boolean estaVivo() {
        return vive;
    }

    public String toString() {
        return "Soldado " + nombre + " | Vida: " + vidaActual + " | Ataque: " + nivelAtaque + " | Defensa: " + nivelDefensa;
    }
}
