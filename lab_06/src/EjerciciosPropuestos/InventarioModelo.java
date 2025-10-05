package EjerciciosPropuestos;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class InventarioModelo {
    private List<Item> inventario;
    public InventarioModelo() {
        inventario = new ArrayList<>();
    }
    public void agregarItem(Item item) {
        inventario.add(item);
    }
    public List<Item> listarItems() {
        return new ArrayList<>(inventario);
    }
    public Optional<Item> buscarPorId(int id) {
        return inventario.stream().filter(i -> i.getId() == id).findFirst();
    }
    public List<Item> buscarPorNombre(String nombre) {
        List<Item> resultados = new ArrayList<>();
        for (Item i : inventario) {
            if (i.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(i);
            }
        }
        return resultados;
    }
    public boolean actualizarItem(int id, String nuevoNombre, String nuevaCategoria, int nuevaCantidad, double nuevoPrecio) {
        for (Item i : inventario) {
            if (i.getId() == id) {
                i.setNombre(nuevoNombre);
                i.setCategoria(nuevaCategoria);
                i.setCantidad(nuevaCantidad);
                i.setPrecio(nuevoPrecio);
                return true;
            }
        }
        return false;
    }
    public boolean eliminarItem(int id) {
        return inventario.removeIf(i -> i.getId() == id);
    }
    public int contarItems() {
        return inventario.size();
    }
}
