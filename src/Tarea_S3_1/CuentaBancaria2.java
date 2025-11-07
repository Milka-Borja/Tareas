package Tarea_S3_1;

public class CuentaBancaria2 {
        private double saldo = 0;
        private String titular;

        public CuentaBancaria2(String titular) {

            this.titular = titular;
        }
        public void depositar(double monto) {
            if (monto > 0) {
                saldo += monto;
                System.out.println("Depósito realizado: " + monto);
            } else {
                System.out.println("}el monto a depositar debe ser positivo.");
            }
        }

        public void retirar(double monto) {
            if (monto <= 0) {
                System.out.println("el monto a retirar debe ser positivo.");
            } else if (monto > saldo) {
                System.out.println("saldo insuficiente.");
            } else {
                saldo -= monto;
                System.out.println("Retiro realizado: " + monto);
            }
        }
        public double getSaldo() {
            return saldo;
        }
        public void mostrarInfo() {
            System.out.println("Titular: " + titular);
            System.out.println("Saldo actual: " + saldo);
        }
    }


