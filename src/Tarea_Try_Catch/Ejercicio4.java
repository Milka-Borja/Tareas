package Tarea_Try_Catch;

public class Ejercicio4 {

    public static void validarPago(double pago) throws PagoInvalidoException {

        if (pago < 0) throw new PagoInvalidoException("El pago no puede ser negativo");
        if (pago == 0) throw new PagoInvalidoException("El pago no puede ser 0");
        if (pago > 5000) throw new PagoInvalidoException("El pago no puede superar 5000");
    }

    public static void main(String[] args) {

        try {
            validarPago(-10);
        } catch (PagoInvalidoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

