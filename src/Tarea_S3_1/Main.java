package Tarea_S3_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner h = new Scanner(System.in);
        Persona persona1 = new Persona();

        System.out.print("Ingrese su nombre: ");
        String name = h.nextLine();
        persona1.setNombre(name);
        System.out.print("Ingrese su edad: ");
        int age = h.nextInt();
        persona1.setEdad(age);
        h.nextLine();
        System.out.print("Ingrese su profesión: ");
        String pro = h.nextLine();
        persona1.setProfesion(pro);

        System.out.println("\n--- DATOS REGISTRADOS ---");
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());
        System.out.println("Profesión: " + persona1.getProfesion());
    }
}


