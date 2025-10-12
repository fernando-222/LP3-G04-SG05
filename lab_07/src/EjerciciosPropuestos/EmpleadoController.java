package EjerciciosPropuestos;
import java.util.*;
public class EmpleadoController {
    private EmpleadoModel model = new EmpleadoModel();

    public List<Empleado> listar() {
        return model.leerEmpleados();
    }
    public boolean agregar(int num, String nom, double sueldo) {
        return model.agregarEmpleado(new Empleado(num, nom, sueldo));
    }
    public Empleado buscar(int num) {
        return model.buscarEmpleado(num);
    }
    public boolean eliminar(int num) {
        return model.eliminarEmpleado(num);
    }
}
