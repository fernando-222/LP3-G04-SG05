package EjerciciosPropuestos;
public class MainInventario {
    public static void main(String[] args) {
        InventarioModelo modelo = new InventarioModelo();
        InventarioVista vista = new InventarioVista();
        InventarioControlador controlador = new InventarioControlador(modelo, vista);
        controlador.iniciar();
    }
}
