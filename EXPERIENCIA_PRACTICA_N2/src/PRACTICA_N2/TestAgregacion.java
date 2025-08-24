package PRACTICA_N2;

public class TestAgregacion {
    public static void main(String[] args) {
        // Creamos motores independientes
        Motor m1 = new Motor("Gasolina", 150);
        Motor m2 = new Motor("Eléctrico", 250);

        // Creamos automóviles sin motor al inicio
        Automovil a1 = new Automovil("Toyota", "Corolla");
        Automovil a2 = new Automovil("Tesla", "Model 3");

        // Luego asignamos motores
        a1.setMotor(m1);
        a2.setMotor(m2);

        // Mostrar resultados
        System.out.println(a1);
        System.out.println(a2);
    }
}
