package experiencias_practicas;
import java.time.LocalDateTime;
public class Pedido {
    private static int contador = 0;
    private final int id;
    private String nombrePlato;
    private String tipo;
    private EstadoPedido estado;
    private LocalDateTime creadoEn;
    private LocalDateTime completadoEn;
    public Pedido(String nombrePlato, String tipo) {
        this.id = ++contador;
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.estado = EstadoPedido.PENDIENTE;
        this.creadoEn = LocalDateTime.now();
    }
    public int getId() { return id; }
    public String getNombrePlato() { return nombrePlato; }
    public String getTipo() { return tipo; }
    public EstadoPedido getEstado() { return estado; }
    public void setNombrePlato(String nombre) { this.nombrePlato = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void marcarCompleto() {
        this.estado = EstadoPedido.COMPLETO;
        this.completadoEn = LocalDateTime.now();
    }
    public void marcarEliminado() {
        this.estado = EstadoPedido.ELIMINADO;
    }
    @Override
    public String toString() {
        return String.format("ID:%d | %s (%s) - %s", id, nombrePlato, tipo, estado);
    }
}

