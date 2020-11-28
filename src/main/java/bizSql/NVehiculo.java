
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
    private int IdSede;
    private String TipoVehiculo;
    private String Propietario;
    private String Placa;
    private String Foto;
    
    public NVehiculo() {
        
    }

    public NVehiculo(int IdSede, String TipoVehiculo, String Propietario, String Placa, String Foto) {
        this.IdSede = IdSede;
        this.TipoVehiculo = TipoVehiculo;
        this.Propietario = Propietario;
        this.Placa = Placa;
        this.Foto = Foto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdSede() {
        return IdSede;
    }

    public void setIdSede(int IdSede) {
        this.IdSede = IdSede;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String TipoVehiculo) {
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

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    
    
    //Crud NVehiculo
    public boolean agregar() {
        try {
            String query = "insert into Vehiculo(IdSede,TipoVehiculo,Propietario,Placa,foto) values ('" + IdSede + "','" + TipoVehiculo +
                    "','" + Propietario + "','" + Placa +"','" + Foto +"')";
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
            String sql = "update Vehiculo set IdSede='" + IdSede + "',TipoVehiculo='" + TipoVehiculo + "',Propietario='" 
                    + Propietario + "', Placa= '" + Placa +"', Foto= '" + Foto +"' where Id=" + Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public int buscar(String placa) {
        try {
            String sql = "select * from Vehiculo where Placa='"+placa+"'";
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            //NVehiculo vehiculo = new NVehiculo();
            int Id = 0;
            
            while(res.next()){
                /*
                vehiculo.setId(res.getInt("Id"));
                vehiculo.setIdUsuario(res.getInt("IdUsuario"));
                vehiculo.setTipoVehiculo(res.getInt("TipoVehiculo"));
                vehiculo.setPropietario(res.getString("Propietario"));
                vehiculo.setPlaca(res.getString("Placa"));*/
                Id = res.getInt("Id");
            }
            
            if(Id > 0){
                return Id;
            }else{
                return 0;
            }
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return 0;
        }
    }
    
     public NVehiculo buscarV(int id) {
        try {
            String sql = "select * from Vehiculo where Id="+id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            NVehiculo vehiculo = new NVehiculo();
            //int Id = 0;
            
            while(res.next()){
                
                vehiculo.setId(res.getInt("Id"));
                vehiculo.setIdSede(res.getInt("IdSede"));
                vehiculo.setTipoVehiculo(res.getString("TipoVehiculo"));
                vehiculo.setPropietario(res.getString("Propietario"));
                vehiculo.setPlaca(res.getString("Placa"));
                vehiculo.setFoto(res.getString("Foto"));
                //Id = res.getInt("Id");
            }
            
            return vehiculo;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
}
