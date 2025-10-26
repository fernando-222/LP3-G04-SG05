package EjerciciosPropuestos;
import java.sql.*;
import java.util.Scanner;

import java.sql.*;
import java.util.Scanner;

public class MenuSQLite {
    static final String DB_URL = "jdbc:sqlite:empresa.db";
    static final String CLAVE = "1234"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                con.setAutoCommit(false); 

                Statement stmt = con.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS empleados (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nombre TEXT," +
                        "edad INTEGER," +
                        "cargo TEXT)");

                do {
                    System.out.println("\n==== MENÚ EMPLEADOS ====");
                    System.out.println("1. Insertar empleado");
                    System.out.println("2. Mostrar empleados");
                    System.out.println("3. Actualizar empleado");
                    System.out.println("4. Borrar empleado");
                    System.out.println("5. Salir");
                    System.out.print("Opción: ");
                    opcion = sc.nextInt();
                    sc.nextLine(); 

                    switch (opcion) {
                        case 1:
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad: ");
                            int edad = sc.nextInt();
                            sc.nextLine(); 
                            System.out.print("Cargo: ");
                            String cargo = sc.nextLine();

                            PreparedStatement ps = con.prepareStatement(
                                    "INSERT INTO empleados (nombre, edad, cargo) VALUES (?, ?, ?)");
                            ps.setString(1, nombre);
                            ps.setInt(2, edad);
                            ps.setString(3, cargo);
                            ps.executeUpdate();
                            System.out.println("Empleado agregado temporalmente.");
                            confirmar(con, sc);
                            ps.close();
                            break;

                        case 2:
                            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
                            System.out.println("\n--- Empleados ---");
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + " | " +
                                        rs.getString("nombre") + " | " +
                                        rs.getInt("edad") + " | " +
                                        rs.getString("cargo"));
                            }
                            rs.close();
                            break;

                        case 3:
                            System.out.print("ID del empleado a actualizar: ");
                            int idU = sc.nextInt();
                            sc.nextLine(); 
                            System.out.print("Nuevo cargo: ");
                            String newCargo = sc.nextLine();

                            PreparedStatement ps2 = con.prepareStatement(
                                    "UPDATE empleados SET cargo=? WHERE id=?");
                            ps2.setString(1, newCargo);
                            ps2.setInt(2, idU);
                            int updated = ps2.executeUpdate();
                            if (updated > 0) {
                                System.out.println("Actualización pendiente.");
                                confirmar(con, sc);
                            } else {
                                System.out.println("No se encontró empleado con ese ID.");
                                con.rollback();
                            }
                            ps2.close();
                            break;

                        case 4:
                            System.out.print("ID del empleado a eliminar: ");
                            int id = sc.nextInt();
                            sc.nextLine(); 
                            PreparedStatement ps3 = con.prepareStatement(
                                    "DELETE FROM empleados WHERE id=?");
                            ps3.setInt(1, id);
                            int deleted = ps3.executeUpdate();
                            if (deleted > 0) {
                                System.out.println("Eliminación pendiente.");
                                confirmar(con, sc);
                            } else {
                                System.out.println("No se encontró empleado con ese ID.");
                                con.rollback();
                            }
                            ps3.close();
                            break;

                        case 5:
                            System.out.println("Saliendo...");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }
                } while (opcion != 5);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static void confirmar(Connection con, Scanner sc) throws SQLException {
        System.out.print("Ingrese clave para confirmar cambios: ");
        String clave = sc.next();
        sc.nextLine(); 
        if (clave.equals(CLAVE)) {
            con.commit();
            System.out.println("Cambios confirmados (COMMIT).");
        } else {
            con.rollback();
            System.out.println("Clave incorrecta. Cambios revertidos (ROLLBACK).");
        }
    }
}
