//Laboratorio 2_ Ejercicio de Ahorcado
//Autor: MARCO ANTONIO SUAREZ HUAMANI
//
import java.util.Scanner;

public class Ahorcado {
  public static void main(String[] args) {
    String ahor1 = " +---+ \n" +
                   " |   | \n" +
                   "     | \n" +
                   "     | \n" +
                   "     | \n" +
                   "     | \n" +
                   "========= ";
    String ahor2 = " +---+ \n" +
                   " |   | \n" +
                   " O   | \n" +
                   "     | \n" +
                   "     | \n" +
                   "     | \n" +
                   "=========";

    String ahor3 = " +---+ \n" +
                   " |   | \n" +
                   " O   | \n" +
                   " |   | \n" +
                   "     | \n" +
                   "     | \n" +
                   "=========";

    String ahor4 = " +---+ \n" +
                   " |   | \n" +
                   " O   | \n" +
                   "/|   | \n" +
                   "     | \n" +
                   "     | \n" +
                   "=========";

    String ahor5 = " +---+ \n" +
                   " |   | \n" +
                   " O   | \n" +
                   "/|\\  | \n" +
                   "     | \n" +
                   "     | \n" +
                   "=========";

    String ahor6 = " +---+ \n" +
                   " |   | \n" +
                   " O   | \n" +
                   "/|\\  | \n" +
                   "/    | \n" +
                   "     | \n" +
                   "=========";

    String ahor7 = " +---+ \n" +
                   " |   | \n" +
                   " O   | \n" +
                   "/|\\  | \n" +
                   "/ \\  | \n" +
                   "     | \n" +
                   "=========";

    String[] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
    int contador = 1;
    String letra;
    String[] palabras = {"programacion", "java", "indentacion", "clases","objetos", "desarrollador", "pruebas"};
    String palSecreta = getPalabraSecreta(palabras);
    StringBuilder blancos = new StringBuilder();
    for (int i = 0; i < palSecreta.length(); i++) {
      blancos.append("_ ");
    }

    System.out.println(figuras[0]);
    System.out.println(blancos.toString() + "\n");

    int letrasIncorrectas = 0;

    while (contador <= 6) {
      letra = ingreseLetra();
      if (letraEnPalabraSecreta(letra, palSecreta)) {
        mostrarBlancosActualizados(letra, palSecreta, blancos);
      } else {
        System.out.println(figuras[contador]);
        contador++;
        letrasIncorrectas++;
        }
      if (blancos.indexOf("_") == -1) {
        System.out.println("¡Ganaste! La palabra secreta es: " + palSecreta);
        break;
      }
    }

    if (letrasIncorrectas == 6) {
      System.out.println("¡Perdiste! La palabra secreta era: " + palSecreta);
    }
  }

  public static String getPalabraSecreta(String[] lasPalabras) {
    String palSecreta;
    int ind;
    int indiceMayor = lasPalabras.length - 1;
    int indiceMenor = 0;
    ind = (int) (Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor);
    return lasPalabras[ind];
  }


   public static void mostrarBlancosActualizados(String letra, String palSecreta, StringBuilder blancos) {
     for (int i = 0; i < palSecreta.length(); i++) {
       if (palSecreta.charAt(i) == letra.charAt(0)) {
         blancos.setCharAt(i * 2, letra.charAt(0));
       }
     }
     System.out.println(blancos.toString());
   }

   public static String ingreseLetra() {
     String laLetra;
     Scanner sc = new Scanner(System.in);
     do {
       System.out.println("Ingrese letra: ");
       laLetra = sc.next().toLowerCase();
       if (laLetra.length() != 1 || !Character.isLetter(laLetra.charAt(0))) {
         System.out.println("Ingrese una letra válida.");
       }
     } while (laLetra.length() != 1 || !Character.isLetter(laLetra.charAt(0)));
     return laLetra;
   }

   public static boolean letraEnPalabraSecreta(String letra, String palSecreta) {
     return palSecreta.contains(letra);
   }
}
 
