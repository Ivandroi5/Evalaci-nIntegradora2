package cl.billeteraAlkemy.Utilitario;
/**
 * @author:IvánCabrera
 */
public class Menu {
    /**
     * Atributos para navegar por el menú a través de un booleano
     */
    public static int menu = 0;
    public static boolean accesoMenu1 = false;
    public static boolean accesoMenu2 = false;

    public static void preguntarEdad(){
        System.out.println("   /**************************\\");
        System.out.println("  /                            \\");
        System.out.println(" / ¿Eres mayor de 18 años? S/N  \\");
        System.out.println(" \\                              /");
        System.out.println("  \\****************************/");

    }

    /**
     * Nombre de la billetera
     */
    public static void nombreApp() {
        System.out.println("-----------------------------------------");
        System.out.println("          Tu Billetera Virtual");
        System.out.println("-----------------------------------------");

    }

    //pantalla para acceder o registrar un usuario
    public static void pantallaIngreso() {
        int i;
        for (i = 1; i <= 2; i++)

            switch (i) {
                case 1:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-Acceso usuarios");
                    System.out.println("-----------------------------------------");
                    break;
                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-Regístrate");
                    System.out.println("-----------------------------------------");
                    break;
            }
        System.out.println("\n(Navegue por el menú con su teclado numérico)");
    }

    /**
     * Pantalla del menú de la cuenta ya iniciada
     */
    public static void pantallaCuenta() {
        int i;
        for (i = 1; i <= 6; i++)

            switch (i) {
                case 1:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-Ver saldo");
                    System.out.println("-----------------------------------------");
                    break;

                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-Ver saldo en otras monedas");
                    System.out.println("-----------------------------------------");
                    break;
                case 3:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-Depositar");
                    System.out.println("-----------------------------------------");
                    break;
                case 4:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-Transferir");
                    System.out.println("-----------------------------------------");
                    break;
                case 5:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-Crear Cuenta Corriente");
                    System.out.println("-----------------------------------------");
                    break;
                case 6:
                    System.out.println("-----------------------------------------");
                    System.out.println(i + "-SALIR");
                    System.out.println("-----------------------------------------");
                    break;


            }
        System.out.println("\n(Navegue por el menú con su teclado numérico)");
    }
}