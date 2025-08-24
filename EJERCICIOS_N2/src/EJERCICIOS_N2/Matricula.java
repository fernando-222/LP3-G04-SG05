package EJERCICIOS_N2;

public class Matricula {
    private Estudiante estudiante;
    private Curso curso;

    public Matricula(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Curso getCurso() { return curso; }

    @Override
    public String toString() {
        return "Matricula{" +
                "estudiante=" + estudiante.getNombre() +
                ", curso=" + curso.getNombre() +
                '}';
    }
}
