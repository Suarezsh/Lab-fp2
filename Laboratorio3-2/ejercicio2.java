import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Soldado[] soldados = new Soldado[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre del soldado " + (i + 1) + ": ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el nivel de vida del soldado " + (i + 1) + ": ");
            int vida = sc.nextInt();
            sc.nextLine(); 

            soldados[i] = new Soldado(nombre, vida);
        }

        System.out.println("\nDatos de los soldados:\n==================");
        for (int i = 0; i < 5; i++) {
            Soldado soldado = soldados[i];
            System.out.println((i + 1) + ": " + soldado.getNombre() + ", Vida: " + soldado.getVida());
        }
    }
}
