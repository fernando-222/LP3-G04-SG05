package practicas.excepciones;
import java.util.Scanner;

public class MainExp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Experiencia 3 ---");
        System.out.print("Número de cuenta: ");
        String num = sc.nextLine();
        System.out.print("Titular: ");
        String tit = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();
        System.out.print("Límite de crédito: ");
        double limite = sc.nextDouble();

        CuentaCredito cc = new CuentaCredito(num, tit, saldo, limite);

        System.out.print("Monto a retirar: ");
        double monto = sc.nextDouble();
        try {
            cc.retirar(monto);
            System.out.println("Retiro exitoso. Saldo actual: " + cc.getSaldo());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
