import java.util.Scanner;
public class Ejercicio3 {
    public static void main (String[] args){
        Scanner h= new Scanner(System.in);
        System.out.println("Ingrese la edad del estudiante: ");
        int edad = h.nextInt();
        System.out.println("Ingrese la estatura en metros: ");
        double estatura= h.nextDouble();

        if (edad>=18 & estatura>=1.60){
            System.out.print("Si cumple");
        }else{
            System.out.print("No cumple");
        }
    }
}
