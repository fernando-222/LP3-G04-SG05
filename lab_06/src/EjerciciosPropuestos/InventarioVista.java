package EjerciciosPropuestos;
import java.util.List;
import java.util.Scanner;
public class InventarioVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE INVENTARIO ---");
        System.out.println("1. Agregar ítem");
        System.out.println("2. Mostrar inventario");
        System.out.println("3. Buscar ítem por nombre");
        System.out.println("4. Actualizar ítem");
        System.out.println("5. Eliminar ítem");
        System.out.println("6. Contar ítems");
        System.out.println("7. Salir");
    }
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try { return Integer.parseInt(scanner.nextLine()); } catch (NumberFormatException e) { return -1; }
    }
    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        try { return Double.parseDouble(scanner.nextLine()); } catch (NumberFormatException e) { return 0.0; }
    }
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    public void mostrarItems(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("No hay ítems registrados.");
            return;
        }
        System.out.println("Inventario actual:");
        items.forEach(System.out::println);
    }
    public void mostrarMensaje(String mensaje) { System.out.println(mensaje); }
}
