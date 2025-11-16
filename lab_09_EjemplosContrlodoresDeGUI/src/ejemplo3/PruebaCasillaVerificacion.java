package ejemplo3;
//Fig. 12.20: PruebaCasillaVerificacion.java
//Prueba de MarcoCasillaVerificacion.
import javax.swing.JFrame;

public class PruebaCasillaVerificacion
{
 public static void main(String[] args)
 {
     MarcoCasillaVerificacion marcoCasillaVerificacion = new MarcoCasillaVerificacion();
     marcoCasillaVerificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoCasillaVerificacion.setSize(350, 100);
     marcoCasillaVerificacion.setVisible(true);
 }
}