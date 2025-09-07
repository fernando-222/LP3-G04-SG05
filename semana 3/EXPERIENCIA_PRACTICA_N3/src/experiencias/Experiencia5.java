package experiencias;

import java.util.Scanner;

public class Experiencia5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione canal de notificación:");
        System.out.println("1. Correo");
        System.out.println("2. SMS");
        int opcion = sc.nextInt();
        sc.nextLine();

        CanalNotificacion canal;
        if (opcion == 1) canal = new EnviadorCorreo();
        else if (opcion == 2) canal = new EnviadorSMS();
        else throw new IllegalArgumentException("Opción inválida");

        System.out.print("Ingrese destinatario: ");
        String destino = sc.nextLine();

        NotificadorReserva noti = new NotificadorReserva(canal);
        noti.notificarConfirmacion(destino, "R-123");

        sc.close();
    }
}

// --- Interfaces y clases ---
interface CanalNotificacion {
    void enviarNotificacion(String destino,String mensaje);
}

class EnviadorCorreo implements CanalNotificacion {
    public void enviarNotificacion(String destino,String mensaje){
        System.out.println("[EMAIL a "+destino+"] "+mensaje);
    }
}

class EnviadorSMS implements CanalNotificacion {
    public void enviarNotificacion(String destino,String mensaje){
        System.out.println("[SMS a "+destino+"] "+mensaje);
    }
}

class NotificadorReserva {
    private final CanalNotificacion canal;
    public NotificadorReserva(CanalNotificacion canal){ this.canal=canal; }
    public void notificarConfirmacion(String destino,String idReserva){
        canal.enviarNotificacion(destino,"Reserva confirmada: "+idReserva);
    }
}
