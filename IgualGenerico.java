package actividades;

public class IgualGenerico {
    public static <T> boolean esIgualA(T a, T b) {
        if (a == null || b == null) return false;
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println(esIgualA(5, 5));
        System.out.println(esIgualA("hola", "hola"));
        System.out.println(esIgualA(3.5, 4.5));
        System.out.println(esIgualA(null, "texto"));
        System.out.println(esIgualA(new Object(), new Object()));
    }
}
