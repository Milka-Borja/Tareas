package Tarea_S8.Ejercicio1;
import java.util.ArrayList;
import java.util.Scanner;

public class MainGames {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList lista = new ArrayList();
        int opcion;

        do {
            System.out.println("MENU DE JUEGOS");
            System.out.println("1. Registrar juego MariBros");
            System.out.println("2. Registrar juego de Carreras");
            System.out.println("3. Mostrar todos los juegos");
            System.out.println("4. Buscar juego por nombre");
            System.out.println("5. Filtrar por tipo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada invalida.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Valor invalido.");
                            sc.next();
                        }
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Nivel maximo: ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Valor invalido.");
                            sc.next();
                        }
                        int nivel = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Tiene power-ups (true/false): ");
                        while (!sc.hasNextBoolean()) {
                            System.out.println("Valor invalido.");
                            sc.next();
                        }
                        boolean power = sc.nextBoolean();
                        sc.nextLine();
                        MariBros m = new MariBros(nombre,"Usuario",precio,nivel,power);
                        lista.add(m);
                        System.out.println("Juego registrado.");

                    } catch (JuegoDatoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Valor invalido.");
                            sc.next();
                        }
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Numero de vehiculos: ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Valor invalido.");
                            sc.next();
                        }
                        int veh = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Tipo de pista: ");
                        String pista = sc.nextLine();

                        CarreraVehiculos c = new CarreraVehiculos(nombre,"Juan",precio,veh,pista);
                        lista.add(c);
                        System.out.println("Juego registrado.");

                    } catch (JuegoDatoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("No hay juegos registrados.");
                    } else {
                        for (Object obj : lista) {
                            if (obj instanceof Juego) {
                                Juego j = (Juego) obj;
                                j.mostrarDetalles();
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (Object obj : lista) {
                        if (obj instanceof Juego) {
                            Juego j = (Juego) obj;
                            if (j.getNombre().equalsIgnoreCase(buscar)) {
                                j.mostrarDetalles();
                                encontrado = true;
                            }
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No existe un juego con ese nombre.");
                    }
                    break;

                case 5:
                    System.out.println("1. MariBros");
                    System.out.println("2. Carreras");
                    System.out.print("Seleccione tipo: ");

                    while (!sc.hasNextInt()) {
                        System.out.println("Valor invalido.");
                        sc.next();
                    }
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    boolean hay = false;

                    if (tipo == 1) {
                        for (Object obj : lista) {
                            if (obj instanceof MariBros) {
                                ((MariBros) obj).mostrarDetalles();
                                hay = true;
                            }
                        }
                    } else if (tipo == 2) {
                        for (Object obj : lista) {
                            if (obj instanceof CarreraVehiculos) {
                                ((CarreraVehiculos) obj).mostrarDetalles();
                                hay = true;
                            }
                        }
                    } else {
                        System.out.println("Tipo invalido.");
                    }

                    if (!hay && (tipo == 1 || tipo == 2)) {
                        System.out.println("No hay juegos de ese tipo.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 6);
    }
}
