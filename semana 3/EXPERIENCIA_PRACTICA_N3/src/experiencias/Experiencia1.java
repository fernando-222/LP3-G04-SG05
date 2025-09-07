package experiencias;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Experiencia1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de habitación
        System.out.println("=== REGISTRO DE HABITACIÓN ===");
        System.out.print("Ingrese ID de habitación: ");
        String idHabitacion = sc.nextLine();
        System.out.print("Ingrese tipo de habitación: ");
        String tipo = sc.nextLine();
        System.out.print("Ingrese tarifa base: ");
        double tarifa = sc.nextDouble();

        Habitacion habitacion = new Habitacion(idHabitacion, tipo, tarifa);

        // Reserva inicial
        System.out.println("\n=== CREACIÓN DE RESERVA ===");
        System.out.print("Ingrese fecha de check-in (AAAA-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(sc.next());
        System.out.print("Ingrese fecha de check-out (AAAA-MM-DD): ");
        LocalDate checkOut = LocalDate.parse(sc.next());

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva(idHabitacion, "cli01", checkIn, checkOut));

        // Consulta de disponibilidad
        System.out.println("\n=== CONSULTA DE DISPONIBILIDAD ===");
        System.out.print("Ingrese fecha de inicio de consulta (AAAA-MM-DD): ");
        LocalDate consultaIn = LocalDate.parse(sc.next());
        System.out.print("Ingrese fecha de fin de consulta (AAAA-MM-DD): ");
        LocalDate consultaOut = LocalDate.parse(sc.next());

        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(reservas);
        boolean disponible = gestor.estaDisponible(habitacion, consultaIn, consultaOut);

        System.out.println("\n¿La habitación está disponible en ese rango? " + (disponible ? "Sí" : "No"));

        sc.close();
    }
}

// --- Clases necesarias ---
class Habitacion {
    private final String id;
    private final String tipo;
    private double tarifaBase;
    public Habitacion(String id, String tipo, double tarifaBase){
        this.id=id; this.tipo=tipo; this.tarifaBase=tarifaBase;
    }
    public String getId(){return id;}
    public String getTipo(){return tipo;}
}

class Reserva {
    private final String idHabitacion;
    private final String idCliente;
    private final LocalDate checkIn, checkOut;
    public Reserva(String idHabitacion, String idCliente, LocalDate checkIn, LocalDate checkOut){
        this.idHabitacion=idHabitacion; this.idCliente=idCliente;
        this.checkIn=checkIn; this.checkOut=checkOut;
    }
    public String getIdHabitacion(){return idHabitacion;}
    public LocalDate getCheckIn(){return checkIn;}
    public LocalDate getCheckOut(){return checkOut;}
}

class GestorDisponibilidadHabitacion {
    private final List<Reserva> reservas;
    public GestorDisponibilidadHabitacion(List<Reserva> reservas){ this.reservas=reservas; }
    public boolean estaDisponible(Habitacion h, LocalDate in, LocalDate out){
        return reservas.stream()
            .filter(r -> r.getIdHabitacion().equals(h.getId()))
            .noneMatch(r -> in.isBefore(r.getCheckOut()) && r.getCheckIn().isBefore(out));
    }
}
