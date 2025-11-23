package ejercicio3;

import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;

public class EfectosSonido {
    public static void main(String[] args) {
        JFrame f = new JFrame("Efectos");
        f.setSize(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton aplauso = new JButton("Aplausos");
        JButton campana = new JButton("Campana");
        JButton explosion = new JButton("Explosión");

        aplauso.addActionListener(e -> play("aplausos.wav"));
        campana.addActionListener(e -> play("campana.wav"));
        explosion.addActionListener(e -> play("explosion.wav"));

        JPanel p = new JPanel();
        p.add(aplauso);
        p.add(campana);
        p.add(explosion);

        f.add(p);
        f.setVisible(true);
    }

    public static void play(String file) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(file)));
            clip.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
