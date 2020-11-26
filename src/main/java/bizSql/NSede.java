/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bizSql;

import conex.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author USER
 */
public class NSede {
    private int id;
    private String nombre;
    private int espacios;
    private double tarifaC;
    private double tarifaM;
    private String ubicacion;

    public NSede(String nombre, int espacios, double tarifaC, double tarifaM, String ubicacion) {
        this.nombre = nombre;
        this.espacios = espacios;
        this.tarifaC = tarifaC;
        this.tarifaM = tarifaM;
        this.ubicacion = ubicacion;
    }

    public NSede() {
    }

    

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTarifaC() {
        return tarifaC;
    }

    public void setTarifaC(double tarifaC) {
        this.tarifaC = tarifaC;
    }

    public double getTarifaM() {
        return tarifaM;
    }

    public void setTarifaM(double tarifaM) {
        this.tarifaM = tarifaM;
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEspacio() {
        return espacios;
    }

    public void setEspacio(int espacios) {
        this.espacios = espacios;
    }    
    
    //metodos del crud
    public boolean agregar() {
        try {
            
            String query = "insert into Sede(Nombre,Espacios,TarifaC, TarifaM,Ubicacion) values ('" + nombre + "','" + espacios + "','" + tarifaC + "','" + tarifaM + "','" + ubicacion + "')";
            Connection con = new Conexion().getConnection();
            PreparedStatement sql = con.prepareStatement(query);

            int res = sql.executeUpdate();

            return res == 1;

        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "delete from Sede where Id=" + id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }

    public boolean modificar(int id) {
        try {
            String sql = "update Sede set Nombre='" + nombre + "',Espacios='" + espacios + "',TarifaC='" + tarifaC + "',TarifaM='" + tarifaM + "',Ubicacion='" + ubicacion + "' where Id="+ id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NSede buscar(int idn) {
        try {
            String sql = "select * from Sede where Id = "+idn;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            NSede sede = new NSede();
            
            while(res.next()){                
                sede.setId(res.getInt("Id"));
                sede.setNombre(res.getString("Nombre"));
                sede.setEspacio(res.getInt("Espacios"));
                sede.setTarifaC(res.getDouble("TarifaC"));
                sede.setTarifaM(res.getDouble("TarifaM"));
                sede.setUbicacion(res.getString("Ubicacion"));
            }
            
            return sede;
            
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
    
}
