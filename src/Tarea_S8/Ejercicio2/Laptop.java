package Tarea_S8.Ejercicio2;

public class Laptop extends Dispositivo {
    private int ram;

    public Laptop(String marca, String modelo, double precio, int ram) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.ram = ram;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Laptop");
        super.mostrarInfo();
        System.out.println("RAM: " + ram);
    }
}
