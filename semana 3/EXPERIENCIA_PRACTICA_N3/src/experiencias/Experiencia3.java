package experiencias;

import java.util.Scanner;

public class Experiencia3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione tipo de habitación:");
        System.out.println("1. Individual");
        System.out.println("2. Doble");
        System.out.println("3. Suite");
        int opcion = sc.nextInt();

        Habitacion h;
        switch(opcion){
            case 1 -> h = new HabitacionIndividual("101", 100);
            case 2 -> h = new HabitacionDoble("201", 150);
            case 3 -> {
                System.out.print("¿Incluye desayuno? (true/false): ");
                boolean desayuno = sc.nextBoolean();
                h = new HabitacionSuite("301", 200, desayuno);
            }
            default -> throw new IllegalArgumentException("Opción inválida");
        }

        System.out.println("Habitación creada: " + h.getTipo());
        if (h instanceof HabitacionSuite suite){
            System.out.println("Incluye desayuno: " + suite.isIncluyeDesayuno());
        }

        sc.close();
    }
}

// --- Clases ---
class Habitacion {
    private final String id;
    private final String tipo;
    private double tarifaBase;
    public Habitacion(String id, String tipo, double tarifaBase){
        this.id=id; this.tipo=tipo; this.tarifaBase=tarifaBase;
    }
    public String getTipo(){return tipo;}
}

class HabitacionIndividual extends Habitacion {
    public HabitacionIndividual(String id, double tarifa){ super(id,"INDIVIDUAL",tarifa); }
}

class HabitacionDoble extends Habitacion {
    public HabitacionDoble(String id, double tarifa){ super(id,"DOBLE",tarifa); }
}

class HabitacionSuite extends Habitacion {
    private boolean incluyeDesayuno;
    public HabitacionSuite(String id,double tarifa,boolean desayuno){
        super(id,"SUITE",tarifa); this.incluyeDesayuno=desayuno;
    }
    public boolean isIncluyeDesayuno(){return incluyeDesayuno;}
}
