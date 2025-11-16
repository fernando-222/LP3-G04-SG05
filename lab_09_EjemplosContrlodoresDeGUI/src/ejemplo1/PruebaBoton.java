package ejemplo1;
// Fig. 12.16: PruebaBoton.java
// Prueba de MarcoBoton.
import javax.swing.JFrame;

public class PruebaBoton
{
    public static void main(String[] args)
    {
        MarcoBoton marcoBoton = new MarcoBoton();
        marcoBoton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoBoton.setSize(275, 110);
        marcoBoton.setVisible(true);
    } // fin de main
} // fin de la clase PruebaBoton