package Tarea_S8.Ejercicio1;

public abstract class Juego {
    private String nombre;
    private String desarrollador;
    private double precio;

    public Juego(String nombre, String desarrollador, double precio) throws JuegoDatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new JuegoDatoInvalidoException("Nombre vacío");
        }
        if (precio < 0) {
            throw new JuegoDatoInvalidoException("Precio negativo");
        }
        this.nombre = nombre.trim();
        this.desarrollador = desarrollador == null ? "" : desarrollador.trim();
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) throws JuegoDatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new JuegoDatoInvalidoException("Nombre vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador == null ? "" : desarrollador.trim();
    }

    public void setPrecio(double precio) throws JuegoDatoInvalidoException {
        if (precio < 0) {
            throw new JuegoDatoInvalidoException("Precio negativo");
        }
        this.precio = precio;
    }

    public abstract void mostrarDetalles();
}
