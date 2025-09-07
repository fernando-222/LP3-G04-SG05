package Ejercicios;
import java.util.Scanner;
public class IPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione impresora:");
        System.out.println("1. Normal");
        System.out.println("2. Multifuncional");
        int opcion = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese documento a imprimir: ");
        String doc = sc.nextLine();

        if(opcion == 1){
            IImprimir impresora = new Impresora();
            impresora.imprimir(doc);
        } else if(opcion == 2){
            ImpresoraMultifuncional mf = new ImpresoraMultifuncional();
            mf.imprimir(doc);
            System.out.print("Ingrese archivo a escanear: ");
            String archivo = sc.nextLine();
            mf.escanear(archivo);
        } else {
            System.out.println("Opción inválida");
        }
        sc.close();
    }
}
// --- Interfaces y clases ---
interface IImprimir { void imprimir(String doc); }
interface IEscanear { void escanear(String destino); }

class Impresora implements IImprimir {
    public void imprimir(String doc){ System.out.println("Imprimiendo: "+doc); }
}

class ImpresoraMultifuncional implements IImprimir, IEscanear {
    public void imprimir(String doc){ System.out.println("Imprimiendo: "+doc); }
    public void escanear(String destino){ System.out.println("Escaneando a: "+destino); }
}
