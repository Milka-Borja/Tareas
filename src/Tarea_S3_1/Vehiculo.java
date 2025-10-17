package Tarea_S3_1;
public class Vehiculo {

    public String marca;
    private String modelo;
    private int velocidadMaxima;
    private String codigoSeguridad;
    private String color;

    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setCodigoSeguridad(String codigo) {
        this.codigoSeguridad = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals("rojo") || color.equals("azul") || color.equals("blanco")) {
            this.color = color;
        } else {
            System.out.println("Color no permitido.");
        }
    }
}

