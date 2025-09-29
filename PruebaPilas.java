package actividades;

public class PruebaPilas {
    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>(5);
        Pila<Integer> pila2 = new Pila<>(5);

        pila1.push(1);
        pila1.push(2);
        pila1.push(3);

        pila2.push(1);
        pila2.push(2);
        pila2.push(3);

        System.out.println(pila1.contains(2));
        System.out.println(pila1.esIgual(pila2));

        pila2.pop();
        pila2.push(4);

        System.out.println(pila1.esIgual(pila2));
    }
}
