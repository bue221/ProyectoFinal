package biz;

import java.io.Serializable;

public class NMoto extends NVehiculo implements Serializable{

    public NMoto() {
    }

    public NMoto(String placas, String nombreDelPropietario, NCliente cliente, String foto, int tipoDeVehiculo) {
        super(placas, nombreDelPropietario, cliente, foto, tipoDeVehiculo);
    }
    
    @Override
    double precioTarifa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
