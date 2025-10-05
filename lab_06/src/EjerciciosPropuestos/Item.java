package EjerciciosPropuestos;
public class Item {
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;
    public Item(int id, String nombre, String categoria, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }
    @Override
    public String toString() {
        return String.format("ID:%d | %s | %s | Cant:%d | S/ %.2f",
                id, nombre, categoria, cantidad, precio);
    }
}

