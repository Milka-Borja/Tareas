package Tarea_S8.Ejercicio4;

public abstract class Candidata {
    private int id;
    private String nombre;
    private int edad;
    private String distrito;
    private double puntajeJurado;

    public Candidata(int id, String nombre, int edad, String distrito, double puntajeJurado) throws candidataDatoInvalidoException {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new candidataDatoInvalidoException("Nombre vacio");
        }
        if(edad<=0){
            throw new candidataDatoInvalidoException("La edad no puede ser cero o negativa.");
        }
        if(puntajeJurado<0){
            throw new candidataDatoInvalidoException("El puntaje no puede ser negativo.");
        }
        if(distrito==null||distrito.trim().isEmpty()){
            throw new candidataDatoInvalidoException("El distrito esta vacio");
        }
        this.id=id;
        this.nombre=nombre.trim();
        this.edad=edad;
        this.distrito=distrito.trim();
        this.puntajeJurado=puntajeJurado;
    }
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public String getDistrito(){
        return distrito;
    }
    public double getPuntajeJurado(){
        return puntajeJurado;
    }
    public void setNombre(String nombre) throws candidataDatoInvalidoException{
        if(nombre == null || nombre.trim().isEmpty()){
            throw new candidataDatoInvalidoException("Nombre vacio");
        }
        this.nombre=nombre.trim();
    }
    public void setEdad(int edad) throws candidataDatoInvalidoException{
        if(edad<=0){
            throw new candidataDatoInvalidoException("La edad no puede ser cero o negativa.");
        }
        this.edad=edad;
    }

    public void setDistrito(String distrito) throws candidataDatoInvalidoException {
        if(distrito==null||distrito.trim().isEmpty()){
            throw new candidataDatoInvalidoException("El distrito esta vacio");
        }
        this.distrito = distrito;
    }
    public void setPuntajeJurado(double puntajeJurado) throws candidataDatoInvalidoException{
        if(puntajeJurado<0){
            throw new candidataDatoInvalidoException("El puntaje no puede ser negativo.");
        }
        this.puntajeJurado=puntajeJurado;
    }
    public abstract void mostrarDetalles();
}
