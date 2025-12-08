package Tarea_S8.Ejercicio1;

public class CarreraVehiculos extends Juego {
    private int numVehiculos;
    private String tipoPista;

    public CarreraVehiculos(String nombre, String desarrollador, double precio, int numVehiculos, String tipoPista) throws JuegoDatoInvalidoException {
        super(nombre, desarrollador, precio);
        if (numVehiculos <= 0) {
            throw new JuegoDatoInvalidoException("Número de vehículos debe ser positivo");
        }
        if (tipoPista == null || tipoPista.trim().isEmpty()) {
            throw new JuegoDatoInvalidoException("Tipo de pista vacío");
        }
        this.numVehiculos = numVehiculos;
        this.tipoPista = tipoPista.trim();
    }

    public int getNumVehiculos() {
        return numVehiculos;
    }

    public String getTipoPista() {
        return tipoPista;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Tipo: CarreraVehiculos");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Desarrollador: " + getDesarrollador());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Número de vehículos: " + numVehiculos);
        System.out.println("Tipo de pista: " + tipoPista);
        System.out.println("---------------------------");
    }
}

