package EJECICIOS_N1;

import java.util.Scanner;

public class numero_de_cargo {
    public static double calcularCosto(int horas) {
        if (horas <= 1) return 3.0;
        double costo = 3.0 + (horas - 1) * 0.5;
        return Math.min(costo, 12.0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de horas: ");
        int horas = sc.nextInt();

        double costo = calcularCosto(horas);
        System.out.println("El costo por " + horas + " horas es: S/ " + costo);
    }
}

