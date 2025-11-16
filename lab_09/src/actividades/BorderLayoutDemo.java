package actividades;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("fernando ortiz  arnaldo torres - Grupo: 5"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLayout(new BorderLayout(8, 8));

            frame.add(new JButton("NORTE"), BorderLayout.NORTH);
            frame.add(new JButton("SUR"), BorderLayout.SOUTH);
            frame.add(new JButton("OESTE"), BorderLayout.WEST);
            frame.add(new JButton("ESTE"), BorderLayout.EAST);

            JPanel centerPanel = new JPanel(new FlowLayout());
            centerPanel.add(new JLabel("Centro:"));
            centerPanel.add(new JTextField("Texto ejemplo", 15));
            frame.add(centerPanel, BorderLayout.CENTER);

            frame.setSize(480, 220);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
