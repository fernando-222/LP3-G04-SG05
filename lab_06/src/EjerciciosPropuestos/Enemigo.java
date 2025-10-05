package EjerciciosPropuestos;
public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;
    public Enemigo(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.salud = 80 + nivel * 20;
    }
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public void atacar(Jugador jugador) {
        int daño = (int)(Math.random() * 15) + 5;
        jugador.recibirDaño(daño);
        System.out.println(nombre + " ataca a " + jugador.getNombre() + " causando " + daño + " de daño.");
    }
    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }
    @Override
    public String toString() {
        return String.format("%s (%s) | Salud: %d | Nivel: %d",
                nombre, tipo, salud, nivel);
    }
}

