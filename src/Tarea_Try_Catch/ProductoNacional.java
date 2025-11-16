package Tarea_Try_Catch;

public class ProductoNacional extends Producto {

    public ProductoNacional(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.12;
    }
}
