package EjerciciosPropuestos;
public class CartItem {
    private Producto producto;
    private int cantidad;
    public CartItem(Producto p, int cantidad) {
        this.producto = p;
        this.cantidad = cantidad;
    }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int c) { this.cantidad = c; }
    public double subtotal() { return producto.getPrecio() * cantidad; }
    @Override
    public String toString() {
        return String.format("%s x%d = S/ %.2f", producto.getNombre(), cantidad, subtotal());
    }
}
