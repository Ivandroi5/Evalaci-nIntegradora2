package cl.billeteraAlkemy.Utilitario;

import cl.billeteraAlkemy.Utilitario.Menu;
import cl.billeteraAlkemy.Utilitario.Verificador;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author:IvánCabrera
 */

public class VerificadorTest {

    /**
     * Test verificador se intancia la clase que se va a probar en el test
     */
    private Verificador verificadorTest;

    /**
     * Capturador de salida para verificar la salidas por pintln
     */
    private final ByteArrayOutputStream simularEntrada = new ByteArrayOutputStream();
    /**
     *  Se crea la entrada original para poder restaurarla despues del test
     */
    private final InputStream entradaOrigianl = System.in;

    /**
     * Instancia verificadorTest y dirige las salidas de los print a nuestro capturadorSalida
     */
    @BeforeEach
    public void configuración() {
        verificadorTest = new Verificador();
        System.setOut(new PrintStream(simularEntrada));
    }

    @Test
    public void testVerificarEdadRespuesta_n_() {
        // Arrange
        String entrada = "n\n";
        /*
          Se transforma la entrada en un arreglo de bytes para poder simularla, dado que "System" solo funciona con bytes
         */
        System.setIn(new ByteArrayInputStream(entrada.getBytes()));


        verificadorTest.verificarEdad();


        assertEquals("Programa dirigido solo a mayores de 18 años", simularEntrada.toString().trim());
        assertEquals(true, Menu.accesoMenu1);
        assertEquals(true, Menu.accesoMenu2);
    }

    @Test
    public void testVerificarEdadRespuesta_s_() {
        String entrada = "s\n";
        /*
          Se transforma la entrada en un arreglo de bytes para poder simularla, dado "System" solo funciona con bytes
         */
        System.setIn(new ByteArrayInputStream(entrada.getBytes()));


        verificadorTest.verificarEdad();


        assertEquals("Accediendo...", simularEntrada.toString().trim());
        assertEquals(false, Menu.accesoMenu1);
        assertEquals(false, Menu.accesoMenu2);
    }

    @Test
    public void testVerificarEdadRespuesta_otro_() {
        String entrada = "otro\n";
        /*
          Se transforma la entrada en un arreglo de bytes para poder simularla, dado "System" solo funciona con bytes
         */
        System.setIn(new ByteArrayInputStream(entrada.getBytes()));


        verificadorTest.verificarEdad();


        assertEquals("Comando ingresado no válido, ingrese s o n", simularEntrada.toString().trim());
        assertEquals(true, Menu.accesoMenu1);
        assertEquals(true, Menu.accesoMenu2);
    }

    /**
     * Se regresa la entrada original al sistema para no interrrupir los otros tests
     */

    @AfterEach
    public void restauradorEntrada() {
        System.setIn(entradaOrigianl);
    }
}
