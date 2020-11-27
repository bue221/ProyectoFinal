
package view;

import bizSql.NCargo;
import bizSql.NTipoVehiculo;
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
public class VTipoVehiculo extends javax.swing.JPanel {

    //MySql
    Conexion con=new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    
    int Id;
    NTipoVehiculo tipo = new NTipoVehiculo();
    
    public VTipoVehiculo() {
        initComponents();
        listar();
    }

    private void limpiartabla(){
       for(int i=1;i<=TablaTipo.getRowCount();i++){
            i=i-i;
           modelo.removeRow(i); 
       }
    }
    void listar(){
       String sql="Select * from TipoVehiculo";
       try{
           cn=con.getConnection();
           st=cn.createStatement();
           rs=st.executeQuery(sql);
           Object[]tipo = new Object[2];
           modelo = (DefaultTableModel)TablaTipo.getModel();
           while (rs.next()){
               tipo[0]=rs.getString("Id");
               tipo[1]=rs.getString("TipoVehiculo");
               modelo.addRow(tipo);
           }
           TablaTipo.setModel(modelo);
       }catch (Exception e){
           
       }
   }
    void nuevo(){
        txtId.setText("");
        txtTipoVehiculo.setText("");
    }
    
    void Agregar(){
     
       String TipoVehiculo=txtTipoVehiculo.getText();
               
       if(TipoVehiculo.equals("")){
           JOptionPane.showMessageDialog(null, "Debes ingresar informacion en todos los campos");
           limpiartabla();
       }else{
          NTipoVehiculo tipo = new NTipoVehiculo(TipoVehiculo);
           
           if(tipo.agregar()){
               JOptionPane.showMessageDialog(null, "Se agrego un tipo de vehiculo");
               limpiartabla();
           }else{
               System.err.println("Error");
           }
       }
       
   }
    void modificar(){
        
       //variables
       String TipoVehiculo=txtTipoVehiculo.getText(); 
       
       if(TipoVehiculo.equals("")){
            JOptionPane.showMessageDialog(null, "Todos los campos deben de ser completados");
            limpiartabla();
        }else{
           NTipoVehiculo tipo = new NTipoVehiculo(TipoVehiculo);           
           
           if(tipo.modificar(Id)){
               JOptionPane.showMessageDialog(null, "El tipo de vehiculo fue actualizado");
               limpiartabla();
           }else{
                System.err.println("Error:");
           }
        }
    }
    void eliminar(){
        int filaSeleccionado=TablaTipo.getSelectedRow();
        if(filaSeleccionado==-1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            limpiartabla();
        }else{
            NTipoVehiculo tipo = new NTipoVehiculo();
            if(tipo.eliminar(Id)== true){
                JOptionPane.showMessageDialog(null, "El registro del tipo de vehiculo fue eliminado");
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
        txtTipoVehiculo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTipo = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Tipo de Vehiculo");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Id:");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Tipo Vehiculo:");

        TablaTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "TipoVehiculo"
            }
        ));
        TablaTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTipoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTipo);

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
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void TablaTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTipoMouseClicked
        int fila = TablaTipo.getSelectedRow();

        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Campo no seleccionado");
        }else{
            Id = Integer.parseInt((String) TablaTipo.getValueAt(fila, 0).toString());
            String TipoVehiculo = (String) TablaTipo.getValueAt(fila, 1);
                   
            txtId.setText(""+ Id);
            txtTipoVehiculo.setText(TipoVehiculo);
        }
    }//GEN-LAST:event_TablaTipoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTipo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTipoVehiculo;
    // End of variables declaration//GEN-END:variables
}
