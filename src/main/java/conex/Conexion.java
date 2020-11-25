package conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
=======
import java.sql.SQLException;

>>>>>>> 9663083195a0ae1bc00de79413af9340c1d03ddf

public class Conexion {

    Connection con;

    public Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProyectoFinal", "root", "");
            System.out.print("Conexion exitosa a la base de datos mysql");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error:" + e);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public PreparedStatement prepareStatement(String selectfrom_Trabajador_where_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
