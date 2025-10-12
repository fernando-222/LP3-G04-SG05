package EjerciciosPropuestos;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class Ejercicio4_ContadorPalabras {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        if (res != JFileChooser.APPROVE_OPTION) {
            System.out.println("No seleccionado");
            return;
        }
        File f = fc.getSelectedFile();
        Map<String, Integer> freq = new HashMap<>();
        int lineas = 0, palabras = 0, caracteres = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineas++;
                caracteres += line.length();
                StringBuilder word = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isLetterOrDigit(c)) {
                        word.append(c);
                    } else {
                        if (word.length() > 0) {
                            String w = word.toString().toLowerCase();
                            freq.put(w, freq.getOrDefault(w, 0) + 1);
                            palabras++;
                            word.setLength(0); 
                        }
                    }
                }              
                if (word.length() > 0) {
                    String w = word.toString().toLowerCase();
                    freq.put(w, freq.getOrDefault(w, 0) + 1);
                    palabras++;
                }
            }
            System.out.println("Archivo: " + f.getAbsolutePath());
            System.out.println("Líneas: " + lineas);
            System.out.println("Palabras: " + palabras);
            System.out.println("Caracteres (sin \\n): " + caracteres);
            System.out.println("Promedio palabras/linea: " + (lineas == 0 ? 0.0 : ((double) palabras / lineas)));
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
            entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
            System.out.println("Palabras más frecuentes:");
            for (int i = 0; i < Math.min(10, entries.size()); i++) {
                System.out.println(entries.get(i).getKey() + " -> " + entries.get(i).getValue());
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
