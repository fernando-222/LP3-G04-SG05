package PRACTICA_N2;

public class Coche {
    // Atributos básicos
    private String color;
    private String modelo;
    private int velocidadMaxima;
    private int potenciaMotor;
    private boolean encendido;

    // Atributos adicionales de la guía
    private String marca;
    private int anioFabricacion;
    private double precio;

    // Constructor por defecto
    public Coche() {
        this.marca = "";
        this.modelo = "";
        this.anioFabricacion = 0;
        this.precio = 0.0;
        this.color = "Negro";
        this.velocidadMaxima = 120;
        this.potenciaMotor = 80;
        this.encendido = false;
    }

    // Constructor con parámetros
    public Coche(String marca, String modelo, int anioFabricacion, double precio,
                 String color, int velocidadMaxima, int potenciaMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.precio = precio;
        this.color = color;
        this.velocidadMaxima = velocidadMaxima;
        this.potenciaMotor = potenciaMotor;
        this.encendido = false;
    }

    // Métodos de comportamiento
    public void encender() {
        encendido = true;
        System.out.println(marca + " " + modelo + " encendido.");
    }

    public void apagar() {
        encendido = false;
        System.out.println(marca + " " + modelo + " apagado.");
    }

    public void acelerar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " está acelerando.");
        } else {
            System.out.println("El coche está apagado.");
        }
    }

    public void frenar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " está frenando.");
        } else {
            System.out.println("El coche está apagado.");
        }
    }

    // Método para aplicar descuento
    public boolean aplicarDescuento(double porcentaje) {
        if (anioFabricacion < 2010) {
            double descuento = precio * (porcentaje / 100.0);
            precio -= descuento;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + anioFabricacion +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                ", velMax=" + velocidadMaxima +
                ", potencia=" + potenciaMotor +
                ", encendido=" + encendido +
                '}';
    }
}
