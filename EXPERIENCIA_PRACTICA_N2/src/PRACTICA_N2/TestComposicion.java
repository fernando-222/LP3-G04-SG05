package PRACTICA_N2;

public class TestComposicion {
    public static void main(String[] args) {
        // Crear persona con una cuenta por defecto
        Persona p1 = new Persona("12345678", "Ana Pérez");

        // Depositar y retirar
        p1.depositarEn(0, 1000);
        p1.retirarDe(0, 200);

        // Crear una segunda cuenta y usarla
        p1.crearCuentaAdicional();
        p1.depositarEn(1, 500);

        // Mostrar persona y sus cuentas
        System.out.println(p1);
    }
}
