//Laboratorio 4
//Autor: MARCO ANTONIO SUAREZ HUAMANI
//================================
import java.util.*;

public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[3];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave(nomb, fil, col, est, punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos:");
        mostrarMayorPuntos(misNaves);
        System.out.print("Ingrese un nombre para buscar una nave: ");
        String nombre = sc.next();
        int pos = busquedaLinealNombre(misNaves, nombre);
        if (pos != -1) {
            System.out.println("Nave encontrada:");
            mostrarNave(misNaves[pos]);
        } else {
            System.out.println("Nave no encontrada.");
        }

        ordenarPorPuntosBurbuja(misNaves);
        System.out.println("\nNaves ordenadas por puntos de menor a mayor (Burbuja):");
        mostrarNaves(misNaves);

        ordenarPorNombreBurbuja(misNaves);
        System.out.println("\nNaves ordenadas por nombre de A a Z (Burbuja):");
        mostrarNaves(misNaves);

        ordenarPorPuntosSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por puntos de menor a mayor (Selección):");
        mostrarNaves(misNaves);

        ordenarPorNombreSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por nombre de Z a A (Selección):");
        mostrarNaves(misNaves);

        ordenarPorPuntosInsercion(misNaves);
        System.out.println("\nNaves ordenadas por puntos de mayor a menor (Inserción):");
        mostrarNaves(misNaves);

        ordenarPorNombreInsercion(misNaves);
        System.out.println("\nNaves ordenadas por nombre de Z a A (Inserción):");
        mostrarNaves(misNaves);
    }

    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            mostrarNave(nave);
        }
    }

    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la nave a buscar: ");
        String nombreBuscar = sc.next();
        boolean encontrada = false;
        for (Nave nave : flota) {
            if (nave.getNombre().equalsIgnoreCase(nombreBuscar)) {
                mostrarNave(nave);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("Nave no encontrada.");
        }
    }

    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de puntos máximo: ");
        int puntosMaximos = sc.nextInt();
        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntosMaximos) {
                mostrarNave(nave);
            }
        }
    }

    public static void mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayorPuntos = flota[0];
        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayorPuntos.getPuntos()) {
                naveMayorPuntos = nave;
            }
        }
        mostrarNave(naveMayorPuntos);
    }

    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;
    }

    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        int n = flota.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (flota[i - 1].getPuntos() > flota[i].getPuntos()) {
                   
                    Nave temp = flota[i - 1];
                    flota[i - 1] = flota[i];
                    flota[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        int n = flota.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (flota[i - 1].getNombre().compareToIgnoreCase(flota[i].getNombre()) > 0) {
                  
                    Nave temp = flota[i - 1];
                    flota[i - 1] = flota[i];
                    flota[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getPuntos() > flota[maxIdx].getPuntos()) {
                    maxIdx = j;
                }
            }
            Nave temp = flota[i];
            flota[i] = flota[maxIdx];
            flota[maxIdx] = temp;
        }
    }

    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getNombre().compareToIgnoreCase(flota[maxIdx].getNombre()) > 0) {
                    maxIdx = j;
                }
            }
            Nave temp = flota[i];
            flota[i] = flota[maxIdx];
            flota[maxIdx] = temp;
        }
    }

    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        int n = flota.length;
        for (int i = 1; i < n; i++) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getPuntos() < key.getPuntos()) {
                flota[j + 1] = flota[j];
                j = j - 1;
            }
            flota[j + 1] = key;
        }
    }

    public static void ordenarPorNombreInsercion(Nave[] flota) {
        int n = flota.length;
        for (int i = 1; i < n; i++) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getNombre().compareToIgnoreCase(key.getNombre()) < 0) {
                flota[j + 1] = flota[j];
                j = j - 1;
            }
            flota[j + 1] = key;
        }
    }

    public static void mostrarNave(Nave nave) {
        System.out.println("Nombre: " + nave.getNombre());
        System.out.println("Fila: " + nave.getFila());
        System.out.println("Columna: " + nave.getColumna());
        System.out.println("Estado: " + nave.getEstado());
        System.out.println("Puntos: " + nave.getPuntos());
        System.out.println("------------");
    }
}
