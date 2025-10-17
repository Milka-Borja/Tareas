package Tarea_S3_1;

public class Main3  {
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo("Toyota", "Corolla", 180);

        v.marca = "Toyota";
        v.setModelo("Corolla");
        v.setCodigoSeguridad("ABC123");

        v.setColor("Rojo");
        v.setColor("rojo");

        System.out.println("Marca: " + v.marca);
        System.out.println("Modelo: " + v.getModelo());
        System.out.println("Velocidad máxima: " + v.getVelocidadMaxima());
        System.out.println("Color: " + v.getColor());
    }
}

