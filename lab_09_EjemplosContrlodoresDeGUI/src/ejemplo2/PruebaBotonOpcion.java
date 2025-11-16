package ejemplo2;
//Fig. 12.18: PruebaBotonOpcion.java
//Prueba de MarcoBotonOpcion.
import javax.swing.JFrame;

public class PruebaBotonOpcion
{
 public static void main(String[] args)
 {
     MarcoBotonOpcion marcoBotonOpcion = new MarcoBotonOpcion();
     marcoBotonOpcion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoBotonOpcion.setSize(300, 100);
     marcoBotonOpcion.setVisible(true);
 }
}