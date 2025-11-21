package Tarea_S8.Ejercicio2;

public class Telefono extends Dispositivo {
    private String tipo;

    public Telefono(String marca, String modelo, double precio, String tipo) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.tipo = tipo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Telefono");
        super.mostrarInfo();
        System.out.println("Tipo: " + tipo);
    }
}

