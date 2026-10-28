public class Guia {
    private String identificacion;
    private String nombreCompleto;

    public Guia(String identificacion, String nombreCompleto) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    @Override
    public String toString() {
        return "Guía: " + nombreCompleto
                + "\nIdentificación: " + identificacion;
    }
}
