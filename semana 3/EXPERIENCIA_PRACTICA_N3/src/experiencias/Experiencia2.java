package experiencias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Experiencia2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== RESERVA ===");
        System.out.print("Ingrese fecha de check-in (AAAA-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(sc.next());
        System.out.print("Ingrese fecha de check-out (AAAA-MM-DD): ");
        LocalDate checkOut = LocalDate.parse(sc.next());
        Reserva r = new Reserva("201", "cli02", checkIn, checkOut);

        // Elección de política
        System.out.println("\nSeleccione política de cancelación:");
        System.out.println("1. Flexible");
        System.out.println("2. Moderada");
        System.out.println("3. Estricta");
        int opcion = sc.nextInt();
        PoliticaCancelacion politica;
        switch(opcion){
            case 1 -> politica = new PoliticaCancelacionFlexible();
            case 2 -> politica = new PoliticaCancelacionModerada();
            case 3 -> politica = new PoliticaCancelacionEstricta();
            default -> throw new IllegalArgumentException("Opción inválida");
        }

        System.out.print("\nIngrese fecha de cancelación (AAAA-MM-DD): ");
        LocalDate fechaCancelacion = LocalDate.parse(sc.next());

        try {
            double penalidad = politica.penalidad(r, fechaCancelacion);
            System.out.println("Penalidad: " + penalidad*100 + "% del costo");
        } catch (UnsupportedOperationException e){
            System.out.println("Esta política no permite cancelación.");
        }

        sc.close();
    }
}

// --- Clases ---
class Reserva {
    private final String idHabitacion;
    private final String idCliente;
    private final LocalDate checkIn, checkOut;
    public Reserva(String idHabitacion, String idCliente, LocalDate checkIn, LocalDate checkOut){
        this.idHabitacion=idHabitacion; this.idCliente=idCliente;
        this.checkIn=checkIn; this.checkOut=checkOut;
    }
    public LocalDate getCheckIn(){return checkIn;}
    public LocalDate getCheckOut(){return checkOut;}
}

interface PoliticaCancelacion {
    double penalidad(Reserva r, LocalDate fechaSolicitud);
}

class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    public double penalidad(Reserva r, LocalDate f){
        long dias = ChronoUnit.DAYS.between(f, r.getCheckIn());
        return dias >= 1 ? 0.0 : 1.0;
    }
}

class PoliticaCancelacionModerada implements PoliticaCancelacion {
    public double penalidad(Reserva r, LocalDate f){
        long dias = ChronoUnit.DAYS.between(f, r.getCheckIn());
        return dias >= 3 ? 0.5 : 1.0;
    }
}

class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    public double penalidad(Reserva r, LocalDate f){
        throw new UnsupportedOperationException("No admite cancelación");
    }
}
