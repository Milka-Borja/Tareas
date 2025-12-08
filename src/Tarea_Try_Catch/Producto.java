package Tarea_Try_Catch;

public abstract class Producto {

    protected String codigo;
    protected String nombre;
    protected double precioBase;

    public Producto(String codigo, String nombre, double precioBase) {

        if (codigo == null || codigo.isEmpty())
            throw new IllegalArgumentException("Código vacío");

        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("Nombre vacío");

        if (precioBase < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo");

        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();

    public String toString() {
        return codigo + " - " + nombre + " - $" + calcularPrecioFinal();
    }
}
