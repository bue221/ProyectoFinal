package biz;

import java.util.ArrayList;

public class NParqueadero {
    
    //atributos
    private ArrayList<NEstacionamiento> estacionamientos;

    public NParqueadero(ArrayList<NEstacionamiento> estacionamiento) {
        this.estacionamientos = estacionamiento;
    }

    public ArrayList<NEstacionamiento> getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(ArrayList<NEstacionamiento> estacionamientos) {
        this.estacionamientos = estacionamientos;
    }
}
