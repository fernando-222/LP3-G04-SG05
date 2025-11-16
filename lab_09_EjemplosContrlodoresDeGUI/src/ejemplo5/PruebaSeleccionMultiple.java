package ejemplo5;
//Fig. 12.24: PruebaSeleccionMultiple.java
//Prueba de MarcoSeleccionMultiple.
import javax.swing.JFrame;

public class PruebaSeleccionMultiple
{
 public static void main(String[] args)
 {
     MarcoSeleccionMultiple marcoSeleccionMultiple = new MarcoSeleccionMultiple();
     marcoSeleccionMultiple.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoSeleccionMultiple.setSize(350, 150);
     marcoSeleccionMultiple.setVisible(true);
 }
}