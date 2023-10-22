import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class VideoJuego9 {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 10;
        int numSoldados = 10;

        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>(filas);
        for (int i = 0; i < filas; i++) {
            ArrayList<Soldado> row = new ArrayList<>(columnas);
            for (int j = 0; j < columnas; j++) {
                row.add(null);
            }
            tablero.add(row);
        }

        HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
        HashMap<Integer, Soldado> ejercito2 = new HashMap<>();

        inicializarSoldados(tablero, ejercito1, ejercito2, numSoldados);

        mostrarTablero(tablero, ejercito1, ejercito2);
        mostrarSoldadoConMayorVida(ejercito1, ejercito2);
        mostrarPromedioDeVida(ejercito1, ejercito2);
        mostrarDatosDeSoldados(ejercito1, ejercito2);
        mostrarRankingDePoder(ejercito1, ejercito2);
        determinarGanador(ejercito1, ejercito2);
    }

    static void inicializarSoldados(ArrayList<ArrayList<Soldado>> tablero, HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2, int numSoldados) {
        Random random = new Random();
        int numSoldadosCreados = 0;

        while (numSoldadosCreados < numSoldados) {
            Soldado soldado = new Soldado();
            int fila, columna;

            do {
                fila = random.nextInt(tablero.size());
                columna = random.nextInt(tablero.get(0).size());
            } while (tablero.get(fila).get(columna) != null);

            if (numSoldadosCreados < numSoldados / 2) {
                ejercito1.put(numSoldadosCreados, soldado);
            } else {
                ejercito2.put(numSoldadosCreados - numSoldados / 2, soldado);
            }

            tablero.get(fila).set(columna, soldado);
            numSoldadosCreados++;
        }
    }

    static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero, HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        System.out.println("Tablero:");

        for (ArrayList<Soldado> row : tablero) {
            for (Soldado soldado : row) {
                if (soldado == null) {
                    System.out.print("|_ ");
                } else if (ejercito1.containsValue(soldado)) {
                    System.out.print("E1(" + soldado.getVidaActual() + ") ");
                } else if (ejercito2.containsValue(soldado)) {
                    System.out.print("E2(" + soldado.getVidaActual() + ") ");
                }
            }
            System.out.println();
        }
    }

    static void mostrarSoldadoConMayorVida(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        Soldado mayorVidaEjercito1 = Collections.max(ejercito1.values(), (s1, s2) -> Integer.compare(s1.getVidaActual(), s2.getVidaActual()));
        Soldado mayorVidaEjercito2 = Collections.max(ejercito2.values(), (s1, s2) -> Integer.compare(s1.getVidaActual(), s2.getVidaActual()));

        System.out.println("Soldado con mayor vida en el Ejército 1: " + mayorVidaEjercito1);
        System.out.println("Soldado con mayor vida en el Ejército 2: " + mayorVidaEjercito2);
    }

    static void mostrarPromedioDeVida(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        double promedioEjercito1 = ejercito1.values().stream().mapToInt(Soldado::getVidaActual).average().orElse(0);
        double promedioEjercito2 = ejercito2.values().stream().mapToInt(Soldado::getVidaActual).average().orElse(0);

        System.out.println("Promedio de vida en el Ejército 1: " + promedioEjercito1);
        System.out.println("Promedio de vida en el Ejército 2: " + promedioEjercito2);
    }

    static void mostrarDatosDeSoldados(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        System.out.println("Datos de todos los soldados por Ejército:");

        System.out.println("Ejército 1:");
        ejercito1.forEach((id, soldado) -> System.out.println("ID: " + id + " - " + soldado));

        System.out.println("Ejército 2:");
        ejercito2.forEach((id, soldado) -> System.out.println("ID: " + id + " - " + soldado));
    }

    static void mostrarRankingDePoder(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        System.out.println("Ranking de poder de todos los soldados por Ejército:");

        System.out.println("Ejército 1:");
        List<Soldado> ejercito1List = new ArrayList<>(ejercito1.values());
        ejercito1List.sort((s1, s2) -> Integer.compare(s2.getVidaActual(), s1.getVidaActual()));
        ejercito1List.forEach(soldado -> System.out.println("Nombre: " + soldado.getNombre() + " - Vida: " + soldado.getVidaActual()));

        System.out.println("Ejército 2:");
        List<Soldado> ejercito2List = new ArrayList<>(ejercito2.values());
        ejercito2List.sort((s1, s2) -> Integer.compare(s2.getVidaActual(), s1.getVidaActual()));
        ejercito2List.forEach(soldado -> System.out.println("Nombre: " + soldado.getNombre() + " - Vida: " + soldado.getVidaActual()));
    }

    static void determinarGanador(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        int totalVidaEjercito1 = ejercito1.values().stream().mapToInt(Soldado::getVidaActual).sum();
        int totalVidaEjercito2 = ejercito2.values().stream().mapToInt(Soldado::getVidaActual).sum();

        if (totalVidaEjercito1 > totalVidaEjercito2) {
            System.out.println("El Ejército 1 gana la batalla.");
        } else if (totalVidaEjercito2 > totalVidaEjercito1) {
            System.out.println("El Ejército 2 gana la batalla.");
        } else {
            System.out.println("La batalla termina en empate.");
        }
    }
}

