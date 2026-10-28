public class TourCultural extends Tour {
    private String idioma;

    public TourCultural(String nombre, double precioBase, int cupoMaximo,
                        Guia guia, String idioma) {
        super(nombre, precioBase, cupoMaximo, guia);
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    @Override
    public double calcularPrecioPorPersona() {
        return getPrecioBase() + calcularEntradasAtractivos();
    }

    @Override
    public String toString() {
        return "=== TOUR CULTURAL ===\n"
                + consultarEstadoComun()
                + "\nTipo: Cultural"
                + "\nIdioma: " + idioma;
    }
}
