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
    private String nombre;
    private int espacio;
    private double tarifa;

    public NSede() {
    }

    public NSede(String nombre, int espacio, double tarifa) {
        this.nombre = nombre;
        this.espacio = espacio;
        this.tarifa = tarifa;
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

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    
    //metodos del crud
    public boolean agregar() {
        try {
            String query = "insert into Sede(Nombre,Espacio,Tarifa) values ('" + nombre + "','" + espacio + "','" + tarifa + "')";
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
            String sql = "update Vehiculos set Nombre='" + nombre + "',Espacio='" + espacio + "',Tarifa='" + tarifa + "' where Id=" + id;
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
            String sql = "select * from Sede Nombre="+nombre;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            NSede sede = new NSede();
            
            while(res.next()){                
                sede.setEspacio(res.getInt("Espacio"));
                sede.setNombre(res.getString("Nombre"));
                sede.setTarifa(res.getDouble("Tarifa"));
            }
            
            return sede;
            
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
    
}
