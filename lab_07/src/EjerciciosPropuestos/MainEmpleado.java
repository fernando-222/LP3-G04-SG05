package EjerciciosPropuestos;
public class MainEmpleado {
 public static void main(String[] args) {
     EmpleadoController c = new EmpleadoController();
     EmpleadoView v = new EmpleadoView(c);
     v.menu();
 }
}