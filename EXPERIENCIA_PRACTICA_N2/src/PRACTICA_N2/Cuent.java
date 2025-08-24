package PRACTICA_N2;

public abstract class Cuent {
    private String numero;
    protected double saldo;

    public Cuent(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    // Método abstracto que las subclases implementan
    public abstract void consultar();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
