package Actividades;
import java.io.*;
import java.util.Scanner;

public class Actividad3_MatrizBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de filas: "); int filas = sc.nextInt();
        System.out.print("Número de columnas: "); int cols = sc.nextInt();
        double[][] m = new double[filas][cols];
        for (int i=0;i<filas;i++){
            for(int j=0;j<cols;j++){
                System.out.printf("m[%d][%d] = ", i, j);
                m[i][j] = sc.nextDouble();
            }
        }
        File file = new File("matriz.dat");
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(filas);
            dos.writeInt(cols);
            for (int i=0;i<filas;i++) for (int j=0;j<cols;j++) dos.writeDouble(m[i][j]);
            System.out.println("Matriz escrita en: " + file.getAbsolutePath());
        } catch (IOException e) { System.err.println("Error: " + e.getMessage()); }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int rf = dis.readInt();
            int rc = dis.readInt();
            System.out.println("Leyendo matriz ("+rf+"x"+rc+") desde " + file.getAbsolutePath());
            double[][] mm = new double[rf][rc];
            for (int i=0;i<rf;i++) for (int j=0;j<rc;j++) mm[i][j] = dis.readDouble();
            for (int i=0;i<rf;i++){
                for (int j=0;j<rc;j++) System.out.print(mm[i][j]+" ");
                System.out.println();
            }
        } catch (IOException e) { System.err.println("Error lectura: " + e.getMessage()); }
    }
}
