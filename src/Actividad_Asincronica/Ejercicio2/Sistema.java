package Actividad_Asincronica.Ejercicio2;

import java.util.Scanner;

public class Sistema{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Olimpiada ol = new Olimpiada("Olimpiadas Globales", 2024);

        int opcion;

        do {
            System.out.println("\n===== MENÚ OLIMPIADAS =====");
            System.out.println("1. Registrar evento");
            System.out.println("2. Registrar participante en evento");
            System.out.println("3. Mostrar eventos");
            System.out.println("4. Mostrar participantes de un evento");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del evento: ");
                    String nombreEv = sc.nextLine();
                    Evento ev = new Evento(nombreEv);
                    ol.agregarEvento(ev);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del evento: ");
                    String buscar = sc.nextLine();
                    Evento encontrado = ol.buscarEvento(buscar);

                    if (encontrado == null) {
                        System.out.println("Evento no encontrado.");
                        break;
                    }

                    System.out.println("1. Atleta");
                    System.out.println("2. Equipo");
                    System.out.print("Seleccione tipo: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Nombre del atleta: ");
                        String nom = sc.nextLine();
                        System.out.print("País: ");
                        String pais = sc.nextLine();

                        Participante atleta = new Atleta(nom, pais);
                        encontrado.agregarParticipante(atleta);

                    } else if (tipo == 2) {
                        System.out.print("Nombre del equipo: ");
                        String nom = sc.nextLine();
                        System.out.print("País: ");
                        String pais = sc.nextLine();
                        System.out.print("Número de integrantes: ");
                        int num = sc.nextInt();

                        Participante equipo = new Equipo(nom, pais, num);
                        encontrado.agregarParticipante(equipo);
                    } else {
                        System.out.println("Tipo inválido.");
                    }

                    break;

                case 3:
                    ol.mostrarEventos();
                    break;

                case 4:
                    System.out.print("Nombre del evento: ");
                    String ne = sc.nextLine();
                    Evento e = ol.buscarEvento(ne);

                    if (e != null) {
                        e.mostrarParticipantes();
                    } else {
                        System.out.println("Evento no encontrado.");
                    }

                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
