package ejemplo2;
//Fig. 12.17: MarcoBotonOpcion.java
//Botones de opción creados con ButtonGroup y JRadioButton.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MarcoBotonOpcion extends JFrame
{
 private final JTextField campoTexto;
 private final Font tipoLetraSimple;
 private final Font tipoLetraNegrita;
 private final Font tipoLetraCursiva;
 private final Font tipoLetraNegritaCursiva;
 private final JRadioButton simpleJRadioButton;
 private final JRadioButton negritaJRadioButton;
 private final JRadioButton cursivaJRadioButton;
 private final JRadioButton negritaCursivaJRadioButton;
 private final ButtonGroup grupoOpciones;

 public MarcoBotonOpcion()
 {
     super("Prueba de Botones de opción: Ortiz Ortega-Torres Buscaglia");
     setLayout(new FlowLayout());

     campoTexto = new JTextField("Observe el cambio en el estilo del tipo de letra", 25);
     add(campoTexto);

     simpleJRadioButton = new JRadioButton("Simple", true);
     negritaJRadioButton = new JRadioButton("Negrita", false);
     cursivaJRadioButton = new JRadioButton("Cursiva", false);
     negritaCursivaJRadioButton = new JRadioButton("Negrita/Cursiva", false);
     add(simpleJRadioButton);
     add(negritaJRadioButton);
     add(cursivaJRadioButton);
     add(negritaCursivaJRadioButton);

     grupoOpciones = new ButtonGroup();
     grupoOpciones.add(simpleJRadioButton);
     grupoOpciones.add(negritaJRadioButton);
     grupoOpciones.add(cursivaJRadioButton);
     grupoOpciones.add(negritaCursivaJRadioButton);

     tipoLetraSimple = new Font("Serif", Font.PLAIN, 14);
     tipoLetraNegrita = new Font("Serif", Font.BOLD, 14);
     tipoLetraCursiva = new Font("Serif", Font.ITALIC, 14);
     tipoLetraNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
     campoTexto.setFont(tipoLetraSimple);

     Manejador manejador = new Manejador();
     simpleJRadioButton.addItemListener(manejador);
     negritaJRadioButton.addItemListener(manejador);
     cursivaJRadioButton.addItemListener(manejador);
     negritaCursivaJRadioButton.addItemListener(manejador);
 }

 private class Manejador implements ItemListener
 {
     @Override
     public void itemStateChanged(ItemEvent evento)
     {
         if (evento.getSource() == simpleJRadioButton)
             campoTexto.setFont(tipoLetraSimple);
         else if (evento.getSource() == negritaJRadioButton)
             campoTexto.setFont(tipoLetraNegrita);
         else if (evento.getSource() == cursivaJRadioButton)
             campoTexto.setFont(tipoLetraCursiva);
         else if (evento.getSource() == negritaCursivaJRadioButton)
             campoTexto.setFont(tipoLetraNegritaCursiva);
     }
 }
}