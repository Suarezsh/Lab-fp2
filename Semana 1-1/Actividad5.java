import java.util.Random;

public class Actividad5 {
    public static void main(String[] args) {
        String[] ejercito1 = initEjercito();
        String[] ejercito2 = initEjercito();

        System.out.println("Ejercito 1:");
        showEjercito(ejercito1);

        System.out.println("\nEjercito 2:");
        showEjercito(ejercito2);

        int resultado = compareEjercitos(ejercito1, ejercito2);

        if (resultado == 0) {
            System.out.println("\nEmpate: Ambos ejercitos tienen el mismo número de soldados...");
        } else if (resultado > 0) {
            System.out.println("\nEjercito 1 es el ganador con más soldados...");
        } else {
            System.out.println("\nEjercito 2 es el ganador con más soldados...");
        }
    }

    public static String[] initEjercito() {
        Random rand = new Random();
        int numSoldados = rand.nextInt(5) + 1;
        String[] ejercito = new String[numSoldados];

        for (int i = 0; i < numSoldados; i++) {
            ejercito[i] = "Soldado" + i;
        }

        return ejercito;
    }

    public static void showEjercito(String[] ejercito) {
        for (int i = 0; i < ejercito.length; i++) {
            System.out.println(i + ": " + ejercito[i]);
        }
    }

    public static int compareEjercitos(String[] ejercito1, String[] ejercito2) {
        if (ejercito1.length == ejercito2.length) {
            return 0;
        } else if (ejercito1.length > ejercito2.length) {
            return 1; 
        } else {
            return -1;
        }
    }
}
