package PRACTICA_N2;
import java.util.ArrayList;
import java.util.List;
public class Persona {
    private String dni;
    private String nombre;
    private List<Cuenta> cuentas;  // relación de composición

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();

        // Al crear una Persona, también se le crea al menos una Cuenta
        cuentas.add(new Cuenta("C-" + dni + "-1"));
    }
    public void crearCuentaAdicional() {
        cuentas.add(new Cuenta("C-" + dni + "-" + (cuentas.size() + 1)));
    }
    public void depositarEn(int indice, double monto) {
        cuentas.get(indice).depositar(monto);
    }
    public void retirarDe(int indice, double monto) {
        cuentas.get(indice).retirar(monto);
    }
    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }
}

