package EjerciciosPropuestos;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestorEmpleados {
    private List<Empleado> empleados = new ArrayList<>();

    public void cargarDesdeBD() throws Exception {
        empleados.clear(); 
        Connection con = DriverManager.getConnection("jdbc:sqlite:empresa.db");
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM empleados");

        while (rs.next()) {
            empleados.add(new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("cargo")
            ));
        }
        con.close();
        System.out.println(" Datos cargados desde la base de datos. Registros: " + empleados.size());
    }

    public void consultar(int edadMin, boolean asc, int limite) {
        List<Empleado> lista = new ArrayList<>(empleados);

        lista = lista.stream()
                .filter(e -> e.edad > edadMin)
                .collect(Collectors.toList());

        Comparator<Empleado> comp = Comparator.comparing(e -> e.edad);
        if (!asc) comp = comp.reversed();
        lista.sort(comp);

        if (limite > 0 && limite < lista.size()) {
            lista = lista.subList(0, limite);
        }

        System.out.println("\n RESULTADOS DE LA CONSULTA:");
        for (Empleado e : lista) {
            System.out.println(e.id + " | " + e.nombre + " | " + e.edad + " | " + e.cargo);
        }
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        GestorEmpleados g = new GestorEmpleados();
        g.cargarDesdeBD();

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== CONSULTA DE EMPLEADOS (Java puro) ===");
        System.out.print("Ingrese edad mínima para filtrar: ");
        int edad = sc.nextInt();

        System.out.print("¿Orden ascendente? (true/false): ");
        boolean asc = sc.nextBoolean();

        System.out.print("Ingrese límite de registros a mostrar: ");
        int limite = sc.nextInt();

        g.consultar(edad, asc, limite);

        sc.close();
    }
}
