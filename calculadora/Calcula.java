package calculadora;

import java.io.IOException;

import com.github.lalyos.jfiglet.FigletFont;


public class Calcula {
  private static float operand1;
  private static float operand2;

  private static float param1;
  private static float param2;

  private static boolean parametros;  // Check para comprobar si hay parámetros establecidos.

  public static void main(String[] args) throws IOException {

    boolean menu = true;
    parametros = false; // Establecemos desde el inicio los parametros a false para que no pueda iniciar el menú sin ponérselos.

    do {
      // Se ejecuta el menú hasta que `menu` sea falso.
      System.out.println(FigletFont.convertOneLine("MENU"));  // Letrero de menú creado con JFiglet
      tiempo(1);
      menu = opcionesIniciales(args);  // Llamamos a la función que contiene todo.
    } while (menu);
  }

  private static boolean opcionesIniciales(String[] args) throws IOException {
    int opc = 0;
    System.out.println("1.- Iniciar");
    System.out.println("2.- Ajustes");
    System.out.println("3.- Salir");
    do {
      opc = Leer.leerEntero("Selecciona una opción (1-3): ");
    } while (opc < 1 || opc > 3);

    switch (opc) {
      case 0:
        param1 = 4;
        param2 = 3;
        parametros = true;
        break;
      case 1:
        if (parametros) {
          inicio();
        } else {
          System.out.println("No se ha podido iniciar el programa, tienes que establecer los parámetros antes de empezar.");
          tiempo(2);
          ajustes(args);
        }
        break;
      case 2:
        ajustes(args);
        break;
      case 3:
        return false;
      default:
        System.out.println("Error en el menú.");
        tiempo(2);
    }
    return true;
  }

  private static void inicio() throws IOException {
    boolean operacion = true;

    do {
      int opc = 0;
      System.out.println(FigletFont.convertOneLine("Calculadora"));
      System.out.println();
      System.out.println("1.- Suma");
      System.out.println("2.- Resta");
      System.out.println("3.- Multiplicación");
      System.out.println("4.- División");
      System.out.println("5.- Mayor Que");
      System.out.println("6.- Es Primo");
      System.out.println("7.- Siguiente Primo");
      System.out.println("8.- Salir");

      do {
        opc = Leer.leerEntero("Selecciona una opción (1-8): ");
      } while (opc < 1 || opc > 8);
      tiempo(1);
      Calculadora myCalc = new Calculadora();
      switch (opc) {
        case 1:
          System.out.println("La suma entre " + param1 + " y " + param2 + " és " + myCalc.suma(param1, param2));
          break;
        case 2:
          System.out.println("La resta entre " + param1 + " y " + param2 + " és " + myCalc.resta(param1, param2));
          break;
        case 3:
          System.out.println("La multiplicación entre " + param1 + " y " + param2 + " és " + myCalc.multiplica(param1, param2));
          break;
        case 4:
          System.out.println("La división entre " + param1 + " y " + param2 + " és " + myCalc.divideix(param1, param2));
          break;
        case 5:
          System.out.println("El mayor entre " + param1 + " y " + param2 + " és " + myCalc.majorque(param1, param2));
          break;
        case 6:
          if (myCalc.esPrim(param1)) {
            System.out.println("El número " + param1 + " ÉS primo.");
          } else {
            System.out.println("El número " + param1 + " NO és primo.");
          }
          break;
        case 7:
          System.out.println("El siguiente número primo de " + param1 + " es " + myCalc.proximPrim(param1));
          break;
        case 8:
          operacion = false;
          break;
        default:
          System.out.println("Opción no válida.");
      }
      if (operacion){
        System.out.println("Última operació realizada: " + myCalc.getLastOp() + "; Último resultado: " + myCalc.getLastResult());
      }
      String X = Leer.leerTexto("Presiona ENTER para continuar.");
    } while (operacion);
  }

  private static void ajustes(String[] args) throws IOException {
    boolean ajust = true;
    do {
      int opc = 0;
      System.out.println(FigletFont.convertOneLine("Ajustes"));
      System.out.println();
      System.out.println("1.- Usar los parámetros");
      System.out.println("2.- Introducir nuevos parámetros");
      System.out.println("3.- Consultar los parámetros actuales");
      System.out.println("4.- Salir");
      System.out.println();
      do {
        opc = Leer.leerEntero("Selecciona una opción (1-4): ");
      } while (opc < 1 || opc > 4);
      switch (opc) {
        case 1:
          if (args.length != 2) {
            System.out.println("\nTienes que introducir 2 parámetros en la ejecución para poder usar esta opción.");
            break;
          }
          operand1 = Float.parseFloat(args[0]);
          operand2 = Float.parseFloat(args[1]);
          System.out.println();
          System.out.println("Usando los parámetros definidos al iniciar:");
          System.out.println("Parámetro 1: " + operand1);
          System.out.println("Parámetro 2: " + operand2);
          param1 = operand1;
          param2 = operand2;
          parametros = true;
          break;
        case 2:
          boolean params = true;
          System.out.println();
          System.out.println("Introducir parámetros manualmente.");
          do {
            String ch = "";
            param1 = Leer.leerFloat("Introduce el primer parámetro: ");
            param2 = Leer.leerFloat("Introduce el segundo parámetro: ");
            System.out.println();
            System.out.println("Has introducido los siguientes parámetros: P1-> " + param1 + " P2-> " + param2);
            do {
              ch = Leer.leerTexto("¿Los parámetros introducidos son correctos? (s/n): ");
            } while (!ch.equalsIgnoreCase("s") && !ch.equalsIgnoreCase("n"));
            if (ch.equalsIgnoreCase("s")) {
              params = false;
              parametros = true;
            } else {
              System.out.println("Vuelve a introducir los parámetros");
            }
          } while (params);
          break;
        case 3:
          System.out.println("Parámetros actuales:");
          System.out.println("Parámetro 1: " + param1);
          System.out.println("Parámetro 2: " + param2);
          break;
        case 4:
          System.out.println("Saliendo de Ajustes.");
          ajust = false;
          break;
        default:
          System.out.println("Opción no válida.");
      }
      tiempo(2);

    } while (ajust);
  }

  private static void tiempo(int segundos) {
    int ms = segundos*1000;
    try{
      Thread.sleep(ms);
    }
    catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

}
