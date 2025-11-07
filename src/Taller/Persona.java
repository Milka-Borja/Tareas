package Taller;

public class Persona {
    String cedula;
    String nombre;
    int edad;

    public Persona(String cedula, String nombre, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;

    }

    public void mostrar() {
        System.out.println("Cedula: ");
        System.out.println(cedula);
        System.out.println("Nombre: ");
        System.out.println(nombre);
        System.out.println("Edad: ");
        System.out.println(edad);

    }
}
class Estudiante extends Persona {
    int codigo;

    public Estudiante(String cedula, String nombre, int edad, int codigo) {
        super(cedula, nombre, edad);
        this.codigo = codigo;
    }

    public void mostrarr() {
        super.mostrar();
        System.out.println("Codigo: " + codigo);
    }


}

class Docente extends Persona {
    String materias;

    public Docente(String cedula, String nombre, int edad, String materias) {
        super(cedula, nombre, edad);
        this.materias = materias;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Materia: " + materias);
    }

}