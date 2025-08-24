package PRACTICA_N2;

public class CuentCorriente extends Cuent {
    private int retirosMes;
    private final int retirosGratis = 3;
    private final double tarifa = 3.0;

    public CuentCorriente(String numero, double saldoInicial) {
        super(numero, saldoInicial);
        this.retirosMes = 0;
    }

    @Override
    public boolean retirar(double monto) {
        boolean ok = super.retirar(monto);
        if (ok) {
            retirosMes++;
            if (retirosMes > retirosGratis) {
                if (saldo >= tarifa) {
                    saldo -= tarifa; // cobrar tarifa
                } else {
                    // revertir retiro si no alcanza para tarifa
                    saldo += monto;
                    retirosMes--;
                    return false;
                }
            }
        }
        return ok;
    }

    @Override
    public void consultar() {
        retirosMes = 0; // reinicia contador mensual
    }
}

