package Actividad_Asincronica.Ejercicio2;
import java.util.ArrayList;

public class Olimpiada {

    private String nombre;
    private int año;
    private ArrayList<Evento> eventos;

    public Olimpiada(String nombre, int año) {

        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Nombre de olimpiada inválido.");
            this.nombre = "Olimpiada sin nombre";
        } else {
            this.nombre = nombre;
        }

        if (año <= 0) {
            System.out.println("Año inválido. Se asigna 2000 por defecto.");
            this.año = 2000;
        } else {
            this.año = año;
        }

        eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
        System.out.println("Evento registrado.");
    }

    public Evento buscarEvento(String nombre) {
        for (Evento e : eventos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        System.out.println("Eventos registrados:");
        for (Evento e : eventos) {
            System.out.println("- " + e.getNombre());
        }
    }
}

