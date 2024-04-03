package cl.billeteraAlkemy.Utilitario;

import cl.billeteraAlkemy.Usuario.Cuenta;
import cl.billeteraAlkemy.Usuario.CuentasGuardadas;

import java.util.List;
import java.util.Scanner;
/**
 * @author:IvánCabrera
 */

public class Transacciones extends Cuenta implements CuentasGuardadas {
    private List<Cuenta> listaCuentasUsuarios;
    public Transacciones(List<Cuenta> listaCuentasUsuarios){
        this.listaCuentasUsuarios = listaCuentasUsuarios;
    }



    /**
     * Construcor con los datos para pasarlos a cuenta
     */
    public Transacciones(String nombreCuenta, String nombreCliente, String rutCliente, String correoElectronico,
                         String numeroCuenta, double saldoCuenta, String claveCuenta) {
        super(nombreCuenta, nombreCliente, rutCliente, correoElectronico, numeroCuenta, saldoCuenta, claveCuenta);

    }

    /**
     * Construcctor para en un futuro guardar los datos de los clientes para depositar
     * @param nombreClienteDepositar
     * @param rutClienteDepositar
     * @param numeroCuentaDepositar
     * @param correoElectronicoDepositar
     */
    private Transacciones(String nombreClienteDepositar, long rutClienteDepositar, String numeroCuentaDepositar,
                         String correoElectronicoDepositar) {

    }

    /**
     *Método para transferir dinero a una cuenta y guardarla
     */
    public void transferirMonto(Scanner scanner){
        System.out.println("Ingrese el RUT de la cuenta que desea transferir (sin número verificardor): ");
        long rutClienteDepositar = scanner.nextLong();
        System.out.println("Ingrese el nombre y apellido a quién desea depositar:");
        String nombreClienteDepositar = scanner.next();
        System.out.println("Ingrese el email a quién desea depositar:");
        String correoElectronicoRaraDepositar = scanner.next();
        System.out.println("Ingrese el número de cuenta a quién desea depositar:");
        String numeroCuentaDepositar = scanner.next();
        System.out.println("Ingrese el monto a depositar:");
        double montoDepositar = scanner.nextDouble();

        System.out.println("Desea guardar la cuenta? (S/N)");
        String respuestaDepositar = scanner.next();
        if (respuestaDepositar.equalsIgnoreCase("S")){
        Transacciones cuentaDepositar = new Transacciones(nombreClienteDepositar,rutClienteDepositar,
                numeroCuentaDepositar,correoElectronicoRaraDepositar);
                CuentasGuardadas.add(cuentaDepositar);
                System.out.println("Cuenta guardada con éxito");
        }

        System.out.println("Ingrese su usuario para validar la operación");
        String usuarioValidador = scanner.next();

        System.out.println("Ingrese su contraseña para validar la operación");
        String contrasenaValidador = scanner.next();

        // Encuentra la cuenta del usuario logeado para actualizar el saldo y validar la operacion
        Cuenta cuentaSeleccionada = null;
        for (Cuenta cuenta : listaCuentasUsuarios) {
            if (contrasenaValidador.equals(cuenta.getClaveCuenta()) && usuarioValidador.equals(cuenta.getNombreCuenta()))  {
                    cuentaSeleccionada = cuenta;
                    cuenta.getNumeroCuenta();
                    break;
                }
            }
        if (cuentaSeleccionada!= null) {
            double saldoActual = cuentaSeleccionada.getSaldoCuenta();

            cuentaSeleccionada.setSaldoCuenta(saldoActual-montoDepositar);

            double saldoFinal = cuentaSeleccionada.getSaldoCuenta();

            System.out.println("Transferencia realizada con éxito.Nuevo saldo: $" + cuentaSeleccionada.getSaldoCuenta());

        }else {
            System.out.println("Contraseña o clave incorrecta. Inténtelo de nuevo.");
        }
        Menu.accesoMenu2 = false;


    }



//Metodos para en un futuro guardar los datos de los clientes para depositar

    @Override
    public void guardarCuenta(CuentasGuardadas cuentasGuardadas) {

    }

    @Override
    public void mostrarCuentasGuardadas() {

    }
}
