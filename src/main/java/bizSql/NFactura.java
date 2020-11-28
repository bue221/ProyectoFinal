/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bizSql;

import conex.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class NFactura {
 
    private int id;
    private int idVehiculo;
    private Date fechaSalida;    

    public NFactura(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    //metodos CRUD
    
    public boolean agregar() {
        try {
            String query = "insert into Factura (IdVehiculo)  values('" + this.idVehiculo + "')";
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
            String sql = "delete from Factura where Id=" + id;
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
            String sql = "update Factura set IdVehiculo='" + this.idVehiculo;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public int calcularId(int id) {
        try{
            String sql = "select * from Factura where IdVehiculo ="+id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            int iddata = 0;
            while(res.next()){
                iddata = res.getInt("Id");
            }
              if(iddata > 0){
                return iddata;
            }else{
                return 0;
            }
            
        }catch(Exception e){
            System.out.print(e);
            return 0;
        }
    }
    
}
