package practicas.excepciones;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private List<String> lista = new ArrayList<>();

    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) 
            throw new IllegalArgumentException("Nombre nulo o vacío");
        lista.add(nombre.trim());
    }

    public String buscarEstudiante(String nombre) {
        for (String s : lista) 
            if (s.equalsIgnoreCase(nombre)) return s;
        throw new NoSuchElementException("Estudiante no encontrado: " + nombre);
    }
}
