

package bizSql;
import conex.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import view.VPrincipal;

/**
 *
 * @author davida
 */
public class NPruebaVista {
    
    private int Id;
    private int IdCargo;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Clave;
    private int IdEncontrado;
    
    public NPruebaVista() {
        
    }

    public NPruebaVista(int IdCargo, String Nombre, String Apellido, String Correo, String Clave) {
        this.IdCargo = IdCargo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Clave = Clave;
    }

    public int getIdEncontrado() {
        return IdEncontrado;
    }

    public void setIdEncontrado(int IdEncontrado) {
        this.IdEncontrado = IdEncontrado;
    }

    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    public int comprobar(String Cargo,String Turno){
        int resultado=0;
        String sql = "Select*from Cargo where Cargo='"+Cargo+"' and Turno='"+Turno+"'";
        
        try{
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();

                if(res.next()){
                resultado=1;
                if(resultado == 1){  
                    NPruebaVista recoger = new NPruebaVista();
                    if(recoger.RecogerId(Cargo, Turno) < 0 ){  
                        JOptionPane.showMessageDialog(null, "Correcto");
                        return recoger.RecogerId(Cargo, Turno);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error de acceso. Usuario no registrado");
                return 0;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+ e.getMessage());
            return 0;
        }    
        return 0;
    }
    
    public int RecogerId(String Cargo,String Turno){
        int resultado=0;
        int IdCargo;
        String sql = "Select Id from Cargo where Cargo='"+Cargo+"' and Turno='"+Turno+"'";
        try{
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            if(res.next()){
                JOptionPane.showMessageDialog(null, "Hasta aca correto");
                IdCargo = res.getInt("Id");
                IdEncontrado = IdCargo;
                
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Incorrecto");
            JOptionPane.showMessageDialog(null, "Error"+ e.getMessage());
            return 0;
        }
        return 0;
    }
    /*try{
            String sql = "Select Cargo,Turno from Cargo where Cargo='"+Cargo+"' and Turno='"+Turno;
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            
            int probar = Integer.parseInt(res.toString());
            
            if(probar==1){
                System.out.println("El cargo si existe");
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            return false;
        }*/
    
    
    /*public boolean agregarUsuario() throws SQLException {
        String sql = "Select Cargo,Turno from Cargo";
        Connection con = new Conexion().getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet res = st.executeQuery();
        
        
            try {
            String query = "insert into Usuario(IdCargo,Nombre,Apellido,Correo,Clave) values ('" + IdCargo + "','" + Nombre +
                    "','" + Apellido + "','" + Correo + "','"+ Clave +"')";
            Connection con = new Conexion().getConnection();
            PreparedStatement sql = con.prepareStatement(query);

            int res = sql.executeUpdate();

            return res == 1;

        } catch (SQLException e) {
            System.out.print("Error: " + e);
            return false;
        }
        
    }
    */
    
    public void consultar_Cargo(JComboBox cboxCargo){ 
        try{
            String query = "select Cargo from Cargo";
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet res = st.executeQuery();
            
            //Llenamos el ComboBox           
            cboxCargo.addItem("Seleccione un Cargo");
            while(res.next()){
                cboxCargo.addItem(res.getString("Cargo"));
            }                     
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    public void consultar_Turno(JComboBox cboxTurno){ 
        try{
            String query = "select Turno from Cargo";
            Connection con = new Conexion().getConnection();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet res = st.executeQuery();
            
            //Llenamos el ComboBox           
            cboxTurno.addItem("Seleccione un Turno");
            while(res.next()){
                cboxTurno.addItem(res.getString("turno"));
            }                     
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
}
