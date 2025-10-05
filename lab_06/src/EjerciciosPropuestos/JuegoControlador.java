package EjerciciosPropuestos;
import java.util.Scanner;
public class JuegoControlador {
    private Jugador jugador;
    private InventarioModelo inventario;
    private Scanner sc = new Scanner(System.in);
    public JuegoControlador(Jugador jugador, InventarioModelo inventario) {
        this.jugador = jugador;
        this.inventario = inventario;
    }
    public void iniciar() {
        String op;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ver inventario del jugador");
            System.out.println("2. Agregar ítem del inventario general al jugador");
            System.out.println("3. Iniciar combate");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            op = sc.nextLine();

            switch (op) {
                case "1": mostrarInventarioJugador(); break;
                case "2": transferirItemAlJugador(); break;
                case "3": iniciarCombate(); break;
                case "4": System.out.println("Juego finalizado."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (!op.equals("4"));
    }
    private void mostrarInventarioJugador() {
        System.out.println("\nInventario del jugador:");
        if (jugador.getInventario().isEmpty())
            System.out.println("Vacío.");
        else
            jugador.getInventario().forEach(System.out::println);
    }
    private void transferirItemAlJugador() {
        System.out.println("\nInventario general:");
        inventario.listarItems().forEach(System.out::println);
        System.out.print("Ingrese ID de ítem a transferir: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            inventario.buscarPorId(id).ifPresentOrElse(item -> {
                jugador.agregarItem(item);
                System.out.println("Ítem agregado al jugador.");
            }, () -> System.out.println("Ítem no encontrado."));
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }
    private void iniciarCombate() {
        Enemigo enemigo = new Enemigo("Enemigo	", "Guerrero", 1);
        CombateModelo modeloCombate = new CombateModelo(jugador, enemigo);
        CombateVista vistaCombate = new CombateVista();
        CombateControlador ctrlCombate = new CombateControlador(modeloCombate, vistaCombate);
        ctrlCombate.iniciarCombate();
    }
}
