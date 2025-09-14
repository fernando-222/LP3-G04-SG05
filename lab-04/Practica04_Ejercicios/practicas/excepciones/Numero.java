package practicas.excepciones;
public class Numero {
    private double valor;
    public void setValor(double v) {
        if (v < 0) throw new IllegalArgumentException("El valor no puede ser negativo");
        this.valor = v;
    }
    public double getValor() { return valor; }
}
