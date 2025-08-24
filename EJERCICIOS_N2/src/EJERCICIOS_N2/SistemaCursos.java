package EJERCICIOS_N2;

import java.util.*;

public class SistemaCursos {
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;
    private List<Matricula> matriculas;

    public SistemaCursos() {
        cursos = new ArrayList<>();
        estudiantes = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

    private Curso buscarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

    private Estudiante buscarEstudiante(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) return e;
        }
        return null;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        String op;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE CURSOS ===");
            System.out.println("1) Registrar curso");
            System.out.println("2) Registrar estudiante");
            System.out.println("3) Matricular estudiante en curso");
            System.out.println("4) Listar cursos con inscritos");
            System.out.println("5) Listar estudiantes matriculados");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = sc.nextLine();

            switch (op) {
                case "1":
                    System.out.print("Código del curso: ");
                    String cc = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nc = sc.nextLine();
                    System.out.print("Créditos: ");
                    int cr = Integer.parseInt(sc.nextLine());
                    cursos.add(new Curso(cc, nc, cr));
                    break;

                case "2":
                    System.out.print("Código del estudiante: ");
                    String ce = sc.nextLine();
                    System.out.print("Nombre: ");
                    String ne = sc.nextLine();
                    System.out.print("Carrera: ");
                    String ca = sc.nextLine();
                    estudiantes.add(new Estudiante(ce, ne, ca));
                    break;

                case "3":
                    System.out.print("Código estudiante: ");
                    String estCod = sc.nextLine();
                    Estudiante e = buscarEstudiante(estCod);
                    if (e == null) { System.out.println("No existe estudiante."); break; }

                    System.out.print("Código curso: ");
                    String curCod = sc.nextLine();
                    Curso c = buscarCurso(curCod);
                    if (c == null) { System.out.println("No existe curso."); break; }

                    c.agregarEstudiante(e);
                    matriculas.add(new Matricula(e, c));
                    System.out.println("Matriculado correctamente.");
                    break;

                case "4":
                    for (Curso cur : cursos) {
                        System.out.println(cur);
                        for (Estudiante est : cur.getInscritos()) {
                            System.out.println("   - " + est);
                        }
                    }
                    break;

                case "5":
                    for (Matricula m : matriculas) {
                        System.out.println(m);
                    }
                    break;

                case "0":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (!op.equals("0"));
    }

    public static void main(String[] args) {
        SistemaCursos app = new SistemaCursos();
        app.menu();
    }
}
