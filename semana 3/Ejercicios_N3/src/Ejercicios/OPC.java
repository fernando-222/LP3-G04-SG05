package Ejercicios;

import java.util.*;

public class OCP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Canvas canvas = new Canvas();
        canvas.registrar(Circulo.class,new RenderCirculo());
        canvas.registrar(Rectangulo.class,new RenderRectangulo());
        canvas.registrar(Triangulo.class,new RenderTriangulo());

        System.out.println("Seleccione figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Rectángulo");
        System.out.println("3. Triángulo");
        int opcion = sc.nextInt();

        switch(opcion){
            case 1 -> {
                System.out.print("Ingrese radio: ");
                double r = sc.nextDouble();
                canvas.dibujar(new Circulo(r));
            }
            case 2 -> {
                System.out.print("Ingrese ancho y alto: ");
                double w = sc.nextDouble();
                double h = sc.nextDouble();
                canvas.dibujar(new Rectangulo(w,h));
            }
            case 3 -> {
                System.out.print("Ingrese lados a, b, c: ");
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                double c = sc.nextDouble();
                canvas.dibujar(new Triangulo(a,b,c));
            }
            default -> System.out.println("Opción inválida");
        }

        sc.close();
    }
}

// --- Interfaces y clases ---
interface Forma {}
class Circulo implements Forma { double r; Circulo(double r){this.r=r;} }
class Rectangulo implements Forma { double w,h; Rectangulo(double w,double h){this.w=w;this.h=h;} }
class Triangulo implements Forma { double a,b,c; Triangulo(double a,double b,double c){this.a=a;this.b=b;this.c=c;} }

interface Renderizador<T extends Forma>{ void dibujar(T f); }
class RenderCirculo implements Renderizador<Circulo>{ public void dibujar(Circulo f){System.out.println("Dibujando Círculo de radio " + f.r);}}
class RenderRectangulo implements Renderizador<Rectangulo>{ public void dibujar(Rectangulo f){System.out.println("Dibujando Rectángulo de " + f.w + "x" + f.h);}}
class RenderTriangulo implements Renderizador<Triangulo>{ public void dibujar(Triangulo f){System.out.println("Dibujando Triángulo con lados " + f.a + "," + f.b + "," + f.c);}}

class Canvas {
    private final Map<Class<?>,Renderizador<?>> renderers=new HashMap<>();
    public <T extends Forma> void registrar(Class<T> tipo,Renderizador<T> r){ renderers.put(tipo,r); }
    @SuppressWarnings("unchecked")
    public <T extends Forma> void dibujar(T f){ ((Renderizador<T>)renderers.get(f.getClass())).dibujar(f); }
}

