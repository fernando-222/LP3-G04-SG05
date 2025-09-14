package practicas.excepciones;
import java.io.File;
import java.util.Scanner;

public class MainExp4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Experiencia 4 ---");
        System.out.print("Número de cuenta: ");
        String num = sc.nextLine();
        System.out.print("Titular: ");
        String tit = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();

        CuentaBancaria c1 = new CuentaBancaria(num, tit, saldo);

        System.out.print("Monto a depositar: ");
        double dep = sc.nextDouble();
        c1.depositar(dep);

        try {
            String ruta = "reporte_" + num + ".txt";
            ReporteTransacciones.generarReporte(c1, ruta);
            System.out.println("Reporte generado en: " + new File(ruta).getAbsolutePath());
        } catch(Exception e){ 
            System.out.println("Error: " + e.getMessage()); 
        }

        sc.close();
    }
}
