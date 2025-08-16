package EJECICIOS_N1;

import java.util.Scanner;

public class arreglo_unidimencional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.print("Ingrese un numero mayor que " + (i > 0 ? arr[i-1] : -1) + ": ");
                int num = sc.nextInt();
                if (i == 0 || num > arr[i-1]) {
                    arr[i] = num;
                    break;
                }
            }
        }

        System.out.print("Arreglo final: ");
        for (int n : arr) System.out.print(n + " ");
    }
}
