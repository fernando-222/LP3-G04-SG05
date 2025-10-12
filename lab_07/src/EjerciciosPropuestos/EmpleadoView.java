package EjerciciosPropuestos;
import java.util.*;
public class EmpleadoView {
 private EmpleadoController controller;
 public EmpleadoView(EmpleadoController c) {
     this.controller = c;
 }
 public void menu() {
     Scanner sc = new Scanner(System.in);
     while (true) {
         System.out.println("1 Listar 2 Agregar 3 Buscar 4 Eliminar 0 Salir");
         int op = Integer.parseInt(sc.nextLine());

         if (op == 0)
             break;

         switch (op) {
             case 1:
                 for (Empleado e : controller.listar()) {
                     System.out.println(e);
                 }
                 break;
             case 2:
                 System.out.print("Num: ");
                 int n = Integer.parseInt(sc.nextLine());
                 System.out.print("Nombre: ");
                 String nm = sc.nextLine();
                 System.out.print("Sueldo: ");
                 double s = Double.parseDouble(sc.nextLine());
                 System.out.println(controller.agregar(n, nm, s) ? "Agregado" : "Número ya existe");
                 break;
             case 3:
                 System.out.print("Num a buscar: ");
                 Empleado be = controller.buscar(Integer.parseInt(sc.nextLine()));
                 System.out.println(be == null ? "No encontrado" : be);
                 break;
             case 4:
                 System.out.print("Num a eliminar: ");
                 System.out.println(controller.eliminar(Integer.parseInt(sc.nextLine())) ? "Eliminado" : "No encontrado");
                 break;
         }
     }
 }
}

