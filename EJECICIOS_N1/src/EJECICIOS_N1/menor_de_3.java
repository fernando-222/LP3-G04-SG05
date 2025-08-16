package EJECICIOS_N1;

public class menor_de_3 {
    public static double menorDeTres(double a, double b, double c) {
        double menor = a;
        if (b < menor) menor = b;
        if (c < menor) menor = c;
        return menor;
    }

    public static void main(String[] args) {
        System.out.println(menorDeTres(5.2, 3.8, 7.1));
    }
}

