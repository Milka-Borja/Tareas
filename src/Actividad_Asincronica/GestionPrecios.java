package Actividad_Asincronica;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionPrecios {
    static ArrayList<Double> precios = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("===== MENÚ DE PRECIOS INMOBILIARIOS =====");
            System.out.println("1. Ingresar precio");
            System.out.println("2. Mostrar todos los precios");
            System.out.println("3. Mostrar precio más alto");
            System.out.println("4. Mostrar precio más bajo");
            System.out.println("5. Mostrar precios iguales");
            System.out.println("6. Buscar un precio");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarPrecio();
                    break;
                case 2:
                    mostrarPrecios();
                    break;
                case 3:
                    precioMasAlto();
                    break;
                case 4:
                    precioMasBajo();
                    break;
                case 5:
                    preciosIguales();
                    break;
                case 6:
                    buscarPrecio();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        } while (opcion != 7);
    }

    public static void ingresarPrecio() {
        System.out.print("Ingrese un precio: ");
        double precio = sc.nextDouble();

        if (precio > 0) {
            precios.add(precio);
            System.out.println("Precio agregado correctamente.");
        } else {
            System.out.println("El precio debe ser mayor que cero.");
        }
    }

    public static void mostrarPrecios() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
        } else {
            System.out.println("Lista de precios:");
            for (double p : precios) {
                System.out.println(p);
            }
        }
    }

    public static void precioMasAlto() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        double max = precios.get(0);
        for (double p : precios) {
            if (p > max) {
                max = p;
            }
        }
        System.out.println("El precio más alto es: " + max);
    }

    public static void precioMasBajo() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        double min = precios.get(0);
        for (double p : precios) {
            if (p < min) {
                min = p;
            }
        }
        System.out.println("El precio más bajo es: " + min);
    }

    public static void preciosIguales() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        boolean encontrados = false;
        System.out.println("Precios repetidos:");

        for (int i = 0; i < precios.size(); i++) {
            for (int j = i + 1; j < precios.size(); j++) {
                if (precios.get(i).equals(precios.get(j))) {
                    System.out.println(precios.get(i));
                    encontrados = true;
                }
            }
        }

        if (!encontrados) {
            System.out.println("No hay precios repetidos.");
        }
    }

    public static void buscarPrecio() {
        System.out.print("Ingrese el precio a buscar: ");
        double valor = sc.nextDouble();

        if (precios.contains(valor)) {
            System.out.println("El precio SÍ existe en la lista.");
        } else {
            System.out.println("El precio NO existe.");
        }
    }
}
