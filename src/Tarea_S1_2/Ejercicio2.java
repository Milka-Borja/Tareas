package Tarea_S1_2;
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner h= new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros que desea ingresar: ");
        int c=h.nextInt();
        int p=0;
        for (int i=1; i<=c; i++){
            System.out.println("Ingrese el numero: ");
            int num=h.nextInt();
            if(num%2==0){
                p++;
            }
        }
        System.out.println("El numero de numeros pares ingresados son: "+p);
    }
}
