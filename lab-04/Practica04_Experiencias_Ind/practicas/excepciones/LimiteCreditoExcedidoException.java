package practicas.excepciones;

public class LimiteCreditoExcedidoException extends RuntimeException {
    public LimiteCreditoExcedidoException(String msg) {
        super(msg);
    }
}
