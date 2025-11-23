package ejercicio4;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {
    static Clip clip;
    static long pausa;

    public static void main(String[] args) {
        JFrame f = new JFrame("Reproductor");
        f.setSize(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton play = new JButton("Reproducir");
        JButton pause = new JButton("Pausar");
        JButton resume = new JButton("Reanudar");

        play.addActionListener(e -> reproducir("musica.wav"));
        pause.addActionListener(e -> pausar());
        resume.addActionListener(e -> reanudar());

        JPanel p = new JPanel();
        p.add(play); p.add(pause); p.add(resume);

        f.add(p);
        f.setVisible(true);
    }

    public static void reproducir(String file) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(file)));
            clip.start();
        } catch(Exception ex) { ex.printStackTrace(); }
    }

    public static void pausar() {
        pausa = clip.getMicrosecondPosition();
        clip.stop();
    }

    public static void reanudar() {
        clip.setMicrosecondPosition(pausa);
        clip.start();
    }
}