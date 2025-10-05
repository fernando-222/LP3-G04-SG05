package EjerciciosPropuestos;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarritoModelo {
    private List<Producto> catalogo;
    private List<CartItem> carrito;
    private List<List<CartItem>> historial;
    public CarritoModelo() {
        catalogo = new ArrayList<>();
        carrito = new ArrayList<>();
        historial = new ArrayList<>();
    }
    public void agregarProductoCatalogo(Producto p) { catalogo.add(p); }
    public List<Producto> getCatalogo() { return new ArrayList<>(catalogo); }

    public boolean agregarAlCarrito(int productoId, int cantidad) {
        Optional<Producto> prod = catalogo.stream().filter(p -> p.getId() == productoId).findFirst();
        if (prod.isEmpty() || cantidad <= 0) return false;
        for (CartItem it : carrito) {
            if (it.getProducto().getId() == productoId) {
                it.setCantidad(it.getCantidad() + cantidad);
                return true;
            }
        }
        carrito.add(new CartItem(prod.get(), cantidad));
        return true;
    }
    public boolean removerDelCarrito(int productoId) {
        return carrito.removeIf(it -> it.getProducto().getId() == productoId);
    }
    public List<CartItem> verCarrito() { return new ArrayList<>(carrito); }

    public double subtotalCarrito() { return carrito.stream().mapToDouble(CartItem::subtotal).sum(); }

    public double aplicarDescuento(double porcentaje) {
        if (porcentaje <= 0) return subtotalCarrito();
        double sub = subtotalCarrito();
        return sub * (1 - porcentaje / 100.0);
    }
    public double calcularEnvio(double subtotal) {
        return subtotal > 100.0 ? 0.0 : 10.0;
    }
    public void realizarCompra(double descuentoPorcentaje) {
        double sub = aplicarDescuento(descuentoPorcentaje);
        double envio = calcularEnvio(sub);
        historial.add(new ArrayList<>(carrito));
        carrito.clear();
    }
    public List<List<CartItem>> getHistorial() { return new ArrayList<>(historial); }
}
