package EJERCICIOS_N2;

public class Estudiante {
    private String codigo;
    private String nombre;
    private String carrera;

    public Estudiante(String codigo, String nombre, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCarrera() { return carrera; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
