package Tarea_S8.Ejercicio4;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SistemaCandidatas sistema = new SistemaCandidatas();
        int op=0;
        while(op != 7){
            System.out.println("---- Ménu Candidatas ----");
            System.out.println("1. Registrar Candidatas \n2. Mostrar Candidatas\n 3. Eliminar candidata\n4. Editar candidata\n5. Buscar candidata \n6. Filtrar por tipo\n 7. Salir");
            op = Integer.parseInt(sc.nextLine());

            switch(op) {
                case 1:
                    try {
                        System.out.println("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Edad: ");
                        int edad = Integer.parseInt(sc.nextLine());
                        System.out.println("Distrito: ");
                        String distrito = sc.nextLine();
                        System.out.println("Puntaje Jurado: ");
                        double puntaje = Double.parseDouble(sc.nextLine());

                        System.out.println("Tipo de candidata:");
                        System.out.println("1. Estudiante");
                        System.out.println("2. Profesional");
                        int tipo = Integer.parseInt(sc.nextLine());

                        Candidata c;

                        if (tipo == 1) {
                            System.out.println("Universidad: ");
                            String uni = sc.nextLine();
                            System.out.println("Carrera: ");
                            String carrera = sc.nextLine();
                            c = new CandidataEstudiante(id, nombre, edad, distrito, puntaje, uni, carrera);

                        } else {
                            System.out.println("Profesion: ");
                            String profesion = sc.nextLine();
                            System.out.println("Años de experiencia: ");
                            int exp = Integer.parseInt(sc.nextLine());
                            c = new CandidataProfesional(id, nombre, edad, distrito, puntaje, profesion, exp);
                        }
                        sistema.registrar(c);
                    }catch (Exception e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 2:
                    sistema.mostrar();
                    break;
                case 3:
                    System.out.print("ID a eliminar: ");
                    int idEliminar = Integer.parseInt(sc.nextLine());
                    sistema.eliminar(idEliminar);
                    break;
                case 4:
                    System.out.print("ID a editar: ");
                    int idEditar = Integer.parseInt(sc.nextLine());

                    System.out.print("Nuevo nombre: ");
                    String nn = sc.nextLine();
                    System.out.print("Nueva edad: ");
                    int ne = Integer.parseInt(sc.nextLine());
                    System.out.print("Nuevo distrito: ");
                    String nd = sc.nextLine();
                    System.out.print("Nuevo puntaje: ");
                    double np = Double.parseDouble(sc.nextLine());

                    sistema.editar(idEditar, nn, ne, nd, np);
                    break;
                case 5:
                    System.out.print("ID a buscar: ");
                    int idBuscado = Integer.parseInt(sc.nextLine());

                    Candidata candidataID = sistema.buscarPorId(idBuscado);

                    if (candidataID != null) {
                        candidataID.mostrarDetalles();
                    } else {
                        System.out.println("No existe candidata con ese ID.");
                    }
                    break;
                case 6:
                    System.out.println("Tipo (estudiante/profesional)");
                    String tipo = sc.nextLine();
                    sistema.filtrarPorTipo(tipo);
                    break;
                case 7:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion invalida");

            }
        }

    }
}
