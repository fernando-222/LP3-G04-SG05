package experiencias;

import java.util.Scanner;

public class Experiencia4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione servicio:");
        System.out.println("1. Limpieza");
        System.out.println("2. Comida");
        System.out.println("3. Lavandería");
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese ID de habitación: ");
        String idHabitacion = sc.nextLine();

        switch(opcion){
            case 1 -> new ServicioLimpiezaStd().solicitarLimpieza(idHabitacion);
            case 2 -> {
                System.out.print("Ingrese plato: ");
                String plato = sc.nextLine();
                new ServicioComidaStd().pedirComida(idHabitacion, plato);
            }
            case 3 -> new ServicioLavanderiaStd().solicitarLavanderia(idHabitacion);
            default -> System.out.println("Opción inválida");
        }

        sc.close();
    }
}

// --- Interfaces y clases ---
interface ServicioLimpieza { void solicitarLimpieza(String idHabitacion); }
interface ServicioComida { void pedirComida(String idHabitacion,String plato); }
interface ServicioLavanderia { void solicitarLavanderia(String idHabitacion); }

class ServicioLimpiezaStd implements ServicioLimpieza {
    public void solicitarLimpieza(String idHabitacion){
        System.out.println("Limpieza en " + idHabitacion);
    }
}
class ServicioComidaStd implements ServicioComida {
    public void pedirComida(String idHabitacion,String plato){
        System.out.println("Pedido de " + plato + " en " + idHabitacion);
    }
}
class ServicioLavanderiaStd implements ServicioLavanderia {
    public void solicitarLavanderia(String idHabitacion){
        System.out.println("Lavandería en " + idHabitacion);
    }
}
