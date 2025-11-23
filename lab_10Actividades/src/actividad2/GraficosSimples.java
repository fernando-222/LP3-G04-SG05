package actividad2;

import javax.swing.*;
import java.awt.*;

public class GraficosSimples extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.drawRect(20,20,100,50);

        g.setColor(Color.BLUE);
        g.fillOval(150,20,80,80);

        g.setColor(Color.GREEN);
        g.drawLine(20,150,300,150);

        g.setColor(Color.BLACK);
        g.drawString("Gráficos Simples",20,200);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Gráficos");
        f.setSize(400,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraficosSimples());
        f.setVisible(true);
    }
}
