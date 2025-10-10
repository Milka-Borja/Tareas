package Tarea_S2;
import java.util.Scanner;
public class Banco {
    public static void main(String[] args){
        Scanner h=new Scanner(System.in);
        CuentaBancaria cuenta1 = new CuentaBancaria("Milka Borja",10.00);
        cuenta1.mostrarinformacion();
        while(true){
            System.out.println("Opciones a escoger:\n1. Depositar.\n2. Retirar.\n3. Salir. \nIngrese la opcion que desea: ");
            int opcion = h.nextInt();
            if(opcion==1){
            cuenta1.depositar(cuenta1.getSaldo());
            } else if (opcion==2) {
            cuenta1.retirar(cuenta1.getSaldo());
            } else if(opcion==3){
                System.out.println("Saliendo de la cuenta.....");
            break;
            }
    }
}
}

