package Tarea_S8.Ejercicio4;
import java.util.ArrayList;
public class SistemaCandidatas {
    private ArrayList<Candidata> lista = new ArrayList<>();
    private ArrayList<Voto> votos = new ArrayList<>();

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
    public void votar(int idCandidata) {
        if (buscarPorId(idCandidata) != null) {
            votos.add(new Voto(idCandidata));
            System.out.println("Voto registrado correctamente.");
        } else {
            System.out.println("No existe candidata con ese ID.");
        }
    }
    public int contarVotosDe(int id) {
        int total = 0;
        for (Voto v : votos) {
            if (v.getIdCandidata() == id) {
                total++;
            }
        }
        return total;
    }
    public Candidata obtenerGanadora() {
        if (votos.isEmpty()) {
            System.out.println("No hay votos aún.");
            return null;
        }

        Candidata mejor = null;
        int maxVotos = -1;

        for (Candidata c : lista) {
            int v = contarVotosDe(c.getId());

            if (v > maxVotos) {
                maxVotos = v;
                mejor = c;
            }
            else if (v == maxVotos && mejor != null) {
                if (c.getPuntajeJurado() > mejor.getPuntajeJurado()) {
                    mejor = c;
                }
            }
        }

        return mejor;
    }





}
