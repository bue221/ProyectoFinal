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
import java.sql.SQLException;

/**
 *
 * @author davida
 */
public class NVehiculoRetirado {
    
    private int id;
    private String nombrePropietario;
    private String placa;
    private String foto;
    private String tipo;
    private Date fechaIngreso;
    private Date fechaSalida;
    private Double Pago=1.200;
    
    public NVehiculoRetirado(){
        
    }

    public NVehiculoRetirado(String nombrePropietario, String placa, String foto, String tipo, Date fechaIngreso, Date fechaSalida, Double Pago) {
        this.nombrePropietario = nombrePropietario;
        this.placa = placa;
        this.foto = foto;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.Pago = Pago;
    }

    public NVehiculoRetirado(String nombrePropietario, String placa, String foto, String tipo) {
        this.nombrePropietario = nombrePropietario;
        this.placa = placa;
        this.foto = foto;
        this.tipo = tipo;
        
    }

    public NVehiculoRetirado(String nombrePropietario, String placa, String foto, String tipo, Date fechaEntrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Double getPago() {
        return Pago;
    }

    public void setPago(Double Pago) {
        this.Pago = Pago;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public boolean RetirarVehiculo(int id){
        try {
            String query = "insert into VehiculoRetirado(NombrePropietario,placa,foto,tipo) values ('" + nombrePropietario + "','" + placa + "','" + foto + "','" + tipo 
                            + "')";
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
            String sql = "delete from Vehiculos where Id=" + id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
}
