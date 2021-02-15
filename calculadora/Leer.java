package calculadora;

import java.io.BufferedReader;
import java.io.IOException;

public class Leer {
  private final static BufferedReader entradaConsola = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

  public static String leerTexto(String mensaje) {
    String respuesta = null;
    do {
      try {
        System.out.print(mensaje);
        respuesta = entradaConsola.readLine();
      } catch (IOException ex) {
        return "";
      }
    } while (respuesta == null);
    return respuesta;
  }

  public static int leerEntero(String mensaje) {
    int n = 0;
    boolean correcto = false;
    while (!correcto) {
      try {
        n = Integer.parseInt(leerTexto(mensaje));
        correcto = true;
      } catch (NumberFormatException ex) {
        System.out.println("Tienes que introducir un número correcto");
      }
    }
    return n;
  }

  public static double leerDouble(String mensaje) {
    double n = 0.0;
    boolean correcto = false;
    while (!correcto) {
      try {
        n = Double.parseDouble(leerTexto(mensaje));
        correcto = true;
      } catch (NumberFormatException ex) {
        System.out.println("Tienes que introducir un número correcto");
      }
    }
    return n;
  }

  public static float leerFloat(String mensaje) {
    float n = 0;
    boolean correcto = false;
    while (!correcto) {
      try {
        n = Float.parseFloat(leerTexto(mensaje));
        correcto = true;
      } catch (NumberFormatException ex) {
        System.out.println("Tienes que introducir un número correcto");
      }
    }
    return n;
  }
}
