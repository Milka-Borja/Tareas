package Actividad_Asincronica.Ejercicio2;
public class Equipo extends Participante {

    private int integrantes;

    public Equipo(String nombre, String pais, int integrantes) {
        super(nombre, pais);

        if (integrantes <= 0) {
            System.out.println("Error: El número de integrantes debe ser mayor a 0.");
            this.integrantes = 1;
        } else {
            this.integrantes = integrantes;
        }
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Equipo → Nombre: " + nombre + ", País: " + pais +
                ", Integrantes: " + integrantes);
    }
}
