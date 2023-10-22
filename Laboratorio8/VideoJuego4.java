import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class VideoJuego5 {
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

        Map<String, Soldado> ejercito1 = new HashMap<>();
        Map<String, Soldado> ejercito2 = new HashMap<>();