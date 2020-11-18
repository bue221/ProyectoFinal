package biz;

public class NTrabajador extends NPersona {
    //atributos
    private String cargo;
    private String horaTurno;

    public NTrabajador(String documento, String nombre, int telefono) {
        super(documento, nombre, telefono);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(String horaTurno) {
        this.horaTurno = horaTurno;
    }
}
