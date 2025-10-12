package EjerciciosPropuestos;
public class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;
    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public int getNumero() {
        return numero;
    }
    public String getNombre() {
        return nombre;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setNombre(String n) {
        nombre = n;
    }
    public void setSueldo(double s) {
        sueldo = s;
    }
    public String toFileLine() {
        return numero + ";" + nombre + ";" + sueldo;
    }
    public static Empleado fromLine(String line) {
        String[] p = line.split(";");
        return new Empleado(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2]));
    }
    @Override
    public String toString() {
        return numero + " - " + nombre + " - " + sueldo;
    }
}
