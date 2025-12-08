package Tarea_Try_Catch;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner h = new Scanner(System.in);

        System.out.println("1. Saludar");
        System.out.println("2. Despedirse");
        System.out.print("Elija una opción: ");

        int opcion = h.nextInt();

        try {
            switch (opcion) {
                case 1:
                    System.out.println("Hola!");
                    break;
                case 2:
                    System.out.println("Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } catch (Exception e) {
            System.out.println("Error inesperado.");
        }
    }
}

