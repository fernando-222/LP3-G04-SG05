package EJECICIOS_N1;

import java.util.Random;

public class dado_20000 {
    public static void main(String[] args) {
        int[] frecuencias = new int[6];
        Random rand = new Random();

        for (int i = 0; i < 20000; i++) {
            int cara = rand.nextInt(6); 
            frecuencias[cara]++;
        }

        System.out.println("Frecuencia de cada cara:");
        for (int i = 0; i < 6; i++) {
            System.out.println("Cara " + (i+1) + ": " + frecuencias[i]);
        }
    }
}

