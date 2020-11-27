
package view;

import bizSql.NCargo;
import bizSql.NVehiculo;
import conex.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davida
 */
public class VVehiculo extends javax.swing.JPanel {

    //MySql
    Conexion con=new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    
    int Id;
    NVehiculo vehiculo = new NVehiculo();

    public VVehiculo() {
        initComponents();
    }

    private void limpiartabla(){
       for(int i=1;i<=TablaVehiculo.getRowCount();i++){
            i=i-i;
           modelo.removeRow(i); 
       }
    }
    void listar(){
       String sql="Select * from Vehiculo";
       try{
           cn=con.getConnection();
           st=cn.createStatement();
           rs=st.executeQuery(sql);
           Object[]vehiculo = new Object[5];
           modelo = (DefaultTableModel)TablaVehiculo.getModel();
           while (rs.next()){
               vehiculo[0]=rs.getString("Id");
               vehiculo[1]=rs.getString("IdUsuario");
               vehiculo[2]=rs.getString("TipoVehiculo");
               vehiculo[3]=rs.getString("Propietario");
               vehiculo[4]=rs.getString("Placa");
               modelo.addRow(vehiculo);
           }
           TablaVehiculo.setModel(modelo);
       }catch (Exception e){
           
       }
   }
    void nuevo(){
        txtId.setText("");
        txtIdUsuario.setText("");
        txtTipoVehiculo.setText("");
        txtPropietario.setText("");
        txtPlaca.setText("");
    }
    
    void Agregar(){
       
       int IdUsuario=Integer.parseInt(txtIdUsuario.getText().toString());
       int TipoVehiculo=Integer.parseInt(txtTipoVehiculo.getText().toString());
       String Propietario=txtPropietario.getText();
       String Placa=txtPlaca.getText();  
       
       if(Propietario.equals("") || Placa.equals("")){
           JOptionPane.showMessageDialog(null, "Debes ingresar informacion en todos los campos");
           limpiartabla();
       }else{
          NVehiculo vehiculo = new NVehiculo(IdUsuario,TipoVehiculo,Propietario,Placa);
           
           if(vehiculo.agregar()){
               JOptionPane.showMessageDialog(null, "Se agrego un vehiculo");
               limpiartabla();
           }else{
               System.err.println("Error");
           }
       }
       
   }
    void modificar(){
        
       //variables
       int IdUsuario=Integer.parseInt(txtIdUsuario.getText().toString());
       int TipoVehiculo=Integer.parseInt(txtTipoVehiculo.getText().toString());
       String Propietario=txtPropietario.getText();
       String Placa=txtPlaca.getText();    
       
       if(Propietario.equals("") || Placa.equals("")){
            JOptionPane.showMessageDialog(null, "Todos los campos deben de ser completados");
            limpiartabla();
        }else{
           NVehiculo vehiculo = new NVehiculo(IdUsuario,TipoVehiculo,Propietario,Placa);           
           
           if(vehiculo.modificar(Id)){
               JOptionPane.showMessageDialog(null, "El vehiculo fue actualizado");
               limpiartabla();
           }else{
                System.err.println("Error:");
           }
        }
    }
    void eliminar(){
        int filaSeleccionado=TablaVehiculo.getSelectedRow();
        if(filaSeleccionado==-1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            limpiartabla();
        }else{
            NCargo cargo = new NCargo();
            if(cargo.eliminar(Id)== true){
                JOptionPane.showMessageDialog(null, "El registro del vehiculo fue eliminado");
                limpiartabla();
            }else{
                JOptionPane.showMessageDialog(null, "error");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTipoVehiculo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPropietario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVehiculo = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Gestionar Vehiculo");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Id:");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Tipo Vehiculo:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("IdUsuario:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Propietario:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Placa:");

        TablaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Id Usuario", "Tipo Vehiculo", "Propietario", "Placa"
            }
        ));
        TablaVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVehiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaVehiculo);
        if (TablaVehiculo.getColumnModel().getColumnCount() > 0) {
            TablaVehiculo.getColumnModel().getColumn(0).setMinWidth(50);
            TablaVehiculo.getColumnModel().getColumn(0).setMaxWidth(60);
            TablaVehiculo.getColumnModel().getColumn(1).setMinWidth(80);
            TablaVehiculo.getColumnModel().getColumn(1).setMaxWidth(90);
        }

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(13, 13, 13)
                                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(125, 125, 125))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(4, 4, 4)
                                                .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Agregar();
        listar();
        nuevo();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
        listar();
        nuevo();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
        listar();
        nuevo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void TablaVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVehiculoMouseClicked
        int fila = TablaVehiculo.getSelectedRow();

        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
        }else{
            Id = Integer.parseInt((String) TablaVehiculo.getValueAt(fila, 0).toString());
            int IdUsuario = Integer.parseInt((String) TablaVehiculo.getValueAt(fila, 1).toString());
            int TipoVehiculo = Integer.parseInt((String) TablaVehiculo.getValueAt(fila, 2).toString());
            String Propietario = (String) TablaVehiculo.getValueAt(fila, 3);
            String Placa = (String) TablaVehiculo.getValueAt(fila, 4);
                   
            txtId.setText(""+ Id);
            txtIdUsuario.setText(""+IdUsuario);
            txtTipoVehiculo.setText(""+TipoVehiculo);
            txtPropietario.setText(Propietario);
            txtPlaca.setText(Placa);
        }
    }//GEN-LAST:event_TablaVehiculoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaVehiculo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPropietario;
    private javax.swing.JTextField txtTipoVehiculo;
    // End of variables declaration//GEN-END:variables
}
