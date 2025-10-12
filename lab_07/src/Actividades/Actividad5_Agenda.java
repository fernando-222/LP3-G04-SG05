package Actividades;
//File: Actividad5_Agenda.java
import java.io.*;
import java.util.*;

class Persona {
 private String nombre, telefono, direccion;
 public Persona(String n, String t, String d){ this.nombre=n; this.telefono=t; this.direccion=d; }
 public String getNombre(){ return nombre; }
 public String toString(){ return nombre+" - "+telefono+" - "+direccion; }
}

public class Actividad5_Agenda {
 public static void main(String[] args) {
     List<Persona> lista = new ArrayList<>();
     File f = new File("agenda.txt");
     if (!f.exists()) System.out.println("No existe agenda.txt en la carpeta del proyecto. Creelo con formato: nombre;telefono;direccion por línea.");
     else {
         try (Scanner sc = new Scanner(f)){
             while (sc.hasNextLine()){
                 String line = sc.nextLine().trim();
                 if (line.isEmpty()) continue;
                 String[] parts = line.split(";");
                 if (parts.length>=3) lista.add(new Persona(parts[0].trim(), parts[1].trim(), parts[2].trim()));
             }
             System.out.println("Contactos cargados: " + lista.size());
             Scanner in = new Scanner(System.in);
             System.out.print("Ingrese nombre a buscar: ");
             String key = in.nextLine().trim();
             boolean found=false;
             for (Persona p: lista) if (p.getNombre().equalsIgnoreCase(key)) { System.out.println("Encontrado: "+p); found=true; }
             if (!found) System.out.println("No se encontró el contacto.");
         } catch (FileNotFoundException e) { System.err.println(e.getMessage()); }
     }
 }
}
