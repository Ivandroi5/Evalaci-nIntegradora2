package cl.billeteraAlkemy.Usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
/**
 * @author:IvánCabrera
 */

public class ClienteTest {

    /**
     * Test para verificar que se muestren los datos del cliente correctamente
     */
    @Test
    public void testMostrarCliente() {

        String nombreCliente = "Iván Cabrera";
        String rutCliente = "19758632-4";
        String correoElectronico = "ivan@gmail.com";
        Cliente cliente = new Cliente(nombreCliente, rutCliente, correoElectronico);

        cliente.mostrarCliente();

        assertEquals(nombreCliente, cliente.getNombreCliente());
        assertEquals(rutCliente, cliente.getRutCliente());
        assertEquals(correoElectronico, cliente.getCorreoElectronico());
    }
}