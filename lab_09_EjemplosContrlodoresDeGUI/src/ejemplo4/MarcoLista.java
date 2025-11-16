package ejemplo4;
//Fig. 12.21: MarcoLista.java
//Selección de colores de una JList.
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class MarcoLista extends JFrame
{
 private final JList<String> listaColores; // lista para mostrar colores
 private static final String[] nombresColores = {"Negro", "Azul", "Cyan",
     "Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta", "Naranja",
     "Rosa", "Rojo", "Blanco", "Amarillo"};
 private static final Color[] colores = {Color.BLACK, Color.BLUE,
     Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
     Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
     Color.RED, Color.WHITE, Color.YELLOW};

 // El constructor de MarcoLista agrega a JFrame los JList
 public MarcoLista()
 {
     super("Prueba de JList:Ortiz Ortega-Torres Buscaglia");
     setLayout(new FlowLayout());

     listaColores = new JList<String>(nombresColores); // lista de nombresColores
     listaColores.setVisibleRowCount(5); // muestra cinco filas a la vez

     // no permite selecciones múltiples
     listaColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

     // agrega un JScrollPane que contiene a JList al marco
     add(new JScrollPane(listaColores));

     // establece ListSelectionListener para listaColores
     listaColores.addListSelectionListener(
         new ListSelectionListener() // clase interna anónima
         {
             // maneja el evento de selección de la lista
             @Override
             public void valueChanged(ListSelectionEvent evento)
             {
                 getContentPane().setBackground(
                     colores[listaColores.getSelectedIndex()]);
             }
         } // fin de la clase interna anónima
     ); // fin de la llamada a addListSelectionListener
 }
}