//Laboratorio 5
//Autor: MARCO ANTONIO SUAREZ HUAMANI
//==================================
import java.util.Random;

public class VideoJuego2 {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 10;
        int numSoldados = 10;

        Soldado[][] tablero = new Soldado[filas][columnas];

        inicializarTablero(tablero, filas, columnas);
        crearSoldados(tablero, numSoldados);
        mostrarTablero(tablero);
        mostrarSoldadoConMayorVida(tablero);
        mostrarPromedioDeVida(tablero);
        mostrarVidaDelEjercito(tablero);
        mostrarDatosDeSoldados(tablero);
        mostrarRankingDePoder(tablero);
    }

    static void inicializarTablero(Soldado[][] tablero, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = null;
            }
        }
    }

    static void crearSoldados(Soldado[][] tablero, int numSoldados) {
        Random random = new Random();
        int numSoldadosCreados = 0;
        while (numSoldadosCreados < numSoldados) {
            String nombre = "Soldado" + (numSoldadosCreados + 1);
            int vida = random.nextInt(5) + 1;
            int fila, columna;
            do {
                fila = random.nextInt(tablero.length);
                columna = random.nextInt(tablero[0].length);
            } while (tablero[fila][columna] != null);

            tablero[fila][columna] = new Soldado(nombre, vida);
            numSoldadosCreados++;
        }
    }

    static void mostrarTablero(Soldado[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].getNombre() + "(" + tablero[i][j].getVida() + ") ");
                } else {
                    System.out.print("|_ ");
                }
            }
            System.out.println();
        }
    }

    static void mostrarSoldadoConMayorVida(Soldado[][] tablero) {
        Soldado mayorVida = null;
        int vidaMax = -1;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null && tablero[i][j].getVida() > vidaMax) {
                    vidaMax = tablero[i][j].getVida();
                    mayorVida = tablero[i][j];
                }
            }
        }
        if (mayorVida != null) {
            System.out.println("Soldado con mayor vida: " + mayorVida.getNombre() + " - Vida: " + vidaMax);
        } 
    }

    static void mostrarPromedioDeVida(Soldado[][] tablero) {
        int sumaVida = 0;
        int numSoldados = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null) {
                    sumaVida += tablero[i][j].getVida();
                    numSoldados++;
                }
            }
        }
        if (numSoldados > 0) {
            double promedio = (double) sumaVida / numSoldados;
            System.out.println("Promedio de vida de todos los soldados: " + promedio);
        }
    }

    static void mostrarVidaDelEjercito(Soldado[][] tablero) {
        int vidaTotal = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null) {
                    vidaTotal += tablero[i][j].getVida();
                }
            }
        }
        if (vidaTotal > 0) {
            System.out.println("Vida total del ejército: " + vidaTotal);
        } 
    }

    static void mostrarDatosDeSoldados(Soldado[][] tablero) {
        System.out.println("Datos de todos los soldados en el orden que fueron creados:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null) {
                    System.out.println("Nombre: " + tablero[i][j].getNombre() + " - Vida: " + tablero[i][j].getVida());
                }
            }
        }
    }

    static void mostrarRankingDePoder(Soldado[][] tablero) {
        System.out.println("Ranking de poder de todos los soldados:");
        Soldado[] todosSoldados = new Soldado[tablero.length * tablero[0].length];
        int index = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null) {
                    todosSoldados[index] = tablero[i][j];
                    index++;
                }
            }
        }
        if (index > 0) {
            for (int i = 0; i < index - 1; i++) {
                for (int j = 0; j < index - i - 1; j++) {
                    if (todosSoldados[j].getVida() < todosSoldados[j + 1].getVida()) {
                        Soldado temp = todosSoldados[j];
                        todosSoldados[j] = todosSoldados[j + 1];
                        todosSoldados[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < index; i++) {
                System.out.println("Puesto " + (i + 1) + ": " + todosSoldados[i].getNombre() + " - Vida: " + todosSoldados[i].getVida());
            }
        } 
    }
}
