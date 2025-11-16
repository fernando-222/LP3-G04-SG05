package ejemplo3;
//Fig. 12.19: MarcoCasillaVerificacion.java
//JCheckBoxes y eventos ItemListener.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerificacion extends JFrame
{
 private final JTextField campoTexto;
 private final JCheckBox negritaJCheckBox;
 private final JCheckBox cursivaJCheckBox;

 public MarcoCasillaVerificacion()
 {
     super("Prueba de JCheckBox: Ortiz Ortega.Torres Buscaglia");
     setLayout(new FlowLayout());

     campoTexto = new JTextField("Observe el cambio en el estilo del tipo de letra", 25);
     campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
     add(campoTexto);

     negritaJCheckBox = new JCheckBox("Negrita");
     cursivaJCheckBox = new JCheckBox("Cursiva");
     add(negritaJCheckBox);
     add(cursivaJCheckBox);

     Manejador manejador = new Manejador();
     negritaJCheckBox.addItemListener(manejador);
     cursivaJCheckBox.addItemListener(manejador);
 }

 private class Manejador implements ItemListener
 {
     @Override
     public void itemStateChanged(ItemEvent evento)
     {
         Font fuente = null; // objeto Font que se establece para campoTexto
         int estilo = Font.PLAIN; // inicializa el estilo a simple

         // determina qué CheckBoxs están seleccionados y crea un objeto Font
         if (negritaJCheckBox.isSelected())
             estilo += Font.BOLD; // agrega negrita a estilo

         if (cursivaJCheckBox.isSelected())
             estilo += Font.ITALIC; // agrega cursiva a estilo

         fuente = new Font("Serif", estilo, 14);
         campoTexto.setFont(fuente);
     }
 }
}