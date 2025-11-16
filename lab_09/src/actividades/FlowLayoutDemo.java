package actividades;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("fernando ortiz  arnaldo torres - Grupo: 5"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            for (int i = 1; i <= 8; i++) {
                frame.add(new JButton("Botón " + i));
            }

            frame.setSize(420, 150);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
