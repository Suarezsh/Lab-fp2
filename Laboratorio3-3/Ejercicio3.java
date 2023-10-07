//Laboratorio 1- Actividad 1
//Autor: MARCO ANTONIO SUAREZ HUAMANI
//================================
import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        Soldado[] ejercito1 = inicializarEjercito();
        Soldado[] ejercito2 = inicializarEjercito();

        System.out.println("Ejercito 1:");
        mostrarEjercito(ejercito1);

        System.out.println("\nEjercito 2:");
        mostrarEjercito(ejercito2);

        int resultado = compararEjercitos(ejercito1, ejercito2);

        if (resultado == 0) {
            System.out.println("\nEmpate: Ambos ejercitos tienen el mismo número de soldados.");
        } else if (resultado > 0) {
            System.out.println("\nEjercito 1 es el ganador con más soldados.");
        } else {
            System.out.println("\nEjercito 2 es el ganador con más soldados.");
        }
    }

    public static Soldado[] inicializarEjercito() {
        Random rand = new Random();
        int numSoldados = rand.nextInt(5) + 1;
        Soldado[] ejercito = new Soldado[numSoldados];

        for (int i = 0; i < numSoldados; i++) {
            ejercito[i] = new Soldado("Soldado" + i);
        }

        return ejercito;
    }

    public static void mostrarEjercito(Soldado[] ejercito) {
        for (int i = 0; i < ejercito.length; i++) {
            System.out.println((i + 1) + ": " + ejercito[i].getNombre());
        }
    }

    public static int compararEjercitos(Soldado[] ejercito1, Soldado[] ejercito2) {
        if (ejercito1.length == ejercito2.length) {
            return 0;
        } else if (ejercito1.length > ejercito2.length) {
            return 1;
        } else {
            return -1;
        }
    }
}
