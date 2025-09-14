package practicas.excepciones;
import java.util.Scanner;

public class MainExp1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Experiencia 1 ---");
        System.out.print("Ingrese número de cuenta: ");
        String num = sc.nextLine();
        System.out.print("Ingrese titular: ");
        String titular = sc.nextLine();
        System.out.print("Ingrese saldo inicial: ");
        double saldo = sc.nextDouble();

        CuentaBancaria c1 = new CuentaBancaria(num, titular, saldo);

        System.out.print("Monto a depositar: ");
        double dep = sc.nextDouble();
        c1.depositar(dep);

        System.out.print("Monto a retirar: ");
        double ret = sc.nextDouble();
        try {
            c1.retirar(ret);
            System.out.println("Retiro exitoso. Saldo actual: " + c1.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}