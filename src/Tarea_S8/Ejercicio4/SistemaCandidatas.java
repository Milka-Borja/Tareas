package Tarea_S8.Ejercicio4;
import java.util.ArrayList;
public class SistemaCandidatas {
    private ArrayList<Candidata> lista = new ArrayList<>();

    public void registrar(Candidata c) {
        lista.add(c);
        System.out.println("Candidata registrada");
    }

    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay candidatas");
            return;
        }
        System.out.println("---- Lista de Candidatas ----");
        for (Candidata c : lista) {
            c.mostrarDetalles();
        }
    }

    public Candidata buscarPorId(int id) {
        for (Candidata c : lista) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        Candidata c = buscarPorId(id);
        if (c != null) {
            lista.remove(c);
            System.out.println("Candidata eliminada");
        } else {
            System.out.println("No existe esa candidata");
        }
    }

    public void editar(int id, String nuevoNombre, int nuevaEdad, String nuevoDistrito, double nuevoPuntaje) {
        Candidata c = buscarPorId(id);
        if (c == null) {
            System.out.println("No existe esa candidata");
            return;
        }
        try {
            c.setNombre(nuevoNombre);
            c.setEdad(nuevaEdad);
            c.setDistrito(nuevoDistrito);
            c.setPuntajeJurado(nuevoPuntaje);
            System.out.println("Datos actualizados");
        } catch (candidataDatoInvalidoException e) {
            System.out.println("Error al editar" + e.getMessage());
        }
    }

    public void filtrarPorTipo(String tipo) {
        boolean encontrado = false;
        for (Candidata c : lista) {
            if (tipo.equalsIgnoreCase("estudiante") && c instanceof CandidataEstudiante) {
                c.mostrarDetalles();
                encontrado = true;
            }
            if (tipo.equalsIgnoreCase("profesional") && c instanceof CandidataProfesional) {
                c.mostrarDetalles();
                encontrado = true;
            }
            if (!encontrado) {
                System.out.println("No hay candidatas del tipo especificado.\n");
            }
        }
    }
}
