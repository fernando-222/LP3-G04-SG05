package Actividades;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.io.IOException;
import java.util.Scanner;

public class Actividad1_FileInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese ruta de archivo o directorio: ");
        String input = sc.nextLine().trim();
        Path p = Paths.get(input);
        try {
            System.out.println("Nombre: " + p.getFileName());
            System.out.println("¿Es directorio?: " + Files.isDirectory(p));
            System.out.println("¿Es ruta absoluta?: " + p.isAbsolute());
            if (Files.exists(p)) {
                FileTime lm = Files.getLastModifiedTime(p);
                System.out.println("Última modificación: " + lm);
                try { System.out.println("Tamaño (bytes): " + Files.size(p)); } catch (IOException e) {}
                System.out.println("Ruta absoluta: " + p.toAbsolutePath());
                if (Files.isDirectory(p)) {
                    System.out.println("Contenido del directorio:");
                    try (DirectoryStream<Path> ds = Files.newDirectoryStream(p)) {
                        for (Path entry : ds) System.out.println("  - " + entry.getFileName());
                    }
                }
            } else {
                System.out.println("El archivo/directorio no existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al obtener información: " + e.getMessage());
        }
    }
}

