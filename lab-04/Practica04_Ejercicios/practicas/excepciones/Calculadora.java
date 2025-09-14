package practicas.excepciones;
public class Calculadora {
    public double sumar(double a, double b) { return a + b; }
    public double restar(double a, double b) { return a - b; }
    public double multiplicar(double a, double b) { return a * b; }
    public double dividir(double a, double b) {
        if (b == 0) throw new DivisionPorCeroException("División por cero no permitida");
        return a / b;
    }
}
