package Tarea_S1_2;
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args){
        Scanner h=new Scanner(System.in);
        System.out.print("Ingrese el numero del 1-10 : ");
        int num=h.nextInt();
        for (int i=1; i<=12;i++){
            int multi=num*i;
            System.out.println(" "+num+" * "+i+" = "+multi);
        }
    }
}
