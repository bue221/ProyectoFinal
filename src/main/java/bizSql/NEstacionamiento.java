
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
public class NEstacionamiento {
    
    private int Id;
    private int DisponibilidadMoto;
    private int DisponibilidadCarro;
    
    public NEstacionamiento(){
        
    }

    public NEstacionamiento(int DisponibilidadMoto, int DisponibilidadCarro) {
        this.DisponibilidadMoto = DisponibilidadMoto;
        this.DisponibilidadCarro = DisponibilidadCarro;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getDisponibilidadMoto() {
        return DisponibilidadMoto;
    }

    public void setDisponibilidadMoto(int DisponibilidadMoto) {
        this.DisponibilidadMoto = DisponibilidadMoto;
    }

    public int getDisponibilidadCarro() {
        return DisponibilidadCarro;
    }

    public void setDisponibilidadCarro(int DisponibilidadCarro) {
        this.DisponibilidadCarro = DisponibilidadCarro;
    }
    
    public boolean agregar() {
        try {
            String query = "insert into Estacionamiento(DisponibilidadMoto,DisponibilidadCarro) values ('" + DisponibilidadMoto + "','" + DisponibilidadCarro +"')";
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
            String sql = "delete from Estacionamiento where Id="+ Id;
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
            String sql = "update Estacionamiento set DisponibilidadMoto='" + DisponibilidadMoto + "',DisponibilidadCarro='" + DisponibilidadCarro +"' where Id="+ Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NEstacionamiento buscar(int Id) {
        try {
            String sql = "select * from Estacionamiento where Id="+Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            NEstacionamiento estacionamiento = new NEstacionamiento();
            
            while(res.next()){  
                estacionamiento.setId(res.getInt("Id"));
                estacionamiento.setDisponibilidadMoto(res.getInt("DisponibilidadMoto"));
                estacionamiento.setDisponibilidadMoto(res.getInt("DisponibilidadCarro"));                    
            }        
            return estacionamiento;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
}
