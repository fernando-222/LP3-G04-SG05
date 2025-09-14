package practicas.excepciones;
import java.util.Scanner;

public class MainEj1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LeerEntrada le = new LeerEntrada();

        System.out.println("--- Ejercicio 1 ---");
        System.out.println("Ingrese caracteres (q para salir):");

        while (true) {
            char c = sc.next().charAt(0);
            try {
                le.procesar(c);
                System.out.println("Caracter válido: " + c);
            } catch (SalidaException e) {
                System.out.println("Fin: " + e.getMessage());
                break;
            } catch (Exception e) {
                System.out.println("Excepción: " + e.getMessage());
            }
        }

        sc.close();
    }
}
