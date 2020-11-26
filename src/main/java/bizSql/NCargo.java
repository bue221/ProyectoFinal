
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
public class NCargo {
    
    private int Id;
    private String Cargo;
    private String Turno;
    
    public NCargo(){
        
    }

    public NCargo(String Cargo, String Turno) {
        this.Cargo = Cargo;
        this.Turno = Turno;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }
    
    public boolean agregar() {
        try {
            String query = "insert into Cargo(Cargo,Turno) values ('" + Cargo + "','" + Turno +"')";
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
            String sql = "delete from Cargo where Id="+Id;
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
            String sql = "update Cargo set Cargo='" + Cargo + "',Turno='" + Turno +"' where Id="+ Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NCargo buscar(int Id) {
        try {
            String sql = "select * from Cargo where Id="+Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            NCargo cargo = new NCargo();
            
            while(res.next()){  
                cargo.setId(res.getInt("Id"));
                cargo.setCargo(res.getString("Cargo"));
                cargo.setTurno(res.getString("Turno"));                    
            }        
            return cargo;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
}
