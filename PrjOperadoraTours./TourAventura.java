public class TourAventura extends Tour {
    private static final double RECARGO_SEGURO = 0.15;
    private String nivelDificultad;

    public TourAventura(String nombre, double precioBase, int cupoMaximo,
                        Guia guia, String nivelDificultad) {
        super(nombre, precioBase, cupoMaximo, guia);
        this.nivelDificultad = normalizarNivel(nivelDificultad);
    }

    public TourAventura(String nombre, double precioBase, int cupoMaximo,
                        Guia guia) {
        this(nombre, precioBase, cupoMaximo, guia, "medio");
    }

    private String normalizarNivel(String nivel) {
        if (nivel == null) {
            return "medio";
        }
        if (nivel.equalsIgnoreCase("bajo")) {
            return "bajo";
        }
        if (nivel.equalsIgnoreCase("alto")) {
            return "alto";
        }
        return "medio";
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    @Override
    public double calcularPrecioPorPersona() {
        return getPrecioBase() * (1 + RECARGO_SEGURO);
    }

    @Override
    public String toString() {
        return "=== TOUR DE AVENTURA ===\n"
                + consultarEstadoComun()
                + "\nTipo: Aventura"
                + "\nNivel de dificultad: " + nivelDificultad;
    }
}
