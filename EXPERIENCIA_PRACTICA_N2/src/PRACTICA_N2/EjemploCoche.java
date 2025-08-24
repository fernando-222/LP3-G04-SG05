package PRACTICA_N2;

import java.util.Scanner;

public class EjemploCoche {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Crear coche deportivo
	        System.out.println("=== Coche Deportivo ===");
	        System.out.print("Marca: ");
	        String marca1 = sc.nextLine();
	        System.out.print("Modelo: ");
	        String modelo1 = sc.nextLine();
	        System.out.print("Año: ");
	        int anio1 = Integer.parseInt(sc.nextLine());
	        System.out.print("Precio: ");
	        double precio1 = Double.parseDouble(sc.nextLine());

	        Coche cocheDeportivo = new Coche(marca1, modelo1, anio1, precio1,
	                "Rojo", 220, 200);

	        // Crear coche todoterreno
	        System.out.println("\n=== Coche Todoterreno ===");
	        System.out.print("Marca: ");
	        String marca2 = sc.nextLine();
	        System.out.print("Modelo: ");
	        String modelo2 = sc.nextLine();
	        System.out.print("Año: ");
	        int anio2 = Integer.parseInt(sc.nextLine());
	        System.out.print("Precio: ");
	        double precio2 = Double.parseDouble(sc.nextLine());

	        Coche cocheTodoterreno = new Coche(marca2, modelo2, anio2, precio2,
	                "Negro", 180, 150);

	        // Probar métodos
	        cocheDeportivo.encender();
	        cocheDeportivo.acelerar();
	        cocheDeportivo.frenar();
	        cocheDeportivo.apagar();

	        cocheTodoterreno.encender();
	        cocheTodoterreno.acelerar();
	        cocheTodoterreno.frenar();
	        cocheTodoterreno.apagar();

	        // Probar descuento
	        System.out.print("\nIngrese % de descuento: ");
	        double descuento = Double.parseDouble(sc.nextLine());

	        boolean aplicado1 = cocheDeportivo.aplicarDescuento(descuento);
	        boolean aplicado2 = cocheTodoterreno.aplicarDescuento(descuento);

	        System.out.println("Descuento deportivo aplicado: " + aplicado1);
	        System.out.println("Descuento todoterreno aplicado: " + aplicado2);

	        // Mostrar resumen
	        System.out.println("\nResumen:");
	        System.out.println(cocheDeportivo);
	        System.out.println(cocheTodoterreno);

	        sc.close();
	    }
	}
