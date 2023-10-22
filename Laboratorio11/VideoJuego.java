import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        int filas = 5;
        int columnas = 5;
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(null);
            }
            tablero.add(fila);
        }

        HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
        HashMap<Integer, Soldado> ejercito2 = new HashMap<>();

        inicializarEjercito(ejercito1, tablero, filas, columnas);
        inicializarEjercito(ejercito2, tablero, filas, columnas);

        jugarVideojuego(tablero, ejercito1, ejercito2);
    }

    static void inicializarEjercito(HashMap<Integer, Soldado> ejercito, ArrayList<ArrayList<Soldado>> tablero, int filas, int columnas) {
        Random rand = new Random();
        int cantidadSoldados = rand.nextInt(10) + 1;

        for (int i = 0; i < cantidadSoldados; i++) {
            int fila, columna;

            do {
                fila = rand.nextInt(filas);
                columna = rand.nextInt(columnas);
            } while (tablero.get(fila).get(columna) != null);

            String nombre = "Soldado" + i;
            int nivelAtaque = rand.nextInt(5) + 1;
            int nivelDefensa = rand.nextInt(5) + 1;
            int nivelVida = rand.nextInt(5) + 1;

            Soldado soldado = new Soldado(nombre, nivelAtaque, nivelDefensa, nivelVida);
            ejercito.put(fila * columnas + columna, soldado);
            tablero.get(fila).set(columna, soldado);
        }
    }

    static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero, HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(0).size(); j++) {
                Soldado soldado = tablero.get(i).get(j);
                if (soldado != null) {
                    if (ejercito1.containsValue(soldado)) {
                        System.out.print("E1 ");
                    } else if (ejercito2.containsValue(soldado)) {
                        System.out.print("E2 ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    static void jugarVideojuego(ArrayList<ArrayList<Soldado>> tablero, HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        Scanner scanner = new Scanner(System.in);

        while (!ejercito1.isEmpty() && !ejercito2.isEmpty()) {
            mostrarTablero(tablero, ejercito1, ejercito2);
            System.out.println("Turno del ejército 1");
            moverSoldado(tablero, ejercito1, ejercito2, 1, scanner);
            mostrarTablero(tablero, ejercito1, ejercito2);

            if (!ejercito2.isEmpty()) {
                System.out.println("Turno del ejército 2");
                moverSoldado(tablero, ejercito2, ejercito1, 2, scanner);
            }
        }

        if (ejercito1.isEmpty()) {
            System.out.println("Ejército 2 gana!");
        } else {
            System.out.println("Ejército 1 gana!");
        }
    }

    static void moverSoldado(ArrayList<ArrayList<Soldado> tablero, HashMap<Integer, Soldado> ejercito, HashMap<Integer, Soldado> enemigo,
            int ejercitoNumero, Scanner scanner) {
        int fila, columna;
        Soldado soldado;

        do {
            System.out.print("Ingrese las coordenadas del soldado a mover (fila columna): ");
            fila = scanner.nextInt();
            columna = scanner.nextInt();

            if (fila < 0 || fila >= tablero.size() || columna < 0 || columna >= tablero.get(0).size()) {
                System.out.println("Coordenadas fuera del tablero. Inténtelo de nuevo.");
                continue;
            }

            soldado = tablero.get(fila).get(columna);

            if (soldado == null) {
                System.out.println("No hay un soldado en esa posición. Inténtelo de nuevo.");
                continue;
            }

            if (ejercito.containsValue(soldado) && ejercito.get(fila * tablero.get(0).size() + columna) != null) {
                System.out.println("Este soldado ya se ha movido en este turno. Inténtelo de nuevo.");
            }
        } while (soldado == null || !ejercito.containsValue(soldado) || ejercito.get(fila * tablero.get(0).size() + columna) != null);

        ejercito.put(fila * tablero.get(0).size() + columna, soldado);

        System.out.print("Ingrese la dirección de movimiento (arriba, abajo, izquierda, derecha): ");
        String direccion = scanner.next();

        int nuevaFila = fila;
        int nuevaColumna = columna;

        switch (direccion) {
            case "arriba":
                nuevaFila--;
                break;
            case "abajo":
                nuevaFila++;
                break;
            case "izquierda":
                nuevaColumna--;
                break;
            case "derecha":
                nuevaColumna++;
                break;
            default:
                System.out.println("Dirección no válida. Inténtelo de nuevo.");
                return;
        }

        if (nuevaFila < 0 || nuevaFila >= tablero.size() || nuevaColumna < 0 || nuevaColumna >= tablero.get(0).size()) {
            System.out.println("Movimiento fuera del tablero. Inténtelo de nuevo.");
            return;
        }

        Soldado enemigoSoldado = tablero.get(nuevaFila).get(nuevaColumna);

        if (enemigoSoldado != null && enemigo.containsValue(enemigoSoldado)) {
            batalla(soldado, enemigoSoldado);

            if (!enemigoSoldado.estaVivo()) {
                tablero.get(nuevaFila).set(nuevaColumna, null);
                enemigo.remove(nuevaFila * tablero.get(0).size() + nuevaColumna);
            }
        } else {
            tablero.get(fila).set(columna, null);
            tablero.get(nuevaFila).set(nuevaColumna, soldado);
        }
    }

    static void batalla(Soldado soldado1, Soldado soldado2) {
        Random rand = new Random();
        int vidaTotal = soldado1.getVidaActual() + soldado2.getVidaActual();
        double probabilidadSoldado1 = (double) soldado1.getVidaActual() / vidaTotal;

        if (rand.nextDouble() < probabilidadSoldado1) {
            soldado2.serAtacado();
        } else {
            soldado1.serAtacado();
        }
    }
}
