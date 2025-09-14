package practicas.excepciones;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ReporteTransacciones {
    public static void generarReporte(CuentaBancaria cuenta, String rutaArchivo) throws Exception {
        List<String> hist = cuenta.getHistorial();
        if (hist.isEmpty()) throw new Exception("Historial vacío");
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            pw.println("NumeroCuenta, Titular, Saldo");
            pw.printf("%s, %s, %.2f%n", cuenta.getNumeroCuenta(), cuenta.getTitular(), cuenta.getSaldo());
        }
    }
}
