package Tarea_S3_1;

import java.util.Scanner;

public class Persona {
    private String nombre;
    private int edad;
    private String profesion;

    // Constructor vacío
    public Persona() {}

    // Constructor con parámetros
    public Persona(String nombre, int edad, String profesion) {
        setNombre(nombre);
        setEdad(edad);
        setProfesion(profesion);
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Nombre invalido.");
        } else {
            this.nombre = nombre;
            System.out.println("Nombre ingresado correctamente.");
        }
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            System.out.println("Edad invalida.");
        } else {
            this.edad = edad;
            System.out.println("Edad ingresada correctamente.");
        }
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
        System.out.println("Profesión ingresada correctamente.");
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getProfesion() {
        return profesion;
    }
}






