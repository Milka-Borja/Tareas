package Actividad_Asincronica.Ejercicio2;
public abstract class Participante {
    protected String nombre;
    protected String pais;

    public Participante(String nombre, String pais) {

        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            this.nombre = "Nombre inválido";
        } else {
            this.nombre = nombre;
        }

        if (pais == null || pais.isEmpty()) {
            System.out.println("Error: El país no puede estar vacío.");
            this.pais = "País inválido";
        } else {
            this.pais = pais;
        }
    }

    public abstract void mostrarTipo();
}
