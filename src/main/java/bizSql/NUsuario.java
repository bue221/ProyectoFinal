
package bizSql;

import conex.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author davida
 */
public class NUsuario {
    
    private int Id;
    private int IdCargo;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Clave;
    
    public NUsuario() {
        
    }

    public NUsuario(int IdCargo, String Nombre, String Apellido, String Correo, String Clave) {
        this.IdCargo = IdCargo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Clave = Clave;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
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

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    //Crud Para la tabla Usuario
    public boolean agregar() {
        
        try {
            String query = "insert into Usuario(IdCargo,Nombre,Apellido,Correo,Clave) values ('" + IdCargo + "','" + Nombre +
                    "','" + Apellido + "','" + Correo + "','"+ Clave +"')";
            Connection con = new Conexion().getConnection();
            PreparedStatement sql = con.prepareStatement(query);

            int res = sql.executeUpdate();

            return res == 1;

        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public boolean eliminar(int Id) {
        try {
            String sql = "delete from Usuario where Id=" + Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public boolean modificar(int Id) {
        try {
            String sql = "update Usuario set IdCargo='" + IdCargo + "',Nombre='" + Nombre + "',Apellido='" 
                    + Apellido + "', Correo= '" + Correo +"', Clave= '" + Clave +"' where Id=" + Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NUsuario buscar(int Id) {
        try {

            String sql = "select * from Usuario where Id="+Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            NUsuario usuario = new NUsuario();
            
            while(res.next()){  
                usuario.setId(res.getInt("Id"));
                usuario.setIdCargo(res.getInt("IdCargo"));
                usuario.setNombre(res.getString("Nombre"));
                usuario.setApellido(res.getString("Apellido"));
                usuario.setCorreo(res.getString("Correo"));
                usuario.setClave(res.getString("Clave"));                        
            }
            
            return usuario;
            
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
    
}
