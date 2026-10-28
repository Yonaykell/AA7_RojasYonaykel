// La reserva es una clase de apoyo. Tour no expone sus objetos Reserva. Aja
class Reserva {
    private int numero;
    private String nombreCliente;
    private int cantidadPersonas;
    private double monto;

    public Reserva(int numero, String nombreCliente,
                   int cantidadPersonas, double monto) {
        this.numero = numero;
        this.nombreCliente = nombreCliente;
        this.cantidadPersonas = cantidadPersonas;
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    int cantidadPersonasInterna() {
        return cantidadPersonas;
    }

    @Override
    public String toString() {
        return "Reserva #" + numero
                + "\nCliente: " + nombreCliente
                + "\nCantidad de personas: " + cantidadPersonas
                + "\nMonto: ₡" + monto;
    }
}