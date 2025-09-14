package practicas.excepciones;
import java.util.Scanner;

public class MainEj2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        System.out.println("--- Ejercicio 2 ---");
        System.out.print("Ingrese primer número: ");
        double a = sc.nextDouble();
        System.out.print("Ingrese segundo número: ");
        double b = sc.nextDouble();

        try {
            System.out.println("Suma = " + calc.sumar(a, b));
            System.out.println("Resta = " + calc.restar(a, b));
            System.out.println("Multiplicación = " + calc.multiplicar(a, b));
            System.out.println("División = " + calc.dividir(a, b));
        } catch (DivisionPorCeroException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
