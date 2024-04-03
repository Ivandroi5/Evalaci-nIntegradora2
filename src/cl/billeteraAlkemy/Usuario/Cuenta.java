package cl.billeteraAlkemy.Usuario;
import cl.billeteraAlkemy.Utilitario.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * @author:IvánCabrera
 */

public class Cuenta extends Cliente {



    Scanner scanner = new Scanner(System.in);

    /**
     * creacion de atributos de la cuenta
     */

    protected String nombreCuenta;
    private String numeroCuenta;
    protected String claveCuenta;
    protected double saldoCuenta;
    protected List<Cuenta> listaCuentasUsuarios = new ArrayList<>();

    public Cuenta() {
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public String getClaveCuenta() {
        return claveCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    /**
     *Geter para obtener el numero de la cuenta
     */
    public String getNumeroCuenta() {

        System.out.println("Su numero de cuenta es: "+numeroCuenta);

        return numeroCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public void mostrarSaldoCuenta() {
        System.out.println("-----------------------------------------");
        System.out.println("El saldo de su cuenta digital es: "+saldoCuenta);
        System.out.println("-----------------------------------------");

    }

    /**
     * Constructor con los datos para pasarlos a cuenta
     *
     */

    public Cuenta(String nombreCuenta, String nombreCliente, String rutCliente, String correoElectronico, String numeroCuenta,
                  double saldoCuenta, String claveCuenta) {
        super(nombreCliente,rutCliente,correoElectronico);
        this.nombreCuenta = nombreCuenta;
        this.claveCuenta = claveCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta =saldoCuenta;
    }

    /**
     * Se crea un método para crear el numero aleatorio de la cuenta
     */
    protected String generarNumeroCuenta() {
        String prefijo = "00"; // prefijo inventado
        int longitudNumeroCuenta = 10 - prefijo.length();
        Random random = new Random();
        StringBuilder builder = new StringBuilder(prefijo);
        for (int i = 0; i < longitudNumeroCuenta; i++) {
            int digito = random.nextInt(10); // Generar un dígito aleatorio entre 0 y 9
            builder.append(digito);
        }
        return builder.toString();
    }


    /**
     * método para registrar un usuario de cuenta
     * se instancia una nueva cuenta y se guarda en la lista de usuarios
     * se detecta error al ingresar datos con espacio se salta la siguiente entrada
     * es decir por cada espacio que ponga en uno de los campos me saltaré un scanner
     */
    public Cuenta crearCuentaNueva(Scanner scanner) {


        System.out.println("Ingrese su nombre completo");
        String scanneoNombreCliente = scanner.next();
        System.out.println("-------------------------------------------------------");
        //en el futurp verificar con rut válido
        System.out.println("Ingrese rut");
        String scanercitoRut = scanner.next();
        System.out.println("-------------------------------------------------------");

        System.out.println("Ingrese su correo electrónico");
        //en el futuro añadir verificado de correo existente y enviar confirmación para continuar
        String scaneoCorreo = scanner.next();
        System.out.println("-------------------------------------------------------");

        System.out.println("Ingrese un nuevo nombre de usuario");
        String scanneoUsuario = scanner.next();
        System.out.println("-------------------------------------------------------");

        System.out.println("Ingrese una nueva contraseña");
        String scaneoContrasena = scanner.next();
        System.out.println("-------------------------------------------------------");


        if (scanneoUsuario.equals(nombreCuenta)) {
            System.out.println("¡El nombre de usuario ya está en uso!");
        } else {
            nombreCuenta = scanneoUsuario;
            nombreCliente = scanneoNombreCliente;
            rutCliente = scanercitoRut;
            correoElectronico =scaneoCorreo;
            numeroCuenta = (generarNumeroCuenta());
            saldoCuenta = 5000;
            claveCuenta = scaneoContrasena;

            System.out.println("¡Usuario creado exitosamente!");

        }
        Menu.accesoMenu1= false;
        Cuenta nuevaCuenta = new Cuenta(nombreCuenta,nombreCliente,rutCliente,correoElectronico,numeroCuenta,saldoCuenta,
        claveCuenta);
        listaCuentasUsuarios.add(nuevaCuenta);
        return nuevaCuenta;
    }
    /**
     * método para acceder con un usuario de cuenta
     * usuarioIgresado se crea para validar con el nombre de la cuenta previamente creado igualmente
     que contraseñaIngresada
     */
    public void accesoUsuarios(Scanner scanner) {

        System.out.println("Ingrese su usuario");
        String usuarioIngresado = scanner.next();
        System.out.print("Ingrese su contraseña: ");
        String contrasenaIngresada = scanner.next();
for (Cuenta cuenta :listaCuentasUsuarios) {
    if (usuarioIngresado.equals(nombreCuenta)) {
        if (contrasenaIngresada.equals(claveCuenta)) {
            System.out.println("---------------------------------");
            System.out.println("¡Inicio de sesión exitoso!");
            System.out.println("---------------------------------");
            System.out.println("| Tu saldo actual es: $" + saldoCuenta + "  |");
            System.out.println("| Número de cuenta: " + numeroCuenta + " |");
            System.out.println("---------------------------------");
            Menu.accesoMenu1 = true;
        } else {
            System.out.println("Contraseña incorrecta. Inténtelo de nuevo.");
            Menu.accesoMenu1 = false;
        }break;
    } else {
        System.out.println("El usuario no existe. Por favor, cree una cuenta primero.");
        Menu.accesoMenu1 = false;

    }

}

    }
}