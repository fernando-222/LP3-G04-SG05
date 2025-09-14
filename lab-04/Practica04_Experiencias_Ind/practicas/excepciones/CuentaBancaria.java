package practicas.excepciones;
import java.util.ArrayList;
import java.util.List;
public class CuentaBancaria {
    protected String numeroCuenta;
    protected String titular;
    protected double saldo;
    protected List<String> historial = new ArrayList<>();
    private boolean cerrada = false;
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial no puede ser negativo");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public List<String> getHistorial() { return historial; }

    public void depositar(double monto) {
        if (cerrada) throw new IllegalStateException("La cuenta está cerrada");
        if (monto <= 0) throw new IllegalArgumentException("Monto a depositar debe ser positivo");
        saldo += monto;
        historial.add("Depósito: " + monto);
    }
    public void retirar(double monto) {
        if (cerrada) throw new IllegalStateException("La cuenta está cerrada");
        if (monto <= 0) throw new IllegalArgumentException("Monto a retirar debe ser positivo");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + monto);
        saldo -= monto;
        historial.add("Retiro: " + monto);
    }
    public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException {
        if (cerrada) throw new IllegalStateException("La cuenta está cerrada");
        if (destino == null) throw new CuentaNoEncontradaException("Cuenta destino no existe");
        this.retirar(monto);
        destino.depositar(monto);
        historial.add("Transferencia a " + destino.getNumeroCuenta() + ": " + monto);
    }
    public void cerrarCuenta() throws SaldoNoCeroException {
        if (cerrada) throw new IllegalStateException("La cuenta ya está cerrada");
        if (saldo != 0) throw new SaldoNoCeroException("No se puede cerrar la cuenta, saldo distinto de 0");
        cerrada = true;
        historial.add("Cuenta cerrada");
    }
}
