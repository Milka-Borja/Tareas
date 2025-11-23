package Tarea_S8.Ejercicio4;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Candidata> lista = new ArrayList<>();
        int op=0;
        while(op != 7){
            System.out.println("---- Ménu Candidatas ----");
            System.out.println("1. Registrar Candidatas \n2. Mostrar Candidatas\n 3. Eliminar candidata\n4. Editar candidata\n5. Buscar candidata \n6. Filtrar por tipo\n 7. Salir");
            op = Integer.parseInt(sc.nextLine());

        }

    }
}
