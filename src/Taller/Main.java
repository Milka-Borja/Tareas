package Taller;

public class Main {
    public static void main(String [] args) {
        Persona pe = new Persona("1754106399", "Milka", 19);
        System.out.println("------------------------------------------------");
        pe.mostrar();
        Estudiante est= new Estudiante("1754156783", "Juan", 23,1234);
        System.out.println("----------------Informacion Estudiante-------------------");
        est.mostrarr();
        Docente doc= new Docente("176893940","Julia",34,"Historia");
        System.out.println("----------------Informacion Docente-------------------");
        doc.mostrarrr();
    }
}