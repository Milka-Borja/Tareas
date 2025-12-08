package Tarea_Try_Catch;
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args){
        Scanner h= new Scanner(System.in);
        System.out.print("Ingrese el precio: ");
        String e = h.nextLine();

        try {
            double precio = Double.parseDouble(e);
            double total = precio * 1.15;
            System.out.println("Precio con IVA: " + total);
        } catch (NumberFormatException m) {
            System.out.println("ERROR: Debe ingresar un número válido.");
        }
    }
}