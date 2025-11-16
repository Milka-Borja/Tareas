package Tarea_Try_Catch;

public class Estudiante {

    private String nombre;
    private int edad;

    public Estudiante(String nombre, int edad) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("Edad inválida");
        }

        this.nombre = nombre;
        this.edad = edad;
    }
}

