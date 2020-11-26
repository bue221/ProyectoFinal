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
    private String nombre, ubicacion;
    private int espacio, id;
    private double tarifaC, tarifaM;

    public NSede() {
    }

    public NSede(String nombre, String ubicacion, int espacio, double tarifaC, double tarifaM) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.espacio = espacio;
        this.tarifaC = tarifaC;
        this.tarifaM = tarifaM;
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
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }    
    
    //metodos del crud
    public boolean agregar() {
        try {
            String query = "insert into Sede(Nombre,Espacios, Ubicacion ,TarifaC, TarifaM) values ('" + nombre + "','" + espacio + "','" + ubicacion + "','" + tarifaC + "','" + tarifaM + "')";
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
            String sql = "update Sede set Nombre='" + nombre + "',Espacio='" + espacio + "',TarifaC='" + tarifaC + "',Ubicacion='" + ubicacion + "',TarifaM='" + tarifaM  + "' where Id=" + id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NSede buscar(String nombre) {
        try {
            String sql = "select * from Sede Nombre = "+nombre;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            NSede sede = new NSede();
            
            while(res.next()){                
                sede.setEspacio(res.getInt("Espacio"));
                sede.setNombre(res.getString("Nombre"));
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
