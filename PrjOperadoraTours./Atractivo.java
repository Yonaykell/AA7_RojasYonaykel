public class Atractivo {
    private String codigo;
    private String nombre;
    private double montoEntrada;

    public Atractivo(String codigo, String nombre, double montoEntrada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.montoEntrada = montoEntrada;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMontoEntrada() {
        return montoEntrada;
    }

    @Override
    public String toString() {
        return "Atractivo: " + nombre
                + "\nCódigo: " + codigo
                + "\nEntrada: ₡" + montoEntrada;
    }
}
