public class Cliente {
    private String nombre;
    private String condicion;

    public Cliente(String nombre, String condicion) {
        this.nombre = nombre;
        this.condicion = condicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCondicion() {
        return condicion;
    }

    public boolean esNacional() {
        return "nacional".equalsIgnoreCase(condicion);
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre
                + "\nCondición: " + condicion;
    }
}
