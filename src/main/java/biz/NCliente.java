package biz;

public class NCliente extends NPersona {
    //atributos
    private String tipoDeVehiculo;

    public NCliente(String documento, String nombre, int telefono) {
        super(documento, nombre, telefono);
    }

    public String getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public void setTipoDeVehiculo(String tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }
    
}
