package Tarea_S8.Ejercicio4;
public class CandidataProfesional extends Candidata {
    private String profesion;
    private int aniosExperiencia;
    public CandidataProfesional(int id,String nombre, int edad, String distrito, double puntajeJurado,String profesion,int aniosExperiencia) throws candidataDatoInvalidoException{
        super(id,nombre,edad,distrito,puntajeJurado);
        if(profesion==null|| profesion.trim().isEmpty()){
            throw new candidataDatoInvalidoException("Profesion vacia");
        }
        if(aniosExperiencia<0){
            throw new candidataDatoInvalidoException("Los años de experciencia no pueden ser negativos");
        }
        this.profesion=profesion;
        this.aniosExperiencia=aniosExperiencia;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("ID: "+getId());
        System.out.println("Nombre: "+getNombre());
        System.out.println("Edad: "+ getEdad());
        System.out.println("Distrito: "+getDistrito());
        System.out.println("Puntaje Jurado: "+ getPuntajeJurado());
        System.out.println("Profesion: "+profesion);
        System.out.println("Años de Experiencia: "+aniosExperiencia);
        System.out.println("-----------------------------------------------------");
    }

}
