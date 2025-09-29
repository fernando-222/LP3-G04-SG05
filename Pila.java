package actividades;

public class Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila() {
        this(10);
    }

    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    public void push(E valor) {
        if (superior == tamanio - 1)
            throw new ExcepcionPilaLlena("La pila está llena");
        elementos[++superior] = valor;
    }

    public E pop() {
        if (superior == -1)
            throw new ExcepcionPilaVacia("La pila está vacía");
        return elementos[superior--];
    }

    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) return true;
        }
        return false;
    }

    public boolean esIgual(Pila<E> otra) {
        if (this.superior != otra.superior) return false;
        for (int i = 0; i <= superior; i++) {
            if (!this.elementos[i].equals(otra.elementos[i])) return false;
        }
        return true;
    }
}
