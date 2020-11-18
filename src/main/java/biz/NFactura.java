package biz;

import java.util.Date;

public class NFactura implements NPago {
    //atributos
    private int id;
    private Date diaDeIngreso = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDiaDeIngreso() {
        return diaDeIngreso;
    }

    public void setDiaDeIngreso(Date diaDeIngreso) {
        this.diaDeIngreso = diaDeIngreso;
    }
    
    @Override
    public String toString() {
        return null;
    }

    @Override
    public double calcularTarifa() {
       double tarifa = 100;
       return tarifa;
    }

    @Override
    public Date calcularEntrada() {
        return diaDeIngreso;
    }

}
