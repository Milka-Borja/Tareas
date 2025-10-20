package Tarea_repaso;

import Tarea_repaso.artista.Artista;
import Tarea_repaso.cancion.Cancion;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner h = new Scanner(System.in);
        Artista artista1 = new Artista("Lana del Rey", "Pop alternativo", 2000000000);
        Artista artista2 = new Artista();
        Cancion cancion1 = new Cancion();

        while (true) {
            System.out.println("1-\tRegistrar un artista.\n" +
                    "2-\tRegistrar una canción.\n" +
                    "3-\tAumentar seguidores.\n" +
                    "4-\tReproducir una canción.\n" +
                    "5-\tMostrar información general.\n");
            System.out.println("Ingrese la opcion que desea: ");
            int opcion= h.nextInt();
            h.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre del artista: ");
                    artista2.setNombre(h.nextLine());
                    System.out.println("Ingrese el genero: ");
                    artista2.setGenero(h.nextLine());
                    System.out.println("Ingrese la cantidad de seguidores: ");
                    artista2.setSeguidores(h.nextInt());

                    break;

                case 2:
                    System.out.println("Ingrese el titulo de la cancion: ");
                    cancion1.setTitulo(h.nextLine());
                    System.out.println("Ingrese la duracion: ");
                    cancion1.setDuracion(h.nextFloat());
                    cancion1.setReproducciones(0);

                    break;
                case 3:
                    System.out.println("1.Artista1\n2.Artista2\nEscoja que artista: ");
                    int op=h.nextInt();
                    if(op==1){
                        System.out.println("Ingrese la cantidad de nuevos seguidores");
                        artista1.ganarSeguidores(h.nextInt());
                    }else{
                        System.out.println("Ingrese la cantidad de nuevos seguidores");
                        artista2.ganarSeguidores(h.nextInt());
                    }
                    break;
                case 4:
                    cancion1.reproducir();
                    break;
                case 5:
                    artista1.mostrarPerfil();
                    System.out.println("----------------------------------------------------");
                    artista2.mostrarPerfil();
                    System.out.println("----------------------------------------------------");
                    System.out.println("Información de la canción:");
                    System.out.println("Título: " + cancion1.getTitulo());
                    System.out.println("Duración: " + cancion1.getDuracion());
                    System.out.println("Reproducciones: " + cancion1.getReproducciones());
                    break;

            }
        }
    }
}
