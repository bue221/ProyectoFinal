package bizSql;

import conex.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NTrabajador {

    private int Id;
    private String Nombre;
    private String Cargo;
    private String Turno;

    public NTrabajador() {

    }

    public NTrabajador( String Nombre, String Cargo, String Turno) {
        this.Nombre = Nombre;
        this.Cargo = Cargo;
        this.Turno = Turno;
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
            String query = "insert into Trabajador(Nombre,Cargo,Turno) values ('" + Nombre + "','" + Cargo + "','" + Turno + "')";
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
            String sql = "delete from Trabajador where Id=" + Id;
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
            String sql = "update Trabajador set Nombre='" + Nombre + "',Cargo='" + Cargo + "',Turno='" + Turno + "' where Id=" + Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }

    public NTrabajador buscar(int Id) {
        try {
            String sql = "select * from Trabajador Id=" + Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();

            NTrabajador tra = new NTrabajador();

            while (res.next()) {
                tra.setId(res.getInt("Id"));
                tra.setNombre(res.getString("Nombre"));
                tra.setCargo(res.getString("Cargo"));
                tra.setTurno(res.getString("Turno"));
            }

            return tra;

        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
}
