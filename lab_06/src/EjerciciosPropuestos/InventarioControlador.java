package EjerciciosPropuestos;
import java.util.List;
public class InventarioControlador {
    private InventarioModelo modelo;
    private InventarioVista vista;
    private int contadorId = 0;
    public InventarioControlador(InventarioModelo modelo, InventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerTexto("Seleccione una opción: ");
            switch (opcion) {
                case "1": agregarItem(); break;
                case "2": vista.mostrarItems(modelo.listarItems()); break;
                case "3": buscarPorNombre(); break;
                case "4": actualizarItem(); break;
                case "5": eliminarItem(); break;
                case "6": vista.mostrarMensaje("Cantidad total de ítems: " + modelo.contarItems()); break;
                case "7": vista.mostrarMensaje("Saliendo..."); break;
                default: vista.mostrarMensaje("Opción inválida.");
            }
        } while (!opcion.equals("7"));
    }
    private void agregarItem() {
        String nombre = vista.leerTexto("Nombre del ítem: ");
        String categoria = vista.leerTexto("Categoría: ");
        int cantidad = vista.leerEntero("Cantidad: ");
        double precio = vista.leerDouble("Precio: ");
        Item nuevo = new Item(++contadorId, nombre, categoria, cantidad, precio);
        modelo.agregarItem(nuevo);
        vista.mostrarMensaje("Ítem agregado correctamente.");
    }
    private void buscarPorNombre() {
        String nombre = vista.leerTexto("Ingrese nombre a buscar: ");
        List<Item> resultados = modelo.buscarPorNombre(nombre);
        vista.mostrarItems(resultados);
    }
    private void actualizarItem() {
        int id = vista.leerEntero("ID del ítem a actualizar: ");
        String nombre = vista.leerTexto("Nuevo nombre: ");
        String categoria = vista.leerTexto("Nueva categoría: ");
        int cantidad = vista.leerEntero("Nueva cantidad: ");
        double precio = vista.leerDouble("Nuevo precio: ");
        boolean actualizado = modelo.actualizarItem(id, nombre, categoria, cantidad, precio);
        vista.mostrarMensaje(actualizado ? "Ítem actualizado." : "No se encontró el ítem.");
    }
    private void eliminarItem() {
        int id = vista.leerEntero("ID del ítem a eliminar: ");
        boolean eliminado = modelo.eliminarItem(id);
        vista.mostrarMensaje(eliminado ? "Ítem eliminado." : "No se encontró el ítem.");
    }
}
