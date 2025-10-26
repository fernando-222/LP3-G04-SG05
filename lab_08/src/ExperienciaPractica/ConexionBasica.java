package ExperienciaPractica;
import java.sql.*;

import java.sql.*;

public class ConexionBasica {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");

            con = DriverManager.getConnection("jdbc:sqlite:empresa.db");
            System.out.println(" Base de datos conectada correctamente.");

            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT NOT NULL," +
                    "edad INTEGER," +
                    "cargo TEXT)";
            stmt.execute(sql);
            System.out.println(" Tabla 'empleados' creada correctamente.");

            stmt.execute("INSERT INTO empleados (nombre, edad, cargo) VALUES ('Carlos', 28, 'Analista')");
            stmt.execute("INSERT INTO empleados (nombre, edad, cargo) VALUES ('Lucía', 35, 'Diseñadora')");
            System.out.println(" Registros insertados.");

            stmt.execute("UPDATE empleados SET edad = 36 WHERE nombre = 'Lucía'");
            System.out.println("Registro actualizado.");

            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
            System.out.println("Datos actuales:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("nombre") + " | " +
                                   rs.getInt("edad") + " | " +
                                   rs.getString("cargo"));
            }

            stmt.execute("DELETE FROM empleados WHERE nombre='Carlos'");
            System.out.println(" Registro eliminado.");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}

