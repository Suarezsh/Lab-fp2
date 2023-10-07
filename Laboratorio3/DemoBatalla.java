//Laboratorio 1- Actividad 1
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
            System.out.print("Estado (true/false): ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave();
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarNavesPorNombre(misNaves);
        mostrarNavesPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: ");
        mostrarMayorPuntos(misNaves);
        System.out.println("Naves desordenadas:");
        desordenarNaves(misNaves);
    }

    public static void mostrarNaves(Nave[] flota) {
        System.out.println("Naves:");
        for (Nave nave : flota) {
            System.out.println("Nombre: " + nave.getNombre());
            System.out.println("Fila: " + nave.getFila());
            System.out.println("Columna: " + nave.getColumna());
            System.out.println("Estado: " + nave.getEstado());
            System.out.println("Puntos: " + nave.getPuntos());
            System.out.println("------------");
        }
    }

    public static void mostrarNavesPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la nave a buscar: ");
        String nombreBuscar = sc.next();
        System.out.println("Naves con nombre " + nombreBuscar + ":");
        for (Nave nave : flota) {
            if (nave.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("Nombre: " + nave.getNombre());
                System.out.println("Fila: " + nave.getFila());
                System.out.println("Columna: " + nave.getColumna());
                System.out.println("Estado: " + nave.getEstado());
                System.out.println("Puntos: " + nave.getPuntos());
                System.out.println("------------");
            }
        }
    }

    public static void mostrarNavesPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de puntos máximo: ");
        int puntosMaximos = sc.nextInt();
        System.out.println("Naves con puntos inferiores o iguales a " + puntosMaximos + ":");
        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntosMaximos) {
                System.out.println("Nombre: " + nave.getNombre());
                System.out.println("Fila: " + nave.getFila());
                System.out.println("Columna: " + nave.getColumna());
                System.out.println("Estado: " + nave.getEstado());
                System.out.println("Puntos: " + nave.getPuntos());
                System.out.println("------------");
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
        System.out.println("Nombre: " + naveMayorPuntos.getNombre());
        System.out.println("Fila: " + naveMayorPuntos.getFila());
        System.out.println("Columna: " + naveMayorPuntos.getColumna());
        System.out.println("Estado: " + naveMayorPuntos.getEstado());
        System.out.println("Puntos: " + naveMayorPuntos.getPuntos());
    }

    public static void desordenarNaves(Nave[] naves) {
        Random rand = new Random();
        int n = naves.length;
        Nave[] navesDesordenadas = new Nave[n];

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        for (int i = 0; i < n; i++) {
            int randomIndex = rand.nextInt(indices.size());
            int originalIndex = indices.remove(randomIndex);
            navesDesordenadas[originalIndex] = naves[i];
        }

        for (Nave nave : navesDesordenadas) {
            System.out.println("Nombre: " + nave.getNombre());
            System.out.println("Fila: " + nave.getFila());
            System.out.println("Columna: " + nave.getColumna());
            System.out.println("Estado: " + nave.getEstado());
            System.out.println("Puntos: " + nave.getPuntos());
            System.out.println("------------");
        }
    }
}
