package actividades;
import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("fernando ortiz  arnaldo torres - Grupo: 5"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLayout(new GridLayout(2, 3, 6, 6)); 

            frame.add(new JLabel("Etiqueta 1", SwingConstants.CENTER));
            frame.add(new JLabel("Etiqueta 2", SwingConstants.CENTER));
            frame.add(new JLabel("Etiqueta 3", SwingConstants.CENTER));
            frame.add(new JButton("Botón A"));
            frame.add(new JButton("Botón B"));
            frame.add(new JButton("Botón C"));

            frame.setSize(420, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
