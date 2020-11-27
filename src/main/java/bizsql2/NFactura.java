/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bizsql2;

import conex.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class NFactura {
    /*create table Factura
(
Id int auto_increment primary key,
IdVehiculo int,
IdSede int,
Placa varchar(50),
FechaIngreso datetime,
FechaSalida datetime default now(),
ValorPago double
);*/
    private int id;
    private int idVehiculo;
    private int idSede;
    private String placa;
    private Date fechaIngreso;
    private Date fechaSalida;
    private double valorPago;

    public NFactura(int idVehiculo, int idSede, String placa, Date fechaIngreso, double valorPago) {
        this.idVehiculo = idVehiculo;
        this.idSede = idSede;
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.valorPago = valorPago;
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

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    
    //metodos CRUD
    
    public boolean agregar() {
        try {
            String query = "insert into (IdVehiculo,IdSede,Placa, FechaIngreso,FechaSalida,ValorPago) Factura ('" + this.idVehiculo + "','" + this.idVehiculo + "','" + this.placa + "','" + this.fechaIngreso + "','" + this.fechaSalida + "','" + this.valorPago + "')";
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
    /*
    create table Factura
(
Id int auto_increment primary key,
IdVehiculo int,
IdSede int,
Placa varchar(50),
FechaIngreso datetime,
FechaSalida datetime default now(),
ValorPago double
);
    */
    public boolean modificar(int id) {
        try {
            String sql = "update Factura set IdVehiculo='" + this.idSede + "',IdSede='" + this.idSede + "',Placa='" + this.placa + "',FechaIngreso='" + this.fechaIngreso + "',FechaSalida='" + this.fechaSalida + "',ValorPago='" + this.valorPago + "' where Id="+ id;
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
