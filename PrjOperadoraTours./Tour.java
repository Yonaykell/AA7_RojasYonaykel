import java.util.ArrayList;

public abstract class Tour {
    private static final String PREFIJO_CODIGO = "TOUR-";
    private static int cantidadTours = 0;
    private static final double DESCUENTO_NACIONAL = 0.20;

    private String codigo;
    private String nombre;
    private double precioBase;
    private int cupoMaximo;
    private Guia guia;
    private ArrayList<Atractivo> atractivos;
    private ArrayList<Reserva> reservas;
    private int siguienteNumeroReserva;

    public Tour(String nombre, double precioBase, int cupoMaximo, Guia guia) {
        cantidadTours++;
        this.codigo = PREFIJO_CODIGO + cantidadTours;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cupoMaximo = cupoMaximo;
        this.guia = guia;
        this.atractivos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.siguienteNumeroReserva = 1;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public static int getCantidadTours() {
        return cantidadTours;
    }

    public void cambiarGuia(Guia guia) {
        if (guia != null) {
            this.guia = guia;
        }
    }

    public String consultarNombreGuia() {
        return guia.getNombreCompleto();
    }

    public void agregarAtractivo(Atractivo atractivo) {
        if (atractivo == null) {
            return;
        }

        // No se permite repetir el mismo atractivo en este recorrido.
        for (Atractivo existente : atractivos) {
            if (existente == atractivo) {
                return;
            }
        }
        atractivos.add(atractivo);
    }

    public String consultarNombresAtractivos() {
        String resultado = "";
        for (int i = 0; i < atractivos.size(); i++) {
            if (i > 0) {
                resultado += ", ";
            }
            resultado += atractivos.get(i).getNombre();
        }
        return resultado;
    }

    protected double calcularEntradasAtractivos() {
        double total = 0;
        for (Atractivo atractivo : atractivos) {
            total += atractivo.getMontoEntrada();
        }
        return total;
    }

    public abstract double calcularPrecioPorPersona();

    public int consultarCuposDisponibles() {
        int ocupados = 0;
        for (Reserva reserva : reservas) {
            // La cantidad de personas se contabiliza en las reservas.
            ocupados += obtenerCantidadPersonas(reserva);
        }
        return cupoMaximo - ocupados;
    }

    /*
     * La reserva conserva la cantidad de personas. Este método interno
     * evita exponer los objetos Reserva fuera del tour.
     */
    private int obtenerCantidadPersonas(Reserva reserva) {
        return reserva.cantidadPersonasInterna();
    }

    public void registrarReserva(Cliente cliente) {
        registrarReserva(cliente, 1);
    }

    public void registrarReserva(Cliente cliente, int cantidadPersonas) {
        if (cliente == null || cantidadPersonas <= 0
                || cantidadPersonas > consultarCuposDisponibles()) {
            return;
        }

        double monto = calcularPrecioPorPersona() * cantidadPersonas;
        if (cliente.esNacional()) {
            monto *= (1 - DESCUENTO_NACIONAL);
        }

        reservas.add(new Reserva(siguienteNumeroReserva,
                cliente.getNombre(), cantidadPersonas, monto));
        siguienteNumeroReserva++;
    }

    public double calcularIngresoTotal() {
        double total = 0;
        for (Reserva reserva : reservas) {
            total += reserva.getMonto();
        }
        return total;
    }

    protected String consultarEstadoReservas() {
        if (reservas.isEmpty()) {
            return "Sin reservas";
        }

        String resultado = "";
        for (int i = 0; i < reservas.size(); i++) {
            if (i > 0) {
                resultado += "\n";
            }
            resultado += reservas.get(i).toString();
        }
        return resultado;
    }

    protected String consultarEstadoComun() {
        return "Código: " + codigo
                + "\nNombre: " + nombre
                + "\nGuía: " + consultarNombreGuia()
                + "\nPrecio base: ₡" + precioBase
                + "\nPrecio por persona: ₡" + calcularPrecioPorPersona()
                + "\nCupo máximo: " + cupoMaximo
                + "\nCupos disponibles: " + consultarCuposDisponibles()
                + "\nAtractivos: " + consultarNombresAtractivos()
                + "\nReservas:\n" + consultarEstadoReservas()
                + "\nIngreso total: ₡" + calcularIngresoTotal();
    }
}
