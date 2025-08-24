package PRACTICA_N2;

public class Motor {
    private String tipo;   // gasolina, diesel, eléctrico
    private int potencia;  // caballos de fuerza (HP)

    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }

    @Override
    public String toString() {
        return "Motor{tipo='" + tipo + "', potencia=" + potencia + " HP}";
    }
}
