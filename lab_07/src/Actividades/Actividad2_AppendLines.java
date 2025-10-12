package Actividades;
import java.io.*;
import java.util.Scanner;

public class Actividad2_AppendLines {
    public static void main(String[] args) {
        System.out.println("Escriba líneas para añadir al archivo datos.txt. Escriba 'FIN' para terminar.");
        Scanner sc = new Scanner(System.in);
        File file = new File("datos.txt");
        try (FileWriter fw = new FileWriter(file, true);
             PrintWriter pw = new PrintWriter(fw)) {
            while (true) {
                String line = sc.nextLine();
                if ("FIN".equalsIgnoreCase(line)) break;
                pw.println(line);
            }
            System.out.println("Líneas añadidas con éxito a " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
