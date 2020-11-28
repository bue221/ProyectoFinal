/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bizsql2;

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
    private String nombreSede;
    private int idEstacionamiento;
    private double tarifaC;
    private double tarifaM;
    private String ubicacion;

    public NSede(String nombreSede, int idEtacionamiento, double tarifaC, double tarifaM, String ubicacion) {
        this.nombreSede = nombreSede;
        this.idEstacionamiento = idEtacionamiento;
        this.tarifaC = tarifaC;
        this.tarifaM = tarifaM;
        this.ubicacion = ubicacion;
    }

    public NSede() {
    }

    public int getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(int idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    //metodos CRUD
        
    public boolean agregar() {
        try {
            String query = "insert into Sede(NombreSede,IdEstacionamiento,TarifaM, TarifaC,Ubicacion) values ('" + this.nombreSede + "','" + this.idEstacionamiento + "','" + this.tarifaM + "','" + this.tarifaC + "','" + ubicacion + "')";
            Connection con = new Conexion().getConnection();
            PreparedStatement sql = con.prepareStatement(query);
            //ejecuta 
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
            String sql = "update Sede set NombreSede='" + this.nombreSede + "',IdEstacionamiento='" + this.idEstacionamiento + "',TarifaM='" + tarifaM + "',TarifaC='" + tarifaC + "',Ubicacion='" + ubicacion + "' where Id="+ id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
            
    public bizSql.NSede buscar(int id) {
        try {
            String sql = "select * from Sede where Id = "+id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            bizSql.NSede sede = new bizSql.NSede();
            
            while(res.next()){                
                sede.setId(res.getInt("Id"));
                sede.setNombre(res.getString("NombreSede"));
                sede.setEspacio(res.getInt("IdEstacionamiento"));
                sede.setTarifaC(res.getDouble("TarifaM"));
                sede.setTarifaM(res.getDouble("TarifaC"));
                sede.setUbicacion(res.getString("Ubicacion"));
            }
            
            return sede;
            
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }

}
