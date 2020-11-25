package biz;

import conex.Conexion;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class NTrabajador{
    //atributos
    private int Id;
    private String Nombre;
    private String Cargo;
    private String Turno;
    
    Conexion con=new Conexion();

    public NTrabajador(int Id, String Nombre, String Cargo, String Turno) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Cargo = Cargo;
        this.Turno = Turno;
    }

    

    NTrabajador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public boolean agregar(){
        try{
            PreparedStatement sql = con.prepareStatement("insert into Trabajador"
                    +"(Id,Nombre,Cargo,Turno) "
                    + "values "
                    +"(?, ?, ?, ?);");
            sql.setInt(1, this.Id);
            sql.setString(2, this.Nombre);
            sql.setString(3, this.Cargo);
            sql.setString(4, this.Turno);
            
            int res = sql.executeUpdate();
            if(res == 1){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean modificar(){
        try{
            PreparedStatement sql = con.prepareStatement("update Trabajador set "
                    + "Nombre=?, Cargo=?, Turno=? where Id=?");
            sql.setString(1, this.Nombre);
            sql.setString(2, this.Cargo);
            sql.setString(3, this.Turno);
            sql.setInt(4, this.Id);
          
            int res = sql.executeUpdate();
            if(res == 1){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean eliminar(int Id){
        try{
            PreparedStatement sql = con.prepareStatement("delete from Trabajador where Id=?;");
            sql.setInt(1, Id);
            int res= sql.executeUpdate();
            if(res == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public NTrabajador buscar(int Id){
        try{
            PreparedStatement sql = con.prepareStatement("select*from Trabajador where Id=?;");
            sql.setInt(1, Id);
            ResultSet res= sql.executeQuery();
            NTrabajador tra = new NTrabajador();
            
            while(res.next()){
                
                tra.setId(res.getInt("Id"));
                tra.setNombre(res.getString("Nombre"));
                tra.setCargo(res.getString("Cargo"));
                tra.setTurno(res.getString("Turno"));
            }
            return tra;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<NTrabajador> listar(){
        try{
            PreparedStatement sql = con.prepareStatement("select*from Trabajador;");
            ResultSet res= sql.executeQuery();
            
            ArrayList<NTrabajador> lista = new ArrayList();
            
            while(res.next()){
                NTrabajador tra = new NTrabajador();
                tra.setId(res.getInt("Id"));
                tra.setNombre(res.getString("Nombre"));
                tra.setCargo(res.getString("Cargo"));
                tra.setTurno(res.getString("Turno"));
                lista.add(tra);
            }
            return lista;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
