package EjerciciosPropuestos;
import java.io.*;
import java.util.*;
public class EmpleadoModel {
    private File file = new File("empleados.txt");
    public List<Empleado> leerEmpleados() {
        List<Empleado> res = new ArrayList<>();
        if (!file.exists())
            return res;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String l = sc.nextLine().trim();
                if (!l.isEmpty())
                    res.add(Empleado.fromLine(l));
            }
        } catch (Exception e) {
        }
        return res;
    }
    public boolean agregarEmpleado(Empleado e) {
        List<Empleado> all = leerEmpleados();
        for (Empleado ex : all) {
            if (ex.getNumero() == e.getNumero())
                return false;
        }
        all.add(e);
        guardar(all);
        return true;
    }
    public Empleado buscarEmpleado(int numero) {
        for (Empleado e : leerEmpleados()) {
            if (e.getNumero() == numero)
                return e;
        }
        return null;
    }
    public boolean eliminarEmpleado(int numero) {
        List<Empleado> all = leerEmpleados();
        boolean changed = all.removeIf(em -> em.getNumero() == numero);
        if (changed)
            guardar(all);
        return changed;
    }
    private void guardar(List<Empleado> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, false))) {
            for (Empleado e : list) {
                pw.println(e.toFileLine());
            }
        } catch (IOException e) {
        }
    }
}
