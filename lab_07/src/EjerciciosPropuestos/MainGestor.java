package EjerciciosPropuestos;
import java.util.*;
public class MainGestor {
 public static void main(String[] args){
     Gestor g = new Gestor("personajes.txt");
     Scanner sc = new Scanner(System.in);
     while(true){
         System.out.println("\n1) Listar 2) Agregar 3) Eliminar 4) Modificar 5) Estadísticas 6) Cargar aleatorio 0) Salir");
         int op = Integer.parseInt(sc.nextLine());
         if (op==0) break;
         switch(op){
             case 1: for (Personaje p: g.listar()) System.out.println(p); break;
             case 2:
                 try{
                     System.out.print("Nombre: "); String n=sc.nextLine();
                     System.out.print("Vida: "); int v=Integer.parseInt(sc.nextLine());
                     System.out.print("Ataque: "); int a=Integer.parseInt(sc.nextLine());
                     System.out.print("Defensa: "); int d=Integer.parseInt(sc.nextLine());
                     System.out.print("Alcance: "); int al=Integer.parseInt(sc.nextLine());
                     boolean ok = g.agregar(new Personaje(n,v,a,d,al));
                     System.out.println(ok?"Agregado":"Ya existe");
                 }catch(Exception e){ System.out.println("Entrada inválida"); }
                 break;
             case 3:
                 System.out.print("Nombre a eliminar: "); if (g.eliminar(sc.nextLine())) System.out.println("Eliminado"); else System.out.println("No existe");
                 break;
             case 4:
                 System.out.print("Nombre: "); String nom=sc.nextLine();
                 System.out.print("Atributo (vida,ataque,defensa,alcance): "); String attr=sc.nextLine();
                 System.out.print("Valor: "); int val=Integer.parseInt(sc.nextLine());
                 System.out.println(g.modificarAtributo(nom,attr,val)?"Modificado":"No encontrado o atributo inválido");
                 break;
             case 5:
                 List<Personaje> ls = g.listar();
                 double sumV=0,sumA=0,sumD=0,sumAl=0; for (Personaje p: ls){ String[] parts = p.toFileLine().split(";"); sumV+=Integer.parseInt(parts[1]); sumA+=Integer.parseInt(parts[2]); sumD+=Integer.parseInt(parts[3]); sumAl+=Integer.parseInt(parts[4]); }
                 if (ls.isEmpty()) System.out.println("No hay personajes"); else {
                     System.out.println("Total: "+ls.size()+" Promedios V:"+(sumV/ls.size())+" A:"+(sumA/ls.size())); }
                 break;
             case 6:
                 g.agregar(new Personaje("Goblin",50,10,5,2));
                 g.agregar(new Personaje("Guerrero",150,30,20,1));
                 g.agregar(new Personaje("Arquero",80,20,10,5));
                 System.out.println("Cargados aleatorios (si no existían)");
                 break;
         }
     }
 }
}
