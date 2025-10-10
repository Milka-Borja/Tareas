package Tarea_S2;

public class Libro {
    String titulo;
    String autor;
    int anoPublicacion;

    //El metodo constructor
    public Libro(String titulo, String autor, int anoPublicacion){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
    }
    public void mostrarinformacion(){
        System.out.println("Titulo del libro: "+titulo+"\nAutor: "+autor+"\nAño de publicación: "+anoPublicacion);
    }
    public static void main(String[] args){
        Libro libro1= new Libro("Ensayo sobre la ceguera","Jose Saramago",1995);
        Libro libro2= new Libro("Asesinato en el Orient Express","Agatha Christie",1934);
        libro1.mostrarinformacion();
        libro2.mostrarinformacion();
    }
}

