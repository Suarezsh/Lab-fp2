import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class VideoJuego4 {
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

        ArrayList<Soldado> ejercito1 = new ArrayList<>();
        ArrayList<Soldado> ejercito2 = new ArrayList<>();

        inicializarSoldados(tablero, ejercito1, ejercito2, numSoldados);

        mostrarTablero(tablero, ejercito1, ejercito2);
        mostrarSoldadoConMayorVida(ejercito1, ejercito2);
        mostrarPromedioDeVida(ejercito1, ejercito2);
        mostrarDatosDeSoldados(ejercito1, ejercito2);
        mostrarRankingDePoder(ejercito1, ejercito2);
        determinarGanador(ejercito1, ejercito2);
    }

    static void inicializarSoldados(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2, int numSoldados) {
        Random random = new Random();
        int numSoldadosCreados = 0;

        while (numSoldadosCreados < numSoldados) {
            String nombre = "Soldado0X" + (numSoldadosCreados + 1);
            int vida = random.nextInt(5) + 1;
            int fila, columna;

            do {
                fila = random.nextInt(tablero.size());
                columna = random.nextInt(tablero.get(0).size());
            } while (tablero.get(fila).get(columna) != null);

            Soldado soldado = new Soldado(nombre, vida, fila, columna);

            if (numSoldadosCreados < numSoldados / 2) {
                ejercito1.add(soldado);
            } else {
                ejercito2.add(soldado);
            }

            tablero.get(fila).set(columna, soldado);
            numSoldadosCreados++;
        }
    }

    static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
        System.out.println("Tablero:");

        for (ArrayList<Soldado> row : tablero) {
            for (Soldado soldado : row) {
                if (soldado == null) {
                    System.out.print("|_ ");
                } else if (ejercito1.contains(soldado)) {
                    System.out.print("E1(" + soldado.getVida() + ") ");
                } else if (ejercito2.contains(soldado)) {
                    System.out.print("E2(" + soldado.getVida() + ") ");
                }
            }
            System.out.println();
        }
    }

    static void mostrarSoldadoConMayorVida(List<Soldado> ejercito1, List<Soldado> ejercito2) {
        Soldado mayorVidaEjercito1 = Collections.max(ejercito1, (s1, s2) -> Integer.compare(s1.getVida(), s2.getVida()));
        Soldado mayorVidaEjercito2 = Collections.max(ejercito2, (s1, s2) -> Integer.compare(s1.getVida(), s2.getVida()));

        System.out.println("Soldado con mayor vida en el Ejército 1: " + mayorVidaEjercito1);
        System.out.println("Soldado con mayor vida en el Ejército 2: " + mayorVidaEjercito2);
    }

    static void mostrarPromedioDeVida(List<Soldado> ejercito1, List<Soldado> ejercito2) {
        double promedioEjercito1 = ejercito1.stream().mapToInt(Soldado::getVida).average().orElse(0);
        double promedioEjercito2 = ejercito2.stream().mapToInt(Soldado::getVida).average().orElse(0);

        System.out.println("Promedio de vida en el Ejército 1: " + promedioEjercito1);
        System.out.println("Promedio de vida en el Ejército 2: " + promedioEjercito2);
    }

    static void mostrarDatosDeSoldados(List<Soldado> ejercito1, List<Soldado> ejercito2) {
        System.out.println("Datos de todos los soldados por Ejército:");

        System.out.println("Ejército 1:");
        ejercito1.forEach(System.out::println);

        System.out.println("Ejército 2:");
        ejercito2.forEach(System.out::println);
    }

    static void mostrarRankingDePoder(List<Soldado> ejercito1, List<Soldado> ejercito2) {
        System.out.println("Ranking de poder de todos los soldados por Ejército:");

        System.out.println("Ejército 1:");
        ejercito1.sort((s1, s2) -> Integer.compare(s2.getVida(), s1.getVida()));
        ejercito1.forEach(soldado -> System.out.println("Nombre: " + soldado.getNombre() + " - Vida: " + soldado.getVida()));

        System.out.println("Ejército 2:");
        ejercito2.sort((s1, s2) -> Integer.compare(s2.getVida(), s1.getVida()));
        ejercito2.forEach(soldado -> System.out.println("Nombre: " + soldado.getNombre() + " - Vida: " + soldado.getVida()));
    }

    static void determinarGanador(List<Soldado> ejercito1, List<Soldado> ejercito2) {
        int totalVidaEjercito1 = ejercito1.stream().mapToInt(Soldado::getVida).sum();
        int totalVidaEjercito2 = ejercito2.stream().mapToInt(Soldado::getVida).sum();

        if (totalVidaEjercito1 > totalVidaEjercito2) {
            System.out.println("El Ejército 1 gana la batalla.");
        } else if (totalVidaEjercito2 > totalVidaEjercito1) {
            System.out.println("El Ejército 2 gana la batalla.");
        } else {
            System.out.println("La batalla termina en empate.");
        }
    }
}

