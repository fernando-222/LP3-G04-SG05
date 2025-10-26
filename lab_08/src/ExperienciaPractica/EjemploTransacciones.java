package ExperienciaPractica;
import java.sql.*;

public class EjemploTransacciones {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:empresa.db");
            System.out.println("Conexión establecida.");

            con.setAutoCommit(false); 

            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO empleados (nombre, edad, cargo) VALUES ('Pedro', 40, 'Gerente')");
            stmt.executeUpdate("INSERT INTO empleados (nombre, edad, cargo) VALUES ('Ana', 22, 'Practicante')");

            System.out.println(" Datos agregados temporalmente...");

            String clave = "admin"; 
            if (clave.equals("admin")) {
                con.commit(); 
                System.out.println(" Cambios confirmados (COMMIT).");
            } else {
                con.rollback(); 
                System.out.println(" Clave incorrecta. Cambios revertidos (ROLLBACK).");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
