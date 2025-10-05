package EjerciciosPropuestos;
public class CombateControlador {
    private CombateModelo modelo;
    private CombateVista vista;
    public CombateControlador(CombateModelo modelo, CombateVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void iniciarCombate() {
        vista.mostrarMensaje("¡Comienza el combate!");
        while (!modelo.combateTerminado()) {
            vista.mostrarEstado(modelo.getJugador(), modelo.getEnemigo());
            String op = vista.leerAccion();
            switch (op) {
                case "1": modelo.getJugador().atacar(modelo.getEnemigo()); break;
                case "2": modelo.getJugador().usarPocion(); break;
                case "3":
                    vista.mostrarMensaje("El jugador se retira del combate.");
                    return;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
            if (modelo.getEnemigo().getSalud() > 0)
                modelo.getEnemigo().atacar(modelo.getJugador());
        }
        vista.mostrarMensaje(modelo.resultado());
    }
}
