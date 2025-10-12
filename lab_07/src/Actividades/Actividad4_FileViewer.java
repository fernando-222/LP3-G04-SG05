package Actividades;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Actividad4_FileViewer extends JFrame {
 public Actividad4_FileViewer() {
     super("Visor de Archivos - TestFile required");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(600,400);
     JTextArea area = new JTextArea();
     area.setEditable(false);
     add(new JScrollPane(area), BorderLayout.CENTER);
     try (FileReader fr = new FileReader("TestFile.java"); BufferedReader br = new BufferedReader(fr)) {
         String line;
         while ((line = br.readLine()) != null) area.append(line + "\n");
     } catch (IOException e) { area.setText("No se puede leer TestFile.java: " + e.getMessage()); }
 }
 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> new Actividad4_FileViewer().setVisible(true));
 }
}
