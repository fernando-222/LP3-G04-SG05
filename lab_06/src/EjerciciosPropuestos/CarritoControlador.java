package EjerciciosPropuestos;
import java.util.List;
public class CarritoControlador {
    private CarritoModelo modelo;
    private CarritoVista vista;
    public CarritoControlador(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void iniciar() {
        String op;
        do {
            vista.mostrarMenu();
            op = vista.leerLinea("Opción: ");
            switch (op) {
                case "1": vista.mostrarCatalogo(modelo.getCatalogo()); break;
                case "2": agregarAlCarrito(); break;
                case "3": vista.mostrarCarrito(modelo.verCarrito(), modelo.subtotalCarrito()); break;
                case "4": eliminarDelCarrito(); break;
                case "5": aplicarDescuentoCalcular(); break;
                case "6": realizarCompra(); break;
                case "7": mostrarHistorial(); break;
                case "8": vista.mostrarMensaje("Saliendo..."); break;
                default: vista.mostrarMensaje("Opción inválida.");
            }
        } while (!op.equals("8"));
    }
    private void agregarAlCarrito() {
        int id = vista.leerInt("ID producto: ");
        int qty = vista.leerInt("Cantidad: ");
        boolean ok = modelo.agregarAlCarrito(id, qty);
        vista.mostrarMensaje(ok ? "Agregado." : "Producto no encontrado o cantidad inválida.");
    }
    private void eliminarDelCarrito() {
        int id = vista.leerInt("ID producto a eliminar: ");
        boolean ok = modelo.removerDelCarrito(id);
        vista.mostrarMensaje(ok ? "Eliminado." : "No estaba en el carrito.");
    }
    private void aplicarDescuentoCalcular() {
        double pct = vista.leerDouble("Descuento (%) a aplicar: ");
        double subtotal = modelo.subtotalCarrito();
        double montoConDescuento = subtotal - (subtotal * pct / 100.0);

        double envio = modelo.calcularEnvio(montoConDescuento);
        double total = montoConDescuento + envio;

        vista.mostrarMensaje(String.format(
            "Subtotal original: S/ %.2f\nDescuento aplicado: %.2f%%\nSubtotal con descuento: S/ %.2f\nEnvío: S/ %.2f\nTotal a pagar: S/ %.2f",
            subtotal, pct, montoConDescuento, envio, total
        ));
    }
    private void realizarCompra() {
        double pct = vista.leerDouble("Descuento (%) a aplicar en la compra: ");
        modelo.realizarCompra(pct);
        vista.mostrarMensaje("Compra realizada. Carrito vaciado y guardado en historial.");
    }
    private void mostrarHistorial() {
        List<List<CartItem>> h = modelo.getHistorial();
        if (h.isEmpty()) { vista.mostrarMensaje("No hay compras previas."); return; }
        System.out.println("Historial de compras:");
        int nro = 1;
        for (List<CartItem> compra : h) {
            System.out.println("Compra #" + (nro++));
            compra.forEach(ci -> System.out.println("  " + ci));
        }
    }
}

