package Actividad_Asincronica.Ejercicio2;
public class Atleta extends Participante {

    public Atleta(String nombre, String pais) {
        super(nombre, pais);
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Atleta → Nombre: " + nombre + ", País: " + pais);
    }
}
