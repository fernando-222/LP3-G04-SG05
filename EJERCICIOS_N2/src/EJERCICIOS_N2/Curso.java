package EJERCICIOS_N2;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private int creditos;
    private List<Estudiante> inscritos;

    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.inscritos = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }

    public void agregarEstudiante(Estudiante e) {
        inscritos.add(e);
    }

    public List<Estudiante> getInscritos() {
        return inscritos;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                ", inscritos=" + inscritos.size() +
                '}';
    }
}
