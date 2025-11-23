package actividad3;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class ReproAudio {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Audio");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton aplausos = new JButton("Aplausos");

        aplausos.addActionListener(e -> reproducir("aplausos.wav"));

        frame.add(aplausos);
        frame.setVisible(true);
    }

    public static void reproducir(String archivo) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(archivo));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
