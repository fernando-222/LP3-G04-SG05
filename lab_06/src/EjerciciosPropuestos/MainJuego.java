package EjerciciosPropuestos;
public class MainJuego {
    public static void main(String[] args) {
        InventarioModelo inventario = new InventarioModelo();
        inventario.agregarItem(new Item(1, "Espada corta", "Arma", 1, 120.0));
        inventario.agregarItem(new Item(2, "Escudo de madera", "Defensa", 1, 80.0));
        inventario.agregarItem(new Item(3, "Poción de salud", "Consumible", 3, 25.0));
        Jugador jugador = new Jugador("Jugador");

        JuegoControlador juego = new JuegoControlador(jugador, inventario);
        juego.iniciar();
    }
}
