package cl.billeteraAlkemy.Usuario;
/**
 * @author:IvánCabrera
 */
public class Cliente {

    protected String nombreCliente;

    protected String rutCliente;

    protected String correoElectronico;

    public String getNombreCliente() {
        return nombreCliente;
    }


    public String getRutCliente() {
        return rutCliente;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }


    /**
     * Constructor con los datos del cliente
     * @param nombreCliente
     * @param rutCliente
     * @param correoElectronico
     */
    public Cliente(String nombreCliente, String rutCliente, String correoElectronico) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.correoElectronico = correoElectronico;
    }


    public Cliente() {

    }

    /**
     * Método para mostrar los datos del cliente
     */
    public void mostrarCliente (){
        System.out.println("Datos: "+ nombreCliente );
        System.out.println("Rut: "+ rutCliente);
        System.out.println("Correo electrónico: "+ correoElectronico);
    }
}
