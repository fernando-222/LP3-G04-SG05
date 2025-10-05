package experiencias_practicas;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial;
    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }
    public void agregarPedido(Pedido p) { pedidos.add(p); }

    public boolean eliminarPorId(int id) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == id) {
                Pedido p = pedidos.remove(i);
                p.marcarEliminado();
                historial.add(p);
                return true;
            }
        }
        return false;
    }
    public boolean actualizar(int id, String nuevoNombre, String nuevoTipo) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                p.setNombrePlato(nuevoNombre);
                p.setTipo(nuevoTipo);
                return true;
            }
        }
        return false;
    }
    public boolean marcarCompleto(int id) {
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            if (p.getId() == id) {
                p.marcarCompleto();
                pedidos.remove(i);
                historial.add(p);
                return true;
            }
        }
        return false;
    }
    public List<Pedido> listar() { return new ArrayList<>(pedidos); }
    public List<Pedido> buscarPorNombre(String texto) {
        return pedidos.stream().filter(p -> p.getNombrePlato().toLowerCase().contains(texto.toLowerCase())).collect(Collectors.toList());
    }
    public List<Pedido> buscarPorTipo(String tipo) {
        return pedidos.stream().filter(p -> p.getTipo().equalsIgnoreCase(tipo)).collect(Collectors.toList());
    }
    public int contarTotal() { return pedidos.size(); }

    public long contarPorTipo(String tipo) {
        return pedidos.stream().filter(p -> p.getTipo().equalsIgnoreCase(tipo)).count();
    }
    public List<Pedido> listarPorEstado(EstadoPedido estado) {
        if (estado == EstadoPedido.PENDIENTE) {
            return pedidos.stream().filter(p -> p.getEstado() == EstadoPedido.PENDIENTE).collect(Collectors.toList());
        } else {
            return historial.stream().filter(p -> p.getEstado() == estado).collect(Collectors.toList());
        }
    }
    public int contarPendientes() {
        return (int) pedidos.stream().filter(p -> p.getEstado() == EstadoPedido.PENDIENTE).count();
    }	
    public List<Pedido> getHistorial() { return new ArrayList<>(historial); }
}

