//Laboratorio 1 -Actividad 3
//Autor: MARCO ANTONIO SUAREZ HUAMANI
import java.util.Scanner;
public class Actividad3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] nSoldados = new String[5];
 
    for (int i = 0; i < 5; i++) {
      System.out.print("Ingrese el nombre del soldado " + (i + 1) + ": ");
      nSoldados[i] = sc.nextLine();
    }

    System.out.println("\nDatos de los soldados:\n==================");
    for (int i = 0; i < 5; i++){
      System.out.println((i + 1) + ": " + nSoldados[i]);
    }
  }
}

