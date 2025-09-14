package practicas.excepciones;
import java.util.Scanner;

public class MainExp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Experiencia 2 ---");

        System.out.print("Ingrese cuenta origen: ");
        String num1 = sc.nextLine();
        System.out.print("Titular origen: ");
        String tit1 = sc.nextLine();
        System.out.print("Saldo inicial origen: ");
        double sal1 = sc.nextDouble(); sc.nextLine();
        CuentaBancaria c1 = new CuentaBancaria(num1, tit1, sal1);

        System.out.print("Ingrese cuenta destino: ");
        String num2 = sc.nextLine();
        System.out.print("Titular destino: ");
        String tit2 = sc.nextLine();
        System.out.print("Saldo inicial destino: ");
        double sal2 = sc.nextDouble();
        CuentaBancaria c2 = new CuentaBancaria(num2, tit2, sal2);

        System.out.print("Monto a transferir: ");
        double monto = sc.nextDouble();

        try {
            c1.transferir(c2, monto);
            System.out.println("Transferencia realizada.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            c1.cerrarCuenta();
            System.out.println("Cuenta cerrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cerrar cuenta: " + e.getMessage());
        }

        sc.close();
    }
}
