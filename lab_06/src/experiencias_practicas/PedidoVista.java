package experiencias_practicas;
import java.util.List;
import java.util.Scanner;
public class PedidoVista {
    private Scanner sc = new Scanner(System.in);
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ PEDIDOS (Actividad 3 - Completo) ---");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Eliminar pedido por ID");
        System.out.println("4. Actualizar pedido");
        System.out.println("5. Buscar por nombre");
        System.out.println("6. Buscar por tipo");
        System.out.println("7. Contar pedidos");
        System.out.println("8. Marcar como completo");
        System.out.println("9. Mostrar por estado");
        System.out.println("10. Contador pendientes");
        System.out.println("11. Mostrar historial");
        System.out.println("12. Salir");
    }
    public String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
    public int leerEntero(String msg) {
        System.out.print(msg);
        try { return Integer.parseInt(sc.nextLine()); } catch (Exception e) { return -1; }
    }
    public void mostrarPedidos(List<Pedido> lista) {
        if (lista.isEmpty()) System.out.println("No hay pedidos.");
        else lista.forEach(System.out::println);
    }
    public void mostrarMensaje(String m) { System.out.println(m); }
}
