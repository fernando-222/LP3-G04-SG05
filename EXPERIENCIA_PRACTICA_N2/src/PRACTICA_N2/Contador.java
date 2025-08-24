package PRACTICA_N2;

public class Contador {
    // Variable de instancia
    private int valor;

    // Variable de clase (compartida por todos)
    private static int acumulador = 0;

    // Constante
    public static final int VALOR_INICIAL = 10;

    // Variables de clase adicionales
    private static int nContadores = 0;
    private static int ultimoContador = 0;

    // Constructor con parámetro
    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;  // se puede escribir también: this.acumulador += valor;
        nContadores++;
        ultimoContador = valor;
    }

    // Constructor por defecto que usa VALOR_INICIAL
    public Contador() {
        this(VALOR_INICIAL);
    }

    // Métodos de comportamiento
    public void inc() {
        valor++;
        acumulador++;
    }

    public void dec() {
        valor--;
        acumulador--;
    }

    // Getters
    public int getValor() { return valor; }
    public static int getAcumulador() { return acumulador; }
    public static int getNContadores() { return nContadores; }
    public static int getUltimoContador() { return ultimoContador; }

    @Override
    public String toString() {
        return "Contador{" +
                "valor=" + valor +
                ", acumulador=" + acumulador +
                '}';
    }
}
