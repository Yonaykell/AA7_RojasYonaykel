
public class Moto extends Vehiculo {

    private static final double MONTO_PEAJE = 75;

    public Moto(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, pMarca, pModelo, pAnnio);
    }

    public String getTipo() {
        return "moto";
    }
    
    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
