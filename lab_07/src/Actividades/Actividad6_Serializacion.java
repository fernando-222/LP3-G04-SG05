package Actividades;
import java.io.*;
import java.util.*;

class Fecha implements Serializable {
 private int dia, mes, anio;
 public Fecha(int d,int m,int a){ dia=d; mes=m; anio=a; }
 public String toString(){ return dia+"/"+mes+"/"+anio; }
}

class PersonaS implements Serializable {
 private String nombre;
 public PersonaS(String n){ nombre=n; }
 public String toString(){ return nombre; }
}

class Alumno extends PersonaS {
 private Fecha fechaNacimiento;
 public Alumno(String n, Fecha f){ super(n); fechaNacimiento=f; }
 public String toString(){ return super.toString()+" - "+fechaNacimiento; }
}

public class Actividad6_Serializacion {
 public static void main(String[] args) {
     List<Alumno> alumnos = Arrays.asList(
         new Alumno("Ana", new Fecha(1,1,2000)),
         new Alumno("Luis", new Fecha(5,6,1999)),
         new Alumno("Marta", new Fecha(10,12,2001))
     );
     File file = new File("alumnos.dat");
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
         for (Alumno a: alumnos) oos.writeObject(a);
         System.out.println("Alumnos serializados en " + file.getAbsolutePath());
     } catch (IOException e){ System.err.println(e.getMessage()); }

     // Lectura
     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
         System.out.println("Leyendo objetos:");
         while (true) {
             try {
                 Object o = ois.readObject();
                 System.out.println(o);
             } catch (EOFException eof) { break; }
         }
     } catch (IOException | ClassNotFoundException e) { System.err.println(e.getMessage()); }
 }
}

