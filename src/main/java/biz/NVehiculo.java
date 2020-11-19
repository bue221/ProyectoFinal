package biz;

public abstract class NVehiculo {
    //atributos
    private String placas;
    private String nombreDelPropietario;
    private NCliente cliente;
    private int tipoDeVehiculo;//varia entre 1(carro) y 2(moto)

    public NVehiculo(String placas, String nombreDelPropietario, int tipoDeVehiculo) {
        this.placas = placas;
        this.nombreDelPropietario = nombreDelPropietario;
        this.cliente = new NCliente("1001202021",nombreDelPropietario,123);
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public NVehiculo() {
    }

    abstract double precioTarifa();

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getNombreDelPropietario() {
        return nombreDelPropietario;
    }

    public void setNombreDelPropietario(String nombreDelPropietario) {
        this.nombreDelPropietario = nombreDelPropietario;
    }

    public int getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public void setTipoDeVehiculo(int tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public NCliente getCliente() {
        return cliente;
    }

    public void setCliente(NCliente cliente) {
        this.cliente = cliente;
    }

}
