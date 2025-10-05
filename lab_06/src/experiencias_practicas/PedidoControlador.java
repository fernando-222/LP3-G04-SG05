package experiencias_practicas;
public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void iniciar() {
        String op;
        do {
            vista.mostrarMenu();
            op = vista.leerTexto("Opción: ");
            switch (op) {
                case "1":
                    String nombre = vista.leerTexto("Nombre del plato: ");
                    String tipo = vista.leerTexto("Tipo: ");
                    modelo.agregarPedido(new Pedido(nombre, tipo));
                    vista.mostrarMensaje("Pedido agregado.");
                    break;
                case "2":
                    vista.mostrarPedidos(modelo.listar());
                    break;
                case "3":
                    int id = vista.leerEntero("ID a eliminar: ");
                    vista.mostrarMensaje(modelo.eliminarPorId(id) ? "Eliminado." : "No encontrado.");
                    break;
                case "4":
                    int idUp = vista.leerEntero("ID a actualizar: ");
                    String nNom = vista.leerTexto("Nuevo nombre: ");
                    String nTipo = vista.leerTexto("Nuevo tipo: ");
                    vista.mostrarMensaje(modelo.actualizar(idUp, nNom, nTipo) ? "Actualizado." : "No encontrado.");
                    break;
                case "5":
                    String t = vista.leerTexto("Texto buscar nombre: ");
                    vista.mostrarPedidos(modelo.buscarPorNombre(t));
                    break;
                case "6":
                    String tip = vista.leerTexto("Tipo buscar: ");
                    vista.mostrarPedidos(modelo.buscarPorTipo(tip));
                    break;
                case "7":
                    vista.mostrarMensaje("Total: " + modelo.contarTotal());
                    String tipoC = vista.leerTexto("Contar por tipo (deje vacío para omitir): ");
                    if (!tipoC.isEmpty()) vista.mostrarMensaje("Cantidad: " + modelo.contarPorTipo(tipoC));
                    break;
                case "8":
                    int idc = vista.leerEntero("ID a marcar completo: ");
                    vista.mostrarMensaje(modelo.marcarCompleto(idc) ? "Marcado como completo." : "No encontrado.");
                    break;
                case "9":
                    String est = vista.leerTexto("Estado (PENDIENTE/COMPLETO/ELIMINADO): ").toUpperCase();
                    try {
                        vista.mostrarPedidos(modelo.listarPorEstado(EstadoPedido.valueOf(est)));
                    } catch (Exception e) {
                        vista.mostrarMensaje("Estado inválido.");
                    }
                    break;
                case "10":
                    vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
                    break;
                case "11":
                    vista.mostrarPedidos(modelo.getHistorial());
                    break;
                case "12":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (!op.equals("12"));
    }
}


