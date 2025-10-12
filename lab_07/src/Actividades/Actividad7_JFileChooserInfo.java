package Actividades;
//File: Actividad7_JFileChooserInfo.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.io.IOException;

public class Actividad7_JFileChooserInfo extends JFrame {
 private JTextArea area = new JTextArea();
 public Actividad7_JFileChooserInfo(){
     super("Seleccionar archivo o directorio");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(600,400);
     JButton btn = new JButton("Seleccionar...");
     btn.addActionListener(e -> seleccionar());
     add(btn, BorderLayout.NORTH);
     area.setEditable(false);
     add(new JScrollPane(area), BorderLayout.CENTER);
 }
 private void seleccionar(){
     JFileChooser fc = new JFileChooser();
     fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
     int res = fc.showOpenDialog(this);
     if (res==JFileChooser.APPROVE_OPTION){
         Path p = fc.getSelectedFile().toPath();
         try{
             StringBuilder sb = new StringBuilder();
             sb.append("Nombre: ").append(p.getFileName()).append('\n');
             sb.append("Absoluta: ").append(p.toAbsolutePath()).append('\n');
             sb.append("Existe: ").append(Files.exists(p)).append('\n');
             sb.append("Directorio: ").append(Files.isDirectory(p)).append('\n');
             if (Files.exists(p)) sb.append("Tamaño: ").append(Files.size(p)).append('\n');
             if (Files.exists(p)) sb.append("Última mod.: ").append(Files.getLastModifiedTime(p)).append('\n');
             if (Files.isDirectory(p)){
                 sb.append("Contenido:\n");
                 try (DirectoryStream<Path> ds = Files.newDirectoryStream(p)){
                     for (Path e: ds) sb.append("  - ").append(e.getFileName()).append('\n');
                 }
             }
             area.setText(sb.toString());
         } catch (IOException ex){ area.setText("Error: " + ex.getMessage()); }
     }
 }
 public static void main(String[] args){ SwingUtilities.invokeLater(() -> new Actividad7_JFileChooserInfo().setVisible(true)); }
}

