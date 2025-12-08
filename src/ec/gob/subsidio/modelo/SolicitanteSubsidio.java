package ec.gob.subsidio.modelo;

public class SolicitanteSubsidio {

    private String nombreCompleto;
    private String cedula;
    private double ingresosMensuales;
    private int cantidadVehiculos;
    private boolean viveEnEcuador;

    private static final double LIMITE_INGRESOS = 1200.0;
    private static final int LIMITE_VEHICULOS = 1;
    private static final double INGRESO_MINIMO_VALIDO = 470.0;

    private static final double KM_BASE_MENSUAL = 400.0;
    private static final double KM_POR_GALON = 40.0;

    public SolicitanteSubsidio(String nombreCompleto, String cedula, double ingresosMensuales, int cantidadVehiculos, boolean viveEnEcuador) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.setIngresosMensuales(ingresosMensuales);
        this.setCantidadVehiculos(cantidadVehiculos);
        this.viveEnEcuador = viveEnEcuador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(double ingresosMensuales) {
        if (ingresosMensuales >= INGRESO_MINIMO_VALIDO) {
            this.ingresosMensuales = ingresosMensuales;
        } else {
            System.out.println("Advertencia: El ingreso " + ingresosMensuales + " es menor al mínimo válido ($470). Se registrará el mínimo.");
            this.ingresosMensuales = INGRESO_MINIMO_VALIDO;
        }
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        if (cantidadVehiculos >= 0) {
            this.cantidadVehiculos = cantidadVehiculos;
        } else {
            System.out.println("Advertencia: La cantidad de vehículos no puede ser negativa. Se registrará 0.");
            this.cantidadVehiculos = 0;
        }
    }

    public boolean isViveEnEcuador() {
        return viveEnEcuador;
    }

    public void setViveEnEcuador(boolean viveEnEcuador) {
        this.viveEnEcuador = viveEnEcuador;
    }

    public static void mostrarReglasSubsidio() {
        System.out.println("Reglas para obtener el subsidio");
        System.out.println("1. Tener ingresos mensuales menores o iguales a $1,200.");
        System.out.println("2. No poseer más de un vehiculo registrado.");
        System.out.println("3. Tener residencia en Ecuador.");
    }

    public boolean subsidioAprobado() {
        boolean cumpleIngresos = this.ingresosMensuales <= LIMITE_INGRESOS;
        boolean cumpleVehiculos = this.cantidadVehiculos <= LIMITE_VEHICULOS;
        boolean cumpleResidencia = this.viveEnEcuador;

        return cumpleIngresos && cumpleVehiculos && cumpleResidencia;
    }

    public void generarResultado() {
        System.out.println("===== Resultado de la evaluación =====");
        if (this.subsidioAprobado()) {
            System.out.println("Subsidio aprobado: Cumple con todos los requisitos establecidos por el Gobierno del Ecuador.");
        } else {
            System.out.println("Subsidio rechazado: No cumple con los siguientes requisitos:");
            if (this.ingresosMensuales > LIMITE_INGRESOS) {
                System.out.println(" - Sus ingresos ($" + this.ingresosMensuales + ") superan el límite de $" + LIMITE_INGRESOS + ".");
            }
            if (this.cantidadVehiculos > LIMITE_VEHICULOS) {
                System.out.println(" - Posee " + this.cantidadVehiculos + " vehículos (límite: " + LIMITE_VEHICULOS + ").");
            }
            if (!this.viveEnEcuador) {
                System.out.println(" - No tiene residencia en Ecuador.");
            }
        }
    }

    public double calcularConsumoMensual() {
        return KM_BASE_MENSUAL / KM_POR_GALON;
    }

    public double calcularConsumoMensual(double kmExtra) {
        return (KM_BASE_MENSUAL + kmExtra) / KM_POR_GALON;
    }

    @Override
    public String toString() {
        return "===== Datos del solicitante =====\n" +
                "Nombre: " + nombreCompleto + "\n" +
                "Cédula: " + cedula + "\n" +
                "Ingresos mensuales: $" + ingresosMensuales + "\n" +
                "Cantidad de vehículos: " + cantidadVehiculos + "\n" +
                "Vive en Ecuador: " + viveEnEcuador;
    }
}