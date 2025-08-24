package PRACTICA_N2;

public class Cuenta {
    private String numero;
    private double saldo;

    public Cuenta(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}



