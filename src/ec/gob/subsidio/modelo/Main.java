package ec.gob.subsidio.modelo;

import ec.gob.subsidio.modelo.SolicitanteSubsidio;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SolicitanteSubsidio.mostrarReglasSubsidio();
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese sus ingresos mensuales: ");
        double ingresos = sc.nextDouble();

        System.out.print("Ingrese la cantidad de vehiculos registrados: ");
        int vehiculos = sc.nextInt();

        System.out.print("¿Vive en Ecuador? (true/false): ");
        boolean vive = sc.nextBoolean();

        System.out.println();

        SolicitanteSubsidio solicitante = new SolicitanteSubsidio(nombre, cedula, ingresos, vehiculos, vive);

        System.out.println(solicitante.toString());
        System.out.println();

        solicitante.generarResultado();
        System.out.println();

        System.out.println("===== Cálculo de consumo mensual =====");

        double consumoBase = solicitante.calcularConsumoMensual();
        System.out.println("Consumo mensual estimado (sin km extra): " + consumoBase + " galones");

        double consumoAdicional = 80.0;
        double consumoConExtra = solicitante.calcularConsumoMensual(consumoAdicional);
        System.out.println("Consumo con kilómetros extra (" + consumoAdicional + " km adicionales): " + consumoConExtra + " galones");

        sc.close();
    }
}
