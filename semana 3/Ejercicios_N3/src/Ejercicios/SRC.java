package Ejercicios;

	import java.util.Scanner;

	public class SRC {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("=== REGISTRO DE EMPLEADO ===");
	        System.out.print("Ingrese nombre: ");
	        String nombre = sc.nextLine();
	        System.out.print("Ingrese salario base: ");
	        double salarioBase = sc.nextDouble();
	        sc.nextLine(); // limpiar buffer
	        System.out.print("Ingrese departamento: ");
	        String departamento = sc.nextLine();
	        System.out.print("Ingrese horas trabajadas: ");
	        int horas = sc.nextInt();
	        System.out.print("Ingrese bono: ");
	        double bono = sc.nextDouble();

	        Empleado e = new Empleado(nombre, salarioBase, departamento);
	        CalculadoraPago calc = new CalculadoraPago();

	        double pago = calc.pagoMensual(e, horas, bono);
	        System.out.println("\nPago mensual: " + pago);

	        sc.close();
	    }
	}

	// --- Clases ---
	class Empleado {
	    private String nombre; 
	    private double salarioBase; 
	    private String departamento;
	    public Empleado(String n,double s,String d){ nombre=n; salarioBase=s; departamento=d; }
	    public double getSalarioBase(){ return salarioBase; }
	}
	class CalculadoraPago {
	    public double pagoMensual(Empleado e,int horas,double bono){
	        return e.getSalarioBase() + bono;
	    }
	}
