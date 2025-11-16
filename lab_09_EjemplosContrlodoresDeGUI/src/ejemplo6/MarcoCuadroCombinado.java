package ejemplo6;
//Fig. 12.25: MarcoCuadroCombinado.java
//Uso de JComboBox para seleccionar diferentes iconos.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoCuadroCombinado extends JFrame
{
 private final JComboBox<String> imagenesJComboBox; // contiene nombres de iconos
 private final JLabel etiqueta; // muestra el icono seleccionado

 private static final String[] nombres =
     {"insectol.gif", "insecto2.gif", "insecto3.gif", "insecto4.gif"};
 private final Icon[] iconos = {
     new ImageIcon(getClass().getResource(nombres[0])),
     new ImageIcon(getClass().getResource(nombres[1])),
     new ImageIcon(getClass().getResource(nombres[2])),
     new ImageIcon(getClass().getResource(nombres[3]))};

 // Constructor de MarcoCuadroCombinado
 public MarcoCuadroCombinado()
 {
     super("Prueba de JComboBox:Ortiz Ortega-Torres Buscaglia");
     setLayout(new FlowLayout());

     imagenesJComboBox = new JComboBox<String>(nombres); // establece JComboBox
     
     // Manejador para el evento ItemListener
     imagenesJComboBox.addItemListener(
         new ItemListener() // clase interna anónima
         {
             // maneja evento de JComboBox
             @Override
             public void itemStateChanged(ItemEvent evento)
             {
                 // determina si está seleccionado el elemento
                 if (evento.getStateChange() == ItemEvent.SELECTED)
                     etiqueta.setIcon(iconos[
                         imagenesJComboBox.getSelectedIndex()]);
             }
         } // fin de clase interna anónima
     ); // fin de la llamada a addItemListener

     add(imagenesJComboBox); // agrega cuadro combinado a JFrame

     etiqueta = new JLabel(iconos[0]); // muestra el primer icono
     add(etiqueta); // agrega etiqueta a JFrame
 }
}