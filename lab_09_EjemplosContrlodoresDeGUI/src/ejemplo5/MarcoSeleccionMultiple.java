package ejemplo5;
//Fig. 12.23: MarcoSeleccionMultiple.java
//Permite al usuario seleccionar elementos de una JList.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MarcoSeleccionMultiple extends JFrame
{
 private final JList<String> listaJListColores; // lista de nombres de colores
 private final JList<String> listaJListCopia; // lista donde se van a copiar los nombres
 private JButton botonCopiar; // botón para copiar los nombres seleccionados
 private static final String[] nombresColores = {"Negro", "Azul", "Cyan",
     "Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta", "Naranja",
     "Rosa", "Rojo", "Blanco", "Amarillo"};

 // constructor de MarcoSeleccionMultiple
 public MarcoSeleccionMultiple()
 {
     super("Listas de seleccion multiple:Ortiz Ortega-Torres Buscaglia");
     setLayout(new FlowLayout());

     listaJListColores = new JList<String>(nombresColores); // lista con nombres de colores
     listaJListColores.setVisibleRowCount(5); // muestra 5 filas
     listaJListColores.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
     add(new JScrollPane(listaJListColores)); // agrega lista con scroll

     botonCopiar = new JButton("Copiar >>>"); // crea botón
     botonCopiar.addActionListener(
         new ActionListener() // clase interna anónima
         {
             // maneja evento de botón
             @Override
             public void actionPerformed(ActionEvent evento)
             {
                 // coloca los valores seleccionados en listaJListCopia
                 listaJListCopia.setListData(
                     listaJListColores.getSelectedValuesList().toArray(
                         new String[0]));
             }
         } // fin de la clase interna anónima
     ); // fin de la llamada a addActionListener

     add(botonCopiar); // agrega botón de copiar a JFrame

     listaJListCopia = new JList<String>(); // lista para guardar los elementos copiados
     listaJListCopia.setVisibleRowCount(5); // muestra 5 filas
     listaJListCopia.setFixedCellWidth(100); // establece el ancho
     listaJListCopia.setFixedCellHeight(15); // establece la altura
     listaJListCopia.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
     add(new JScrollPane(listaJListCopia)); // agrega lista con scroll
 }
}