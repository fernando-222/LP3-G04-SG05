package EjerciciosPropuestos;
import java.io.*;
import java.util.*;

public class Gestor {
 private List<Personaje> lista = new ArrayList<>();
 private File file;
 public Gestor(String ruta){ file = new File(ruta); cargar(); }
 private void cargar(){
     lista.clear();
     if (!file.exists()) return;
     try (Scanner sc = new Scanner(file)){
         while (sc.hasNextLine()){ String line = sc.nextLine().trim(); if (line.isEmpty()) continue; lista.add(Personaje.fromLine(line)); }
     } catch (FileNotFoundException e){ }
 }
 private void persistir(){
     try (PrintWriter pw = new PrintWriter(new FileWriter(file,false))){ for (Personaje p: lista) pw.println(p.toFileLine()); }
     catch (IOException e){ System.err.println("Error guardando: "+e.getMessage()); }
 }
 public boolean agregar(Personaje p){ if (lista.contains(p)) return false; lista.add(p); persistir(); return true; }
 public boolean eliminar(String nombre){ Iterator<Personaje> it=lista.iterator(); while (it.hasNext()){ if (it.next().getNombre().equalsIgnoreCase(nombre)){ it.remove(); persistir(); return true; } } return false; }
 public boolean modificarAtributo(String nombre, String atributo, int valor){ for (Personaje p: lista) if (p.getNombre().equalsIgnoreCase(nombre)){ switch(atributo.toLowerCase()){ case "vida": p.setVida(valor); break; case "ataque": p.setAtaque(valor); break; case "defensa": p.setDefensa(valor); break; case "alcance": p.setAlcance(valor); break; default: return false; } persistir(); return true; } return false; }
 public List<Personaje> listar(){ return new ArrayList<>(lista); }
 public List<Personaje> filtrarPor(String atributo){
     List<Personaje> res = new ArrayList<>(lista);
     switch(atributo.toLowerCase()){ case "vida": res.sort((a,b)->Integer.compare(b.vida,a.vida)); break; case "ataque": res.sort((a,b)->Integer.compare(b.ataque,a.ataque)); break; case "defensa": res.sort((a,b)->Integer.compare(b.defensa,a.defensa)); break; case "alcance": res.sort((a,b)->Integer.compare(b.alcance,a.alcance)); break; }
     return res;
 }
}
