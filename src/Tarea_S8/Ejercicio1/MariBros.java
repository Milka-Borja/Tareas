package Tarea_S8.Ejercicio1;
public class MariBros extends Juego {
    private int nivelMax;
    private boolean tienePowerUps;

    public MariBros(String nombre, String desarrollador, double precio, int nivelMax, boolean tienePowerUps) throws JuegoDatoInvalidoException {
        super(nombre, desarrollador, precio);
        if (nivelMax <= 0) {
            throw new JuegoDatoInvalidoException("Nivel máximo debe ser positivo");
        }
        this.nivelMax = nivelMax;
        this.tienePowerUps = tienePowerUps;
    }

    public int getNivelMax() {
        return nivelMax;
    }

    public boolean isTienePowerUps() {
        return tienePowerUps;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Tipo: MarioBros");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Desarrollador: " + getDesarrollador());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Nivel máximo: " + nivelMax);
        System.out.println("Tiene power-ups: " + (tienePowerUps ? "Sí" : "No"));
        System.out.println("---------------------------");
    }
}
