package biz;

import java.io.Serializable;

public class NCarro extends NVehiculo implements Serializable {

    public NCarro() {
    }

    public NCarro(String placas, String nombreDelPropietario, int tipoDeVehiculo) {
        super(placas, nombreDelPropietario, 1);
    }

    @Override
    double precioTarifa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
