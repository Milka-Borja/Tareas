package Tarea_repaso.artista;

public class Artista {
    private String nombre;
    private String genero;
    private int seguidores;

    public Artista(String nombre, String genero, int seguidores) {
        this.nombre = nombre;
        this.genero = genero;
        this.seguidores = seguidores;
    }

    public Artista() {

    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("No puede haber campos vacios");
        } else {
            this.nombre = nombre;
        }
    }
    public void setGenero(String genero) {
        if (genero.isEmpty()) {
            System.out.println("No puede haber campos vacios");
        } else {
            this.genero = genero;
        }
    }
    public void setSeguidores(int seguidores) {
        if (seguidores < 0) {
            System.out.println("No pueden haber valores negativos");
        } else {
            this.seguidores = seguidores;
        }
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getGenero(){
        return this.genero;
    }
    public int getSeguidores(){
        return this.seguidores;
    }
    public void mostrarPerfil(){
        System.out.println("Nombre del artista: "+getNombre()+"Genero: "+getGenero()+"Seguidores: "+getSeguidores());
    }
    public void ganarSeguidores(int cantidad){
        if (cantidad>0){
            this.seguidores= seguidores+cantidad;
            System.out.println("Cantidad de seguidores actual: "+ getSeguidores());
        }
    }
}
