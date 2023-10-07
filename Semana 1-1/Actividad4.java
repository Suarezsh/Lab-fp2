import java.util.Scanner;

public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nSoldado = new String[5];
        int[] vSoldado = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre del soldado " + (i + 1) + ": ");
            nSoldado[i] = sc.nextLine();

            System.out.print("Ingrese el nivel de vida del soldado " + (i + 1) + ": ");
            vSoldado[i] = sc.nextInt();
            sc.nextLine(); // Limpia el buffer de entrada
        }

        System.out.println("\nDatos de los soldados:\n==================");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ": " + nSoldado[i] + ",Vida: " + vSoldado[i]);
        }
    }
}
