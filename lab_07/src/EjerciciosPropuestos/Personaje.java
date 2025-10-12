package EjerciciosPropuestos;
import java.util.Objects;

public class Personaje {
 private String nombre;
 private int vida, ataque, defensa, alcance;
 public Personaje(String nombre, int vida, int ataque, int defensa, int alcance){
     if (nombre==null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre vacío");
     if (vida<=0 || ataque<=0 || defensa<=0 || alcance<=0) throw new IllegalArgumentException("Atributos deben ser > 0");
     this.nombre=nombre; this.vida=vida; this.ataque=ataque; this.defensa=defensa; this.alcance=alcance;
 }
 public String getNombre(){ return nombre; }
 public void setVida(int v){ if (v>0) vida=v; }
 public void setAtaque(int a){ if (a>0) ataque=a; }
 public void setDefensa(int d){ if (d>0) defensa=d; }
 public void setAlcance(int a){ if (a>0) alcance=a; }
 public String toFileLine(){ return nombre+";"+vida+";"+ataque+";"+defensa+";"+alcance; }
 public static Personaje fromLine(String line){ String[] p=line.split(";"); return new Personaje(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4])); }
 public String toString(){ return String.format("%s (V:%d A:%d D:%d Alc:%d)", nombre, vida, ataque, defensa, alcance); }
 public boolean equals(Object o){ if (!(o instanceof Personaje)) return false; return nombre.equalsIgnoreCase(((Personaje)o).nombre); }
 public int hashCode(){ return Objects.hash(nombre.toLowerCase()); }
}
