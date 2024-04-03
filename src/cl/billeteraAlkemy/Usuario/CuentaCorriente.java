package cl.billeteraAlkemy.Usuario;

import cl.billeteraAlkemy.Utilitario.Menu;
/**
 * @author:IvánCabrera
 */
abstract public class  CuentaCorriente {
    /**
     * Atributos para un futuro de cuentas corrientes
     */
    protected long numeroCuentaCorriente;
    protected double saldoCuentaCorriente;

    /**
     * Construcctor para pasar los datos de la cuenta
     * @param numeroCuentaCorriente
     * @param saldoCuentaCorriente
     */

    protected CuentaCorriente(long numeroCuentaCorriente, double saldoCuentaCorriente) {
       this.numeroCuentaCorriente =numeroCuentaCorriente;
       this.saldoCuentaCorriente = saldoCuentaCorriente;
    }



    //cambiar el static en el futuro
    public static void crearCuentaCorriente() {
        System.out.println("-------------------------------------------------");
        System.out.println("Esta funcionalidad estará proximamente disponible");
        System.out.println("-------------------------------------------------");
        Menu.accesoMenu2 = false;
    }
    protected void depositarCuentaCorriente() {}

    protected void retirarCuentaCorriente() {}
}
