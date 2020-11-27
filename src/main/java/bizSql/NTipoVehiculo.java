
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
public class NTipoVehiculo {
    
    int Id;
    String TipoVehiculo;
    
    public NTipoVehiculo(){
        
    }

    public NTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }
    
    public boolean agregar() {
        try {
            String query = "insert into TipoVehiculo(TipoVehiculo) values ('" + TipoVehiculo +"')";
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
            String sql = "delete from TipoVehiculo where Id="+ Id;
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
            String sql = "update TipoVehiculo set TipoVehiculo='" + TipoVehiculo +"' where Id="+ Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NTipoVehiculo buscar(int Id) {
        try {
            String sql = "select * from TipoVehiculo where Id="+Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            NTipoVehiculo tipo = new NTipoVehiculo();
            
            while(res.next()){  
                tipo.setId(res.getInt("Id"));
                tipo.setTipoVehiculo(res.getString("TipoVehiculo"));                  
            }        
            return tipo;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
}
