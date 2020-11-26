
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
    private String Cargo;
    private String Turno;
    private String Correo;
    private String Contraseña;
    
    
    public NLogin(){
        
    }

    public NLogin( String Correo, String Contraseña) {
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    public NLogin(String Nombre, String Apellido, String Cargo, String Turno, String Correo, String Contraseña) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cargo = Cargo;
        this.Turno = Turno;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
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
            String query = "insert into Usuario(Nombre,Apellidos,Cargo,Turno,Correo,Contraseña) values ('" + Nombre + "','" + Apellido + "','"+Cargo+"','"+Turno+"','" + Correo + "','" + Contraseña + "')";
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
            String sql = "update Usuario set Nombre='"+Nombre+"', Apellidos='"+Apellido+"',Cargo='"+Cargo+"',Turno='"+Turno+"',Correo='"+Correo+"',Contraseña='"+Contraseña+"' where Id="+Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    public NLogin buscar(int Id) {
        try {
            String sql = "select * from Usuario Id=" + Id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();

            NLogin usuario = new NLogin();

            while (res.next()) {
                usuario.setId(res.getInt("Id"));
                usuario.setNombre(res.getString("Nombre"));
                usuario.setApellido(res.getString("Apellidos"));
                usuario.setCargo(res.getString("Cargo"));
                usuario.setTurno(res.getString("Turno"));
                usuario.setCorreo(res.getString("Correo"));
                usuario.setContraseña(res.getString("Contraseña"));
            }

            return usuario;

        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
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
