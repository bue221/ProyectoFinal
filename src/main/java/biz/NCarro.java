package biz;

import java.io.Serializable;

public class NCarro extends NVehiculo implements Serializable {

    public NCarro() {
    }

    public NCarro(String placas, String nombreDelPropietario, NCliente cliente, String foto, int tipoDeVehiculo) {
        super(placas, nombreDelPropietario, cliente, foto, tipoDeVehiculo);
    }
     
    @Override
    public String toString() {
        return ""+this.getPlacas()+""+this.getNombreDelPropietario()+"";
    }

    @Override
    double precioTarifa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
