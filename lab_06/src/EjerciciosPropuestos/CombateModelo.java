package EjerciciosPropuestos;
public class CombateModelo {
    private Jugador jugador;
    private Enemigo enemigo;
    public CombateModelo(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }
    public Jugador getJugador() { return jugador; }
    public Enemigo getEnemigo() { return enemigo; }
    public boolean combateTerminado() {
        return jugador.getSalud() <= 0 || enemigo.getSalud() <= 0;
    }
    public String resultado() {
        if (jugador.getSalud() <= 0)
            return "El jugador ha sido derrotado.";
        else if (enemigo.getSalud() <= 0)
            return "El enemigo ha sido vencido.";
        else
            return "El combate continúa...";
    }
}
