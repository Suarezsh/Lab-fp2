//Laboratorio 1- Actividad 1
//Autor: MARCO ANTONIO SUAREZ HUAMANI
//================================
import java.util.*;
public class Actividad1{
  public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    String nSoldado1, nSoldado2 , nSoldado3, nSoldado4, nSoldado5;

    System.out.print("Ingrese el nombre del soldado 1: ");
    nSoldado1 = sc.nextLine();
    System.out.print("Ingrese el nombre del soldado 2: ");
    nSoldado2 = sc.nextLine();
    System.out.print("Ingrese el nombre del soldado 3: ");
    nSoldado3 = sc.nextLine();
    System.out.print("Ingrese el nombre del soldado 4: ");
    nSoldado4 = sc.nextLine();
    System.out.print("Ingrese el nombre del soldado 5: ");
    nSoldado5 = sc.nextLine();
    System.out.println("\nDatos de los soldados:\n==================");
    System.out.println("1: " + nSoldado1);
    System.out.println("2: " + nSoldado2);
    System.out.println("3: " + nSoldado3);
    System.out.println("4: " + nSoldado4);
    System.out.println("5: " + nSoldado5);
  }
}
