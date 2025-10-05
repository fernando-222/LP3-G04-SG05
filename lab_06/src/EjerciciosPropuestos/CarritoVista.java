package EjerciciosPropuestos;
import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner sc = new Scanner(System.in);
    public void mostrarMenu() {
        System.out.println("\n--- CARRITO DE COMPRAS ---");
        System.out.println("1. Listar catálogo");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar producto del carrito");
        System.out.println("5. Aplicar descuento y calcular total");
        System.out.println("6. Realizar compra");
        System.out.println("7. Ver historial de compras");
        System.out.println("8. Salir");
    }
    public String leerLinea(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
    public int leerInt(String msg) {
        System.out.print(msg);
        try { return Integer.parseInt(sc.nextLine()); } catch (Exception e) { return -1; }
    }
    public double leerDouble(String msg) {
        System.out.print(msg);
        try { return Double.parseDouble(sc.nextLine()); } catch (Exception e) { return 0.0; }
    }
    public void mostrarCatalogo(List<Producto> catalogo) {
        System.out.println("Catálogo:");
        catalogo.forEach(System.out::println);
    }
    public void mostrarCarrito(List<CartItem> items, double subtotal) {
        if (items.isEmpty()) { System.out.println("Carrito vacío."); return; }
        System.out.println("Carrito:");
        items.forEach(System.out::println);
        System.out.printf("Subtotal: S/ %.2f%n", subtotal);
    }
    public void mostrarMensaje(String m) { System.out.println(m); }
}
