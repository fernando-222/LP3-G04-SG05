package Ejercicios;
import java.util.Scanner;

public class LPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione vehículo:");
        System.out.println("1. Coche");
        System.out.println("2. Bicicleta");
        int opcion = sc.nextInt();

        System.out.print("Ingrese cuánto acelerar: ");
        int delta = sc.nextInt();

        Vehiculo v;
        if (opcion == 1) v = new Coche();
        else if (opcion == 2) v = new Bicicleta();
        else throw new IllegalArgumentException("Opción inválida");

        v.acelerar(delta);
        System.out.println("Velocidad actual: " + v.getVelocidad());

        sc.close();
    }
}

// --- Clases ---
abstract class Vehiculo {
    protected int velocidad;
    public void acelerar(int delta){
        if(delta<=0) throw new IllegalArgumentException("delta>0");
        velocidad+=delta;
    }
    public int getVelocidad(){return velocidad;}
}
class Coche extends Vehiculo { @Override public void acelerar(int delta){ super.acelerar(delta);} }
class Bicicleta extends Vehiculo { @Override public void acelerar(int delta){ super.acelerar(Math.min(delta,10));} }
