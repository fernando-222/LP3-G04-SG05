package PRACTICA_N2;

public class CuentAhorro extends Cuent {
    private double tasaInteres;  // anual, ej: 0.06 = 6%
    private double saldoMinimoMes;

    public CuentAhorro(String numero, double saldoInicial, double tasaInteres) {
        super(numero, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.saldoMinimoMes = saldoInicial;
    }

    @Override
    public boolean retirar(double monto) {
        boolean ok = super.retirar(monto);
        if (ok) {
            saldoMinimoMes = Math.min(saldoMinimoMes, saldo);
        }
        return ok;
    }

    @Override
    public void consultar() {
        // Calcular interés mensual: (tasaAnual / 12) * saldo mínimo
        double interes = (tasaInteres / 12.0) * saldoMinimoMes;
        depositar(interes);
        saldoMinimoMes = saldo; // reset para siguiente mes
    }
}
