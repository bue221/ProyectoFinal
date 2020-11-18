package biz;

import java.util.ArrayList;

public class NSede {
    
    //atributos
    private String nombre;
    private int x;
    private int y;
    private double tarifaMoto;
    private double tarifaCarro;
    
    private NParqueadero parqueadero = new NParqueadero(new ArrayList<NEstacionamiento>(30));

    public NSede(String nombre, int x, int y, double tarifaMoto, double tarifaCarro) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.tarifaMoto = tarifaMoto;
        this.tarifaCarro = tarifaCarro;
    }

    public NSede() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getTarifaMoto() {
        return tarifaMoto;
    }

    public void setTarifaMoto(double tarifaMoto) {
        this.tarifaMoto = tarifaMoto;
    }

    public double getTarifaCarro() {
        return tarifaCarro;
    }

    public void setTarifaCarro(double tarifaCarro) {
        this.tarifaCarro = tarifaCarro;
    }
        
}
