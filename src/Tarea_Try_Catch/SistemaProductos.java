package Tarea_Try_Catch;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaProductos {

    public static void main(String[] args) {

        ArrayList<Producto> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Promedio de precios finales");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            String op = sc.nextLine();

            try {

                switch (op) {

                    case "1":
                        System.out.print("Código: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio base: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        System.out.print("1 = Nacional | 2 = Importado: ");
                        String tipo = sc.nextLine();

                        Producto p;

                        if (tipo.equals("1"))
                            p = new ProductoNacional(codigo, nombre, precio);
                        else if (tipo.equals("2"))
                            p = new ProductoImportado(codigo, nombre, precio);
                        else
                            throw new IllegalArgumentException("Tipo inválido");

                        lista.add(p);
                        System.out.println("Producto registrado!");
                        break;

                    case "2":
                        if (lista.isEmpty())
                            throw new DatosInvalidosException("La lista está vacía");

                        for (Producto prod : lista)
                            System.out.println(prod);
                        break;

                    case "3":
                        if (lista.isEmpty())
                            throw new DatosInvalidosException("No se puede calcular promedio");

                        double suma = 0;
                        for (Producto prod : lista)
                            suma += prod.calcularPrecioFinal();

                        System.out.println("Promedio: " + (suma / lista.size()));
                        break;

                    case "4":
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción no válida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar números válidos.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (DatosInvalidosException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado.");
            }
        }
    }
}
