package biz;

import java.io.Serializable;

public class NMoto extends NVehiculo implements Serializable{

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
