package PRACTICA_N2;

public class ContadorTest {
    public static void main(String[] args) {
        // Crear contadores
        Contador c1 = new Contador(5);
        Contador c2 = new Contador(10); // usa VALOR_INICIAL = 10

        // Probar inc() y dec()
        c1.inc();  // c1 pasa de 5 a 6
        c2.dec();  // c2 pasa de 10 a 9

        // Mostrar valores
        System.out.println("c1.valor = " + c1.getValor());
        System.out.println("c2.valor = " + c2.getValor());
        System.out.println("acumulador = " + Contador.getAcumulador());

        // Mostrar estadísticas adicionales
        System.out.println("Número de contadores creados = " + Contador.getNContadores());
        System.out.println("Último contador creado con valor = " + Contador.getUltimoContador());

    }
}
