//Laboratorio 1 - Actividad 2
//Autor: MARCO ANTONIO SUAREZ HUAMANI

import java.util.*;
public class Actividad2 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();

    String nSoldado1, nSoldado2, nSoldado3, nSoldado4, nSoldado5;
    int vSoldado1, vSoldado2, vSoldado3, vSoldado4, vSoldado5;

    System.out.print("Ingrese el nombre del soldado 1: ");
    nSoldado1 = sc.nextLine();
    vSoldado1 = rn.nextInt(5) + 1;
    System.out.print("Ingrese el nombre del soldado 2: ");
    nSoldado2 = sc.nextLine();
    vSoldado2 = rn.nextInt(5) + 1;
    System.out.print("Ingrese el nombre del soldado 3: ");
    nSoldado3 = sc.nextLine();
    vSoldado3 = rn.nextInt(5) + 1;
    System.out.print("Ingrese el nombre del soldado 4: ");
    nSoldado4 = sc.nextLine();
    vSoldado4 = rn.nextInt(5) + 1;
    System.out.print("Ingrese el nombre del soldado 5: ");
    nSoldado5 = sc.nextLine();
    vSoldado5 = rn.nextInt(5) + 1;

    System.out.println("\nDatos de los soldados:\n==================");
    System.out.println("1: " + nSoldado1 + " :: Vida: " + vSoldado1);
    System.out.println("2: " + nSoldado2 + " :: Vida: " + vSoldado2);
    System.out.println("3: " + nSoldado3 + " :: Vida: " + vSoldado3);
    System.out.println("4: " + nSoldado4 + " :: Vida: " + vSoldado4);
    System.out.println("5: " + nSoldado5 + " :: Vida: " + vSoldado5);
  }
}

