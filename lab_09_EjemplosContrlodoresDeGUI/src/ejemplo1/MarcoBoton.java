package ejemplo1;
//Fig. 12.15: MarcoBoton.java
//Botones de comando y eventos de acción.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame
{
 private final JButton botonBotonSimple;    // botón con texto solamente
 private final JButton botonBotonElegante;  // botón con iconos

 // MarcoBoton agrega objetos JButton a un JFrame
 public MarcoBoton()
 {
     // Título modificado con los apellidos
     super("Prueba de botones - Ortiz Ortega-Torres Buscaglia");
     setLayout(new FlowLayout());

     botonBotonSimple = new JButton("Boton simple"); // botón con texto
     add(botonBotonSimple); // agrega botonBotonSimple a JFrame

     // *** ATENCIÓN: Esta línea REQUIERE que "insectol.gif" esté en la misma carpeta ***
     Icon insectol = new ImageIcon(getClass().getResource("insectol.gif"));
     // *** ATENCIÓN: Esta línea REQUIERE que "insecto2.gif" esté en la misma carpeta ***
     Icon insecto2 = new ImageIcon(getClass().getResource("insecto2.gif"));

     botonBotonElegante = new JButton("Boton elegante", insectol); // establece la imagen
     botonBotonElegante.setRolloverIcon(insecto2); // establece la imagen de sustitución
     add(botonBotonElegante); // agrega botonBotonElegante a JFrame

     // crea nuevo ManejadorBoton para manejar los eventos de botón
     ManejadorBoton manejador = new ManejadorBoton();
     botonBotonElegante.addActionListener(manejador);
     botonBotonSimple.addActionListener(manejador);
 }

 // clase interna para manejar eventos de botón
 private class ManejadorBoton implements ActionListener
 {
     // maneja evento de botón
     @Override
     public void actionPerformed(ActionEvent evento)
     {
         JOptionPane.showMessageDialog(MarcoBoton.this,
             String.format("Usted oprimió: %s", evento.getActionCommand()));
     }
 } // fin de la clase ManejadorBoton
} // fin de la clase MarcoBoton