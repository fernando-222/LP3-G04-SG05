package practicas.excepciones;
import java.util.Scanner;

public class MainEj3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Numero n = new Numero();

        System.out.println("--- Ejercicio 3 ---");
        System.out.print("Ingrese un número positivo: ");
        double v = sc.nextDouble();

        try {
            n.setValor(v);
            System.out.println("Número asignado correctamente: " + n.getValor());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
