package biz;

public class NEstacionamiento {
    //atributos
    private int espacioTotal;
    private int espaciosOcupados;

    public NEstacionamiento(int espacioTotal, int espaciosOcupados) {
        this.espacioTotal = espacioTotal;
        this.espaciosOcupados = espaciosOcupados;
    }

    public NEstacionamiento() {
    }

    public int getEspacioTotal() {
        return espacioTotal;
    }

    public void setEspacioTotal(int espacioTotal) {
        this.espacioTotal = espacioTotal;
    }

    public int getEspaciosOcupados() {
        return espaciosOcupados;
    }

    public void setEspaciosOcupados(int espaciosOcupados) {
        this.espaciosOcupados = espaciosOcupados;
    }
    
    public int calcularDisponibilidad() {
        return this.espacioTotal - this.espaciosOcupados;
    }
}
