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
//import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class NVehiculo {

    private String nombrePropietario;
    private String placa;
    private String foto;
    private String tipo;
    private Date fechaEntrada;
    private int id;

    public NVehiculo() {
    }

    public NVehiculo(String nombrePropietario, String placa, String foto, String tipo) {
        this.nombrePropietario = nombrePropietario;
        this.placa = placa;
        this.foto = foto;
        this.tipo = tipo;
    }

    public NVehiculo(String nombrePropietario, String foto, String tipo, Date fechaEntrada, int id) {
        this.nombrePropietario = nombrePropietario;
        this.foto = foto;
        this.tipo = tipo;
        this.fechaEntrada = fechaEntrada;
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

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //metodos del crud
    public boolean agregar() {
        try {
            String query = "insert into Vehiculos(NombrePropietario,placa,foto,tipo) values ('" + nombrePropietario + "','" + placa + "','" + foto + "','" + tipo + "')";
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

    public boolean modificar(int id) {
        try {
            String sql = "update Vehiculos set NombrePropietario='" + nombrePropietario + "',placa='" + placa + "',foto='" + foto + "', tipo= '" + tipo +"' where Id=" + id;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            int res = st.executeUpdate();

            return res == 1;
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
    }
    
    public NVehiculo buscar(String placa) {
        try {

            String sql = "select * from Vehiculos where placa="+placa;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            NVehiculo vehiculo = new NVehiculo();
            
            while(res.next()){                
                vehiculo.setNombrePropietario(res.getString("NombrePropietario"));
                vehiculo.setFoto(res.getString("foto"));
                vehiculo.setId(res.getInt("id"));
                vehiculo.setFechaEntrada(res.getDate("fecha"));
                vehiculo.setTipo(res.getString("tipo"));
            }
            
            return vehiculo;
            
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
    
    /* no se como implementarlo
    public ArrayList<NVehiculo> listar(){
                try {
            String sql = "select * from Vehiculos placa="+placa;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            ArrayList<NVehiculo> lista = new ArrayList();
            
            
            while(res.next()){              
                NVehiculo vehiculo = new NVehiculo();
                vehiculo.setNombrePropietario(res.getString("NombrePropietario"));
                vehiculo.setFoto(res.getString("foto"));
                vehiculo.setId(res.getInt("id"));
                vehiculo.setFechaEntrada(res.getDate("fecha"));
                vehiculo.setTipo(res.getString("tipo"));
                
                lista.add(vehiculo);
            }
            
            return lista;
            
        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return null;
        }
    }
*/

}
