package actividades;

public class PruebaMetodoGeneric {
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada)
            System.out.printf("%s ", elemento);
        System.out.println();
    }

    public static <E> int imprimirArreglo(E[] arregloEntrada, int inferior, int superior) {
        if (inferior < 0 || superior >= arregloEntrada.length || superior <= inferior) {
            throw new InvalidSubscriptException("Índices inválidos");
        }
        int cantidad = 0;
        for (int i = inferior; i <= superior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            cantidad++;
        }
        System.out.println();
        return cantidad;
    }

    public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        imprimirArreglo(arregloInteger);
        imprimirArreglo(arregloDouble);
        imprimirArreglo(arregloCharacter);

        imprimirArreglo(arregloInteger, 1, 3);
        imprimirArreglo(arregloDouble, 2, 5);
        imprimirArreglo(arregloCharacter, 0, 2);
    }
}
