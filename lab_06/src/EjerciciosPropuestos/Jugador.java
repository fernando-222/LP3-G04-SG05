package EjerciciosPropuestos;
import java.util.ArrayList;
import java.util.List;
public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private List<Item> inventario;
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = 1;
        this.inventario = new ArrayList<>();
    }
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public List<Item> getInventario() { return inventario; }
    public void agregarItem(Item item) { inventario.add(item); }
    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }
    public void usarPocion() {
        for (Item it : inventario) {
            if (it.getNombre().toLowerCase().contains("poción")) {
                salud += 20;
                if (salud > 100) salud = 100;
                inventario.remove(it);
                System.out.println(nombre + " usa " + it.getNombre() + " y recupera 20 de salud.");
                return;
            }
        }
        System.out.println("No tienes pociones en tu inventario.");
    }
    public void atacar(Enemigo enemigo) {
        int daño = (int)(Math.random() * 20) + 10;
        enemigo.recibirDaño(daño);
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " causando " + daño + " de daño.");
    }
    @Override
    public String toString() {
        return String.format("%s | Salud: %d | Nivel: %d | Ítems: %d",
                nombre, salud, nivel, inventario.size());
    }
}
