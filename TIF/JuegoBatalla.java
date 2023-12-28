import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class JuegoBatalla extends JFrame implements KeyListener {
    private static final int ANCHO_VENTANA = 900;
    private static final int ALTO_VENTANA = 700;
    private static final int TAMANIO_CELDA = 20;
    private static final int PUNTOS_OBJETIVO = 10;

    private static final int ANCHO_MAPA = 40;
    private static final int ALTO_MAPA = 30;

    private int jugador1X;
    private int jugador1Y;
    private int jugador2X;
    private int jugador2Y;

    private int comidaX;
    private int comidaY;

    private int puntosJugador1;
    private int puntosJugador2;

    public JuegoBatalla() {
        setTitle("Juego de Batalla");
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        setVisible(true);

        int margenX = 50;
        int margenY = 50;
        int centroX = (ANCHO_VENTANA - ANCHO_MAPA * TAMANIO_CELDA) / 2 + margenX;
        int centroY = (ALTO_VENTANA - ALTO_MAPA * TAMANIO_CELDA) / 2 + margenY;

        jugador1X = ANCHO_MAPA / 2 * TAMANIO_CELDA + centroX;
        jugador1Y = ALTO_MAPA / 2 * TAMANIO_CELDA + centroY;
        jugador2X = ANCHO_MAPA / 2 * TAMANIO_CELDA + centroX;
        jugador2Y = ALTO_MAPA / 2 * TAMANIO_CELDA + centroY;

        generarNuevaComida();
    }

    private void generarNuevaComida() {
        Random random = new Random();
        comidaX = random.nextInt(ANCHO_MAPA) * TAMANIO_CELDA;
        comidaY = random.nextInt(ALTO_MAPA) * TAMANIO_CELDA;
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Dibujar el mapa con margen
        g.setColor(Color.WHITE);
        g.fillRect(50, 50, ANCHO_MAPA * TAMANIO_CELDA, ALTO_MAPA * TAMANIO_CELDA);

        // Dibujar jugadores y comida
        g.setColor(Color.RED);
        g.fillRect(jugador1X, jugador1Y, TAMANIO_CELDA, TAMANIO_CELDA);
        g.setColor(Color.BLUE);
        g.fillRect(jugador2X, jugador2Y, TAMANIO_CELDA, TAMANIO_CELDA);

        g.setColor(Color.GREEN);
        g.fillRect(comidaX, comidaY, TAMANIO_CELDA, TAMANIO_CELDA);

        // Dibujar puntajes (puedes ajustar la posición según tus preferencias)
        g.setColor(Color.BLACK);
        g.drawString("Puntos Jugador 1: " + puntosJugador1, 10, 20);
        g.drawString("Puntos Jugador 2: " + puntosJugador2, ANCHO_VENTANA - 150, 20);
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Mover a jugador 1
        if (keyCode == KeyEvent.VK_UP && jugador1Y > 50) {
            jugador1Y -= TAMANIO_CELDA;
        } else if (keyCode == KeyEvent.VK_DOWN && jugador1Y < (ALTO_MAPA - 1) * TAMANIO_CELDA + 50 - TAMANIO_CELDA) {
            jugador1Y += TAMANIO_CELDA;
        } else if (keyCode == KeyEvent.VK_LEFT && jugador1X > 50) {
            jugador1X -= TAMANIO_CELDA;
        } else if (keyCode == KeyEvent.VK_RIGHT && jugador1X < (ANCHO_MAPA - 1) * TAMANIO_CELDA + 50 - TAMANIO_CELDA) {
            jugador1X += TAMANIO_CELDA;
        }

        // Mover a jugador 2
        if (keyCode == KeyEvent.VK_W && jugador2Y > 50) {
            jugador2Y -= TAMANIO_CELDA;
        } else if (keyCode == KeyEvent.VK_S && jugador2Y < (ALTO_MAPA - 1) * TAMANIO_CELDA + 50 - TAMANIO_CELDA) {
            jugador2Y += TAMANIO_CELDA;
        } else if (keyCode == KeyEvent.VK_A && jugador2X > 50) {
            jugador2X -= TAMANIO_CELDA;
        } else if (keyCode == KeyEvent.VK_D && jugador2X < (ANCHO_MAPA - 1) * TAMANIO_CELDA + 50 - TAMANIO_CELDA) {
            jugador2X += TAMANIO_CELDA;
        }

        // Verificar si los jugadores han alcanzado la comida
        if (jugador1X == comidaX && jugador1Y == comidaY) {
            puntosJugador1++;
            generarNuevaComida();
        }

        if (jugador2X == comidaX && jugador2Y == comidaY) {
            puntosJugador2++;
            generarNuevaComida();
        }

        // Verificar si un jugador ha alcanzado el objetivo
        if (puntosJugador1 == PUNTOS_OBJETIVO || puntosJugador2 == PUNTOS_OBJETIVO) {
            String ganador = (puntosJugador1 == PUNTOS_OBJETIVO) ? "Jugador 1" : "Jugador 2";
            JOptionPane.showMessageDialog(this, "¡" + ganador + " ha ganado!");
            System.exit(0);
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JuegoBatalla::new);
    }
}
