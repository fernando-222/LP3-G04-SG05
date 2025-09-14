package practicas.excepciones;
import java.util.Scanner;

public class MainEj4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistroEstudiantes reg = new RegistroEstudiantes();

        System.out.println("--- Ejercicio 4 ---");

        System.out.print("¿Cuántos estudiantes desea registrar?: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese nombre del estudiante " + (i+1) + ": ");
            String nombre = sc.nextLine();
            try {
                reg.agregarEstudiante(nombre);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.print("Ingrese nombre de estudiante a buscar: ");
        String buscar = sc.nextLine();
        try {
            System.out.println("Encontrado: " + reg.buscarEstudiante(buscar));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
