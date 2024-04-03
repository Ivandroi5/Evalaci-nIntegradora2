package cl.billeteraAlkemy.Utilitario;

import java.util.Scanner;
/**
 * @author:IvánCabrera
 */

public class Verificador {


    public static void verificarEdad() {
        Scanner scanner = new Scanner(System.in);
        String respuestaEdad = scanner.nextLine();
        if (respuestaEdad.equalsIgnoreCase("n")) {
            System.out.println("Programa dirigido solo a mayores de 18 años");
            Menu.accesoMenu1 = true;
            Menu.accesoMenu2 = true;

        }else if (respuestaEdad.equalsIgnoreCase("s")){
            System.out.println("Accediendo...");
        }else {
            System.out.println("Comando ingresado no válido, ingrese s o n");
            Menu.accesoMenu1 = true;
            Menu.accesoMenu2 = true;
        }
    }
}
