package Tarea_S3_1;

public class Main2 {
        public static void main(String[] args) {
            CuentaBancaria2 c = new CuentaBancaria2("Milka Borja");
            c.depositar(1000);
            c.retirar(200);
            c.retirar(1000);

            System.out.println("\nSaldo final: " + c.getSaldo());
            c.mostrarInfo();
        }


}

