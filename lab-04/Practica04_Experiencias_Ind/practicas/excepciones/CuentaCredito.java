package practicas.excepciones;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) {
        if (monto > saldo + limiteCredito)
            throw new LimiteCreditoExcedidoException("Se excede el límite de crédito");
        saldo -= monto;
        historial.add("Retiro con crédito: " + monto);
    }
}
