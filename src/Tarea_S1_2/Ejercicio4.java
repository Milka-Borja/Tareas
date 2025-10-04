package Tarea_S1_2;
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args){
        Scanner h= new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String name=h.nextLine();
        System.out.print("Ingrese su edad: ");
        int edad=h.nextInt();
        System.out.print("Ingrese su altura en m: ");
        double alt=h.nextDouble();
        if (edad>=18 && alt>=1.60){
            System.out.println(name+" aceptado para el equipo");
        }else{
            System.out.println(name+" no cumple los requisitos");
        }
    }
}
