package Tarea_repaso.cancion;

public class Cancion {
    private String titulo;
    private float duracion;
    private int reproducciones;

    public Cancion(String titulo, float duracion, int reproducciones) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.reproducciones = reproducciones;
    }

    public Cancion() {

    }

    public void setTitulo(String titulo) {
        if (titulo.isEmpty()) {
            System.out.println("El campo no puede estar vacio");
        } else {
            this.titulo = titulo;
        }
    }

    public void setDuracion(float duracion) {
        if (duracion < 0) {
            System.out.println("La duracion no puede ser negativa");
        } else {
            this.duracion = duracion;
        }
    }

    public void setReproducciones(int reproducciones) {
        if (reproducciones < 0) {
            System.out.println("Las reproducciones no pueden ser negativas");
        } else {
            this.reproducciones = reproducciones;
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public float getDuracion() {
        return this.duracion;
    }

    public int getReproducciones() {
        return this.reproducciones;
    }

    public void reproducir() {
        reproducciones++;
        System.out.println("Reproducciones: " + reproducciones);
    }
}