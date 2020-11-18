package biz;

public class NPersona {
    //atributos
    private String documento;
    private String nombre;
    private int telefono;

    public NPersona(String documento, String nombre, int telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
       
}
