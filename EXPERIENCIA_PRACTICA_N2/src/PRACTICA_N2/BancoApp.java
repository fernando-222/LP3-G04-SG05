package PRACTICA_N2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoApp {
    private List<Cuent> cuents;

    public BancoApp() {
        cuents = new ArrayList<>();
        // Crear 5 cuentas corrientes
        for (int i = 1; i <= 5; i++) {
            cuents.add(new CuentCorriente("CC-" + i, 100.0));
        }
        // Crear 5 cuentas de ahorro
        for (int i = 1; i <= 5; i++) {
            cuents.add(new CuentAhorro("CA-" + i, 100.0, 0.06));
        }
    }

    private Cuent buscarCuent(String numero) {
        for (Cuent c : cuents) {
            if (c.getNumero().equalsIgnoreCase(numero)) {
                return c;
            }
        }
        return null;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("\n=== MENÚ BANCO ===");
            System.out.println("D) Depositar");
            System.out.println("R) Retirar");
            System.out.println("C) Consultar (procesar mes)");
            System.out.println("S) Salir");
            System.out.print("Elija opción: ");
            opcion = sc.nextLine().trim().toUpperCase();

            switch (opcion) {
                case "D":
                    System.out.print("Número de cuenta: ");
                    String nd = sc.nextLine();
                    Cuent cd = buscarCuent(nd);
                    if (cd != null) {
                        System.out.print("Importe a depositar: ");
                        double importe = Double.parseDouble(sc.nextLine());
                        cd.depositar(importe);
                        System.out.println("Nuevo saldo: " + cd.getSaldo());
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case "R":
                    System.out.print("Número de cuenta: ");
                    String nr = sc.nextLine();
                    Cuent cr = buscarCuent(nr);
                    if (cr != null) {
                        System.out.print("Importe a retirar: ");
                        double importe = Double.parseDouble(sc.nextLine());
                        if (cr.retirar(importe)) {
                            System.out.println("Retiro exitoso. Nuevo saldo: " + cr.getSaldo());
                        } else {
                            System.out.println("No se pudo realizar el retiro.");
                        }
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case "C":
                    System.out.println("Procesando fin de mes...");
                    for (Cuent c : cuents) {
                        c.consultar();
                        System.out.println(c);
                    }
                    break;

                case "S":
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("S"));

        sc.close();
    }

    public static void main(String[] args) {
        BancoApp app = new BancoApp();
        app.menu();
    }
}
