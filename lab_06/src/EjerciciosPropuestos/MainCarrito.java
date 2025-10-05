package EjerciciosPropuestos;
public class MainCarrito {
    public static void main(String[] args) {
        CarritoModelo modelo = new CarritoModelo();
        CarritoVista vista = new CarritoVista();
        // Catálogo ejemplo
        modelo.agregarProductoCatalogo(new Producto(1, "Camisa", 49.90));
        modelo.agregarProductoCatalogo(new Producto(2, "Pantalón", 89.50));
        modelo.agregarProductoCatalogo(new Producto(3, "Zapatillas", 150.00));
        modelo.agregarProductoCatalogo(new Producto(4, "Gorra", 25.00));
        modelo.agregarProductoCatalogo(new Producto(5, "Mochila", 120.00));
        CarritoControlador controlador = new CarritoControlador(modelo, vista);
        controlador.iniciar();
    }
}
