package cl.billeteraAlkemy.Usuario;

import java.util.ArrayList;
import java.util.List;
/**
 * @author:IvánCabrera
 */

public interface CuentasGuardadas {

    public List<CuentasGuardadas> CuentasGuardadas = new ArrayList<>();

    public void guardarCuenta(CuentasGuardadas cuentasGuardadas);


    public void mostrarCuentasGuardadas();


}
