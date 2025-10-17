package Tarea_S3_1;

public class Producto {

    private double precio;
    private String nombre;

    public void setPrecio(double p) {
        if (p > 0) {
            precio = p;
            System.out.println("Precio ingresado correctamente.");
        } else {
            System.out.println("Error: el precio debe ser mayor a 0.");
        }
    }

    public void setNombre(String n) {
        if (n != null && !n.trim().isEmpty()) {
            nombre = n;
            System.out.println("Nombre ingresado correctamente.");
        } else {
            System.out.println("Error: el nombre no puede estar vacío.");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInfo() {
        System.out.println("----- Información del producto -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
    }

    public static void main(String[] args) {
        Producto prod1 = new Producto();

        prod1.setNombre("Laptop");
        prod1.setPrecio(1200);
        prod1.mostrarInfo();

        prod1.setNombre("");
        prod1.setPrecio(-500);
    }
}