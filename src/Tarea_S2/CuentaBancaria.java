package Tarea_S2;

import java.util.Scanner;

public class CuentaBancaria {
    private String nombreTitular;
    private double saldo;
    Scanner h=new Scanner(System.in);
    public CuentaBancaria(String nombreTitular, double saldo){
        this.nombreTitular=nombreTitular;
        this.saldo=saldo;
    }
    public void mostrarinformacion(){
        System.out.println("Titular de la cuenta: "+nombreTitular+"\nSaldo actual: "+saldo);
    }
    public void depositar(double saldo){

        System.out.println("Ingrese la cantidad que desea depositar: ");
        double deposito=h.nextDouble();
        double saldoActual= deposito+saldo;
        System.out.println("Su saldo actual es: "+saldoActual);
    }
    public void retirar(double saldo){
        System.out.println("Ingrese la cantidad que desea retirar: ");
        double retiro= h.nextDouble();
        if (retiro <= saldo) {
            double saldoActual2= saldo-retiro;
            System.out.println("Su saldo actual es: "+saldoActual2);
        } else if (saldo<retiro) {
            System.out.println("Saldo insuficiente");
        }
    }
    public void setSaldo( double saldo){
        this.saldo = saldo;

    }

    public double getSaldo() {
        return saldo;
    }
}
