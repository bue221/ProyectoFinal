
package bizSql;
import conex.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NLogin {
    
    private int Id;
    private String Nombre;
    private String Apellido;
    private String Cargo = "Cliente";
    private String Correo;
    private String Contraseña;
    
    
    public NLogin(){
        
    }

    public NLogin( String Correo, String Contraseña) {
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    public NLogin(String Nombre, String Apellido,String Cargo, String Correo, String Contraseña) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    public boolean agregar() {
        try {
            String query = "insert into Usuario(Nombre,Apellido,Cargo,Correo,Contraseña) values ('" + Nombre + "','" + Apellido + "','"+Cargo+"','" + Correo + "','" + Contraseña + "')";
            Connection con = new Conexion().getConnection();
            PreparedStatement sql = con.prepareStatement(query);

            int res = sql.executeUpdate();

            return res == 1;

        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    public boolean login() {
        try {
            String sql = "select Id, Correo, Contraseña from Usuario where Id="+Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            NLogin login = new NLogin();
            if(res.next()){
                if(login.getContraseña().equals(res.getString(Contraseña))){
                    return false;
                }else{
                    login.setId(res.getInt(1));
                    login.setCorreo(res.getString(2));
                    return true;
                }
            }else{
                return false;
            } 
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
}
