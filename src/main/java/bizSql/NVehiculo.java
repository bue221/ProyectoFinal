
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
public class NVehiculo {
  
    private int Id;
    private int IdUsuario;
    private int TipoVehiculo;
    private String Propietario;
    private String Placa;
    
    public NVehiculo() {
        
    }

    public NVehiculo(int IdUsuario, int TipoVehiculo, String Propietario, String Placa) {
        this.IdUsuario = IdUsuario;
        this.TipoVehiculo = TipoVehiculo;
        this.Propietario = Propietario;
        this.Placa = Placa;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(int TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String Propietario) {
        this.Propietario = Propietario;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }
    
    //Crud NVehiculo
    public boolean agregar() {
        try {
            String query = "insert into Vehiculo(IdUsuario,TipoVehiculo,Propietario,Placa) values ('" + IdUsuario + "','" + TipoVehiculo +
                    "','" + Propietario + "','" + Placa +"')";
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
            String sql = "delete from Vehiculo where Id=" + Id;
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
            String sql = "update Vehiculo set IdUsuario='" + IdUsuario + "',TipoVehiculo='" + TipoVehiculo + "',Propietario='" 
                    + Propietario + "', Placa= '" + Placa +"' where Id=" + Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NVehiculo buscar(int Id) {
        try {
            String sql = "select * from Vehiculo where Id="+Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            NVehiculo vehiculo = new NVehiculo();
            
            while(res.next()){  
                vehiculo.setId(res.getInt("Id"));
                vehiculo.setIdUsuario(res.getInt("IdUsuario"));
                vehiculo.setTipoVehiculo(res.getInt("TipoVehiculo"));
                vehiculo.setPropietario(res.getString("Propietario"));
                vehiculo.setPlaca(res.getString("Placa"));                      
            }        
            return vehiculo;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
}
