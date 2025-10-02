import java.util.Scanner;
public class Ejercicio1 {
    public static void main (String[] args){
        Scanner h= new Scanner(System.in);
        System.out.print("Ingrese la cantidad de productos que desea ingresar: ");
        int num=h.nextInt();
        h.nextLine();
        double totalst=0;
        for (int i=1; i<=num; i++){
            System.out.print("\n- "+ i);
            System.out.print(" Nombre del producto: ");
            String nomb= h.nextLine();
            System.out.print("Precio: ");
            double pre= h.nextDouble();
            System.out.print("Cantidad: ");
            int can= h.nextInt();
            h.nextLine();
            double preciototal= can*pre;
            totalst +=preciototal;
            System.out.print("Precio total de "+nomb+":"+preciototal);



        }
        System.out.print("\n Valor total de Stock: "+totalst);

    }
}