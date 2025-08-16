package EJECICIOS_N1;

import java.util.Scanner;

public class convierte_seg {
    public static int aSegundos(int h, int m, int s) {
        return h*3600 + m*60 + s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese horas: ");
        int horas = sc.nextInt();

        System.out.print("Ingrese minutos: ");
        int minutos = sc.nextInt();

        System.out.print("Ingrese segundos: ");
        int segundos = sc.nextInt();

        int totalSegundos = aSegundos(horas, minutos, segundos);
        System.out.println("Equivalente en segundos: " + totalSegundos);
    }
}

