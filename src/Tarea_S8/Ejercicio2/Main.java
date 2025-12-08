package Tarea_S8.Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Dispositivo> lista = new ArrayList<>();

        int op = 0;
        while (op != 4) {
            System.out.println("1. Registrar Laptop");
            System.out.println("2. Registrar Telefono");
            System.out.println("3. Mostrar dispositivos");
            System.out.println("4. Salir");
            op = Integer.parseInt(sc.nextLine());

            try {
                if (op == 1) {
                    System.out.print("Marca: ");
                    String m = sc.nextLine();
                    System.out.print("Modelo: ");
                    String mo = sc.nextLine();
                    System.out.print("Precio: ");
                    double p = Double.parseDouble(sc.nextLine());
                    System.out.print("RAM: ");
                    int r = Integer.parseInt(sc.nextLine());

                    Laptop lap = new Laptop(m, mo, p, r);
                    lista.add(lap);
                }

                if (op == 2) {
                    System.out.print("Marca: ");
                    String m = sc.nextLine();
                    System.out.print("Modelo: ");
                    String mo = sc.nextLine();
                    System.out.print("Precio: ");
                    double p = Double.parseDouble(sc.nextLine());
                    System.out.print("Tipo: ");
                    String t = sc.nextLine();

                    Telefono tel = new Telefono(m, mo, p, t);
                    lista.add(tel);
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Valor numerico invalido");
            }

            if (op == 3) {
                for (Dispositivo d : lista) {
                    d.mostrarInfo();
                    System.out.println();
                }
            }
        }
    }
}

