import cl.billeteraAlkemy.Usuario.CuentaCorriente;
import cl.billeteraAlkemy.Utilitario.Menu;
import cl.billeteraAlkemy.Usuario.Cuenta;
import cl.billeteraAlkemy.Utilitario.Monedas.Dolar;
import cl.billeteraAlkemy.Utilitario.Monedas.Euro;
import cl.billeteraAlkemy.Utilitario.Monedas.Uf;
import cl.billeteraAlkemy.Utilitario.Transacciones;
import cl.billeteraAlkemy.Utilitario.Verificador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:IvánCabrera
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta usuario1 = new Cuenta("", "", "0", "", "0",
                0, "");
        List<Cuenta> listaCuentasUsuarios = new ArrayList<>();
        Transacciones movimientos = new Transacciones(listaCuentasUsuarios);
        Dolar dolar = new Dolar();
        Euro euro = new Euro();
        Uf uf = new Uf();


        // verificar edad

        Menu.preguntarEdad();
        Verificador.verificarEdad();

        // Primera pantalla de bienvenida

        Menu.nombreApp();
        /**
         while booleano para volver al menú mientras sea falso
         menú para entrar
         */
        while (!Menu.accesoMenu1) {

            Menu.pantallaIngreso();
            Menu.menu = scanner.nextInt();
            switch (Menu.menu) {
                case 1:
                    usuario1.accesoUsuarios(scanner);
                    break;
                case 2:
                    Cuenta nuevaCuenta = usuario1.crearCuentaNueva(scanner);
                    listaCuentasUsuarios.add(nuevaCuenta);
                    break;
                default:
                    System.out.println("Comando ingresado no válido, ingrese 1 o 2");
                    break;
            }

        }
        /**
         * Segundo while para navegar por las opciones disponibles en la cuenta
         */
        while (!Menu.accesoMenu2) {

            Menu.pantallaCuenta();
            Menu.menu = scanner.nextInt();
            switch (Menu.menu) {
                case 1:
                    usuario1.mostrarSaldoCuenta();
                    Menu.accesoMenu2 = false;
                    break;
                case 2:
                    float dolarSaldo= (float) (usuario1.getSaldoCuenta() / dolar.valorDolar);
                    System.out.println("Su saldo en Dolar es: " + dolar.simboloDolar + dolarSaldo);
                    float euroSaldo= (float) (usuario1.getSaldoCuenta() /euro.valorEuro);
                    System.out.println("Su saldo en Euro es: " + euro.simboloEuro + euroSaldo); ;
                    float ufSaldo= (float) (usuario1.getSaldoCuenta()/uf.valorUf);
                    System.out.println("Su saldo en UF es: " + uf.simboloUF + ufSaldo);
                    Menu.accesoMenu2 = false;
                    break;
                case 3:
                    usuario1.mostrarCliente();
                    usuario1.getNumeroCuenta();
                    Menu.accesoMenu2 = false;
                    break;
                case 4:
                    movimientos.transferirMonto(scanner);
                    break;
                case 5:
                    CuentaCorriente.crearCuentaCorriente();
                    Menu.accesoMenu2 = false;
                    break;
                case 6:
                    Menu.accesoMenu2 = true;
                    break;
                default:
                    System.out.println("Comando ingresado no válido, ingrese del 1 al 5");
                    break;
            }


        }
        scanner.close();

    }
}