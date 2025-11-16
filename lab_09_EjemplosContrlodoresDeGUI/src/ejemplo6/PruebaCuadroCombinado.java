package ejemplo6;
//Fig. 12.26: PruebaCuadroCombinado.java
//Prueba de MarcoCuadroCombinado.
import javax.swing.JFrame;

public class PruebaCuadroCombinado
{
 public static void main(String[] args)
 {
     MarcoCuadroCombinado marcoCuadroCombinado = new MarcoCuadroCombinado();
     marcoCuadroCombinado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoCuadroCombinado.setSize(350, 150);
     marcoCuadroCombinado.setVisible(true);
 }
}