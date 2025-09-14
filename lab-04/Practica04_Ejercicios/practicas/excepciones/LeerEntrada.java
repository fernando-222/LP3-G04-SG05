package practicas.excepciones;

public class LeerEntrada {
    public void procesar(char c) throws VocalException, NumeroException, BlancoException, SalidaException {
        char ch = Character.toLowerCase(c);
        if (ch == 'q') throw new SalidaException("Salir con q");
        if (Character.isDigit(ch)) throw new NumeroException("Número ingresado: " + ch);
        if (Character.isWhitespace(ch)) throw new BlancoException("Se ingresó un espacio");
        if ("aeiou".indexOf(ch) >= 0) throw new VocalException("Se ingresó vocal: " + ch);
    }
}
