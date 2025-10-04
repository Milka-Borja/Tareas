package Tarea_S1_1;

import java.util.Scanner;
public class Ejercicio2 {
    public static void main (String[] args){
        Scanner h= new Scanner(System.in);
        System.out.print("Ingrese cuantos clientes va a ingresar: ");
        int cl= h.nextInt();
        h.nextLine();
        for (int i=1; i<=cl; i++){
            System.out.print("\nCliente n°"+i);
            System.out.print("\nIngrese la cedula del cliente: ");
            String id= h.nextLine();
            System.out.print("Ingrese los nombres de su cliente: ");
            String nom= h.nextLine();
            System.out.print("Ingrese el numero de telefono: ");
            String cel= h.nextLine();
            System.out.print("Ingrese el email: ");
            String email= h.nextLine();

            if (id.isEmpty() || nom.isEmpty() || cel.isEmpty() || email.isEmpty()){
                System.out.print("No puede haber campos vacios");
            }else {
                System.out.print("\n-----Ficha del Cliente "+i+"-----");
                System.out.print("\nCedula: "+id);
                System.out.print("\nNombre: "+nom);
                System.out.print("\nCelular: "+cel);
                System.out.print("\nEmail: "+email);

            }

        }

    }
}

