package Tarea_S8.Ejercicio4;
public class CandidataEstudiante extends Candidata{
   private String universidad;
   private String carrera;

   public CandidataEstudiante(int id, String nombre, int edad, String distrito, double puntajeJurado,String universidad,String carrera) throws candidataDatoInvalidoException{
       super(id,nombre,edad,distrito,puntajeJurado);
       if(universidad==null||universidad.trim().isEmpty()){
           throw new candidataDatoInvalidoException("Universidad vacia");
       }
       if(carrera==null||carrera.trim().isEmpty()){
           throw new candidataDatoInvalidoException("Carrera vacia");
       }
       this.universidad=universidad;
       this.carrera=carrera;
   }
   public String getUniversidad(){
       return universidad;
   }
   public String getCarrera(){
       return carrera;
   }

    @Override
    public void mostrarDetalles() {
       System.out.println("ID: "+getId());
       System.out.println("Nombre: "+getNombre());
       System.out.println("Edad: "+getEdad());
       System.out.println("Distrito: "+getDistrito());
       System.out.println("Puntaje Jurado: "+getPuntajeJurado());
       System.out.println("Universidad: "+universidad);
       System.out.println("Carrera: "+carrera);
       System.out.println("-------------------------------------------------");

    }
}
