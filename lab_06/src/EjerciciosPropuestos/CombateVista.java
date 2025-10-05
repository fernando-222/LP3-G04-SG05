package EjerciciosPropuestos;
import java.util.Scanner;
public class CombateVista {
    private Scanner sc = new Scanner(System.in);
    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n--- ESTADO DEL COMBATE ---");
        System.out.println(jugador);
        System.out.println(enemigo);
    }
    public String leerAccion() {
        System.out.println("\nAcciones:");
        System.out.println("1. Atacar");
        System.out.println("2. Usar poción");
        System.out.println("3. Rendirse / Salir del combate");
        System.out.print("Seleccione: ");
        return sc.nextLine();
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
