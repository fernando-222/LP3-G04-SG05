package ejercicio2;
import javax.swing.*;
import java.awt.*;

public class GraficoTemperaturas extends JPanel {
    private int[] temps = new int[7];

    public void setTemps(int[] t) {
        this.temps = t;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int step = 60;

        g.drawLine(40, 250, 500, 250);

        for (int i = 0; i < temps.length - 1; i++) {
            int y1 = 250 - temps[i];
            int y2 = 250 - temps[i+1];
            g.drawLine(x, y1, x + step, y2);
            g.fillOval(x - 3, y1 - 3, 6, 6);
            x += step;
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Temperaturas Semana");
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraficoTemperaturas panel = new GraficoTemperaturas();
        JTextField[] campos = new JTextField[7];
        JPanel form = new JPanel();

        for (int i = 0; i < 7; i++) {
            campos[i] = new JTextField(3);
            form.add(campos[i]);
        }

        JButton mostrar = new JButton("Mostrar Gráfico");
        form.add(mostrar);

        mostrar.addActionListener(e -> {
            int[] t = new int[7];
            for (int i = 0; i < 7; i++)
                t[i] = Integer.parseInt(campos[i].getText());
            panel.setTemps(t);
        });

        f.add(form, BorderLayout.NORTH);
        f.add(panel);
        f.setVisible(true);
    }
}
