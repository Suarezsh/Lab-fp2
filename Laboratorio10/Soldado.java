import java.util.Random;

public class Soldado {
    private String nombre;
    private int nivelAtaque;
    protected int nivelDefensa;
    private int nivelVida;
    protected int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;

    public Soldado() {
        Random random = new Random();
        this.nombre = "Soldado" + random.nextInt(10) + "X" + random.nextInt(10);
        this.nivelAtaque = random.nextInt(5) + 1;
        this.nivelDefensa = random.nextInt(5) + 1;
        this.nivelVida = random.nextInt(5) + 1;
        this.vidaActual = this.nivelVida;
        this.velocidad = 0;
        this.actitud = "defensiva";
        this.vive = true;
    }

    public void atacar() {
        avanzar();
    }

    public void defender() {
        this.velocidad = 0;
        this.actitud = "defensiva";
    }

    public void avanzar() {
        this.velocidad += 1;
        this.actitud = "ofensiva";
    }

    public void retroceder() {
        if (this.velocidad > 0) {
            this.velocidad = 0;
            this.actitud = "defensiva";
        } else {
            this.velocidad -= 1;
        }
    }

    public void serAtacado() {
        this.vidaActual -= 1;
        if (this.vidaActual <= 0) {
            morir();
        }
    }

    public void huir() {
        this.velocidad += 2;
        this.actitud = "fuga";
    }

    public void morir() {
        this.vive = false;
    }

    public void setVidaActual(int vida) {
        this.vidaActual = vida;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getActitud() {
        return actitud;
    }

    public boolean isVive() {
        return vive;
    }

    @Override
    public String toString() {
        return "Soldado{" +
                "nombre='" + nombre + '\'' +
                ", nivelAtaque=" + nivelAtaque +
                ", nivelDefensa=" + nivelDefensa +
                ", nivelVida=" + nivelVida +
                ", vidaActual=" + vidaActual +
                ", velocidad=" + velocidad +
                ", actitud='" + actitud + '\'' +
                ", vive=" + vive +
                '}';
    }
}

