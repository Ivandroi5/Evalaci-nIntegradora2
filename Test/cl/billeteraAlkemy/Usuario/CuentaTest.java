package cl.billeteraAlkemy.Usuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
/**
 * @author:IvánCabrera
 */

class CuentaTest {

    /**
     * Test para verificar que el saldo de la cuenta no es 5000
     */
    @Test
    public void testMostrarSaldoCuenta() {

        Cuenta cuenta = new Cuenta();
        cuenta.setSaldoCuenta(0);

        cuenta.mostrarSaldoCuenta();

        assertEquals(5000, cuenta.getSaldoCuenta());
    }


    @Test
    void accesoUsuarios() {
    }
    @Test
    public void testGenerarNumeroCuenta() {
        Cuenta cuenta = new Cuenta();
        String numeroCuenta = cuenta.generarNumeroCuenta();

        // Verifica que tenga 10 digitos de largo
        assertTrue(numeroCuenta.length() == 10);

        // Verifica que tenga solo digitos
        assertTrue(numeroCuenta.matches("\\d+"));

        // Verifica que tenga 00 en el prefijo
        assertTrue(numeroCuenta.startsWith("00"));

    }
}
