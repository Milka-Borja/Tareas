package Tarea_Try_Catch;

public class ProductoImportado extends Producto {

    public ProductoImportado(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.05;
    }
}
