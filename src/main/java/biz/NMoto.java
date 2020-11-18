package biz;

public class NMoto extends NVehiculo {

    public NMoto() {
    }

    public NMoto(String placas, String nombreDelPropietario) {
        super(placas, nombreDelPropietario, 2);
    }
    
    @Override
    double precioTarifa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
