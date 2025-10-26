package ExperienciaPractica;
import java.sql.*;

public class EjemploPrepared {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:empresa.db");
            System.out.println(" Conectado a la base de datos.");

            String sql = "INSERT INTO empleados (nombre, edad, cargo) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "María");
            ps.setInt(2, 29);
            ps.setString(3, "Desarrolladora");
            ps.executeUpdate();
            System.out.println(" Registro insertado con PreparedStatement.");

            sql = "SELECT * FROM empleados WHERE edad > ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 25);
            ResultSet rs = ps.executeQuery();

            System.out.println(" Empleados con edad > 25:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("nombre") + " | " +
                                   rs.getInt("edad") + " | " +
                                   rs.getString("cargo"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
