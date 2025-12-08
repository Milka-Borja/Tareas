package Actividad_Asincronica.Ejercicio2;
import java.util.ArrayList;

public class Evento {

    private String nombre;
    private ArrayList<Participante> participantes;

    public Evento(String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Error: nombre del evento inválido.");
            this.nombre = "Evento sin nombre";
        } else {
            this.nombre = nombre;
        }

        participantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarParticipante(Participante p) {
        participantes.add(p);
        System.out.println("Participante agregado.");
    }

    public void mostrarParticipantes() {

        if (participantes.isEmpty()) {
            System.out.println("Este evento no tiene participantes.");
            return;
        }

        System.out.println("Participantes del evento " + nombre + ":");

        for (Participante p : participantes) {
            p.mostrarTipo();
        }
    }
}

