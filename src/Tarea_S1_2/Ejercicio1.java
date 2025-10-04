package Tarea_S1_2;
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args){
        Scanner h= new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante: ");
        String name=h.nextLine();
        System.out.println("Ingrese la primera nota: ");
        double nota1=h.nextDouble();
        System.out.println("Ingrese la segunda nota: ");
        double nota2=h.nextDouble();
        System.out.println("Ingrese la tercera nota: ");
        double nota3=h.nextDouble();
        double promedio=(nota1+nota2+nota3)/3;
        if (promedio>=7){
            System.out.println("El estudiante "+name+" con promedio de: "+promedio+" ha aprobado");
        }else{
            System.out.println("El estudiante "+name+" con promedio de: "+promedio+" ha reprobado");
        }

    }
}
