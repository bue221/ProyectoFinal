
package view;

import bizSql.NCargo;
import bizSql.NEstacionamiento;
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
public class VEstacionamiento extends javax.swing.JPanel {

   //MySql
    Conexion con=new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    
    int Id;
    NEstacionamiento estacionamiento = new NEstacionamiento();
    
    public VEstacionamiento() {
        initComponents();
        listar();
    }

    private void limpiartabla(){
       for(int i=1;i<=TablaEstacionamiento.getRowCount();i++){
            i=i-i;
           modelo.removeRow(i); 
       }
    }
    void listar(){
       String sql="Select * from Estacionamiento";
       try{
           cn=con.getConnection();
           st=cn.createStatement();
           rs=st.executeQuery(sql);
           Object[]estacionamiento = new Object[3];
           modelo = (DefaultTableModel)TablaEstacionamiento.getModel();
           while (rs.next()){
               estacionamiento[0]=rs.getString("Id");
               estacionamiento[1]=rs.getString("DisponibilidadMoto");
               estacionamiento[2]=rs.getString("DisponibilidadCarro");
               modelo.addRow(estacionamiento);
           }
           TablaEstacionamiento.setModel(modelo);
       }catch (Exception e){
           
       }
   }
    void nuevo(){
        txtId.setText("");
        txtMoto.setText("");
        txtCarro.setText("");
    }
    
    void Agregar(){
       
       int DisponibilidadMoto=Integer.parseInt(txtMoto.getText().toString());
       int DisponibilidadCarro=Integer.parseInt(txtCarro.getText().toString());  
       
          NEstacionamiento estacionamiento = new NEstacionamiento(DisponibilidadMoto,DisponibilidadCarro);
           
           if(estacionamiento.agregar()){
               JOptionPane.showMessageDialog(null, "Se agrego un estacionamiento");
               limpiartabla();
           }else{
               System.err.println("Error");
           }
       
       
   }
    void modificar(){
        //variables
       int DisponibilidadMoto = Integer.parseInt(txtMoto.getText().toString());
       int DisponibilidadCarro = Integer.parseInt(txtCarro.getText().toString());      
       
        NEstacionamiento estacionamiento = new NEstacionamiento(DisponibilidadMoto,DisponibilidadCarro);          
           
           if(estacionamiento.modificar(Id)){
               JOptionPane.showMessageDialog(null, "El estacionamiento esta actualizado");
               limpiartabla();
           }else{
               System.err.println("Error:");
           }
    }
    void eliminar(){
        int filaSeleccionado=TablaEstacionamiento.getSelectedRow();
        if(filaSeleccionado==-1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            limpiartabla();
        }else{
            NEstacionamiento estacionamiento = new NEstacionamiento();
            if(estacionamiento.eliminar(Id)== true){
                JOptionPane.showMessageDialog(null, "El estacionamiento fue eliminado");
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
        txtMoto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCarro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEstacionamiento = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Gestionar Estacionamiento");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Id:");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Disponibilidad Moto:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Disponibilidad Carro:");

        TablaEstacionamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Disponibilidad Moto", "Disponibilidad Carro"
            }
        ));
        TablaEstacionamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEstacionamientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEstacionamiento);
        if (TablaEstacionamiento.getColumnModel().getColumnCount() > 0) {
            TablaEstacionamiento.getColumnModel().getColumn(0).setMinWidth(50);
            TablaEstacionamiento.getColumnModel().getColumn(0).setMaxWidth(60);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabel3)
                            .addGap(4, 4, 4)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void TablaEstacionamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEstacionamientoMouseClicked
        int fila = TablaEstacionamiento.getSelectedRow();

        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
        }else{
            Id = Integer.parseInt((String) TablaEstacionamiento.getValueAt(fila, 0).toString());
            int DisponibilidadMoto = Integer.parseInt((String) TablaEstacionamiento.getValueAt(fila, 1).toString());
            int DisponibilidadCarro = Integer.parseInt((String) TablaEstacionamiento.getValueAt(fila, 2).toString());
            
            
            txtId.setText(""+ Id);
            txtMoto.setText(""+DisponibilidadMoto);
            txtCarro.setText(""+DisponibilidadCarro);  
        }
    }//GEN-LAST:event_TablaEstacionamientoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEstacionamiento;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCarro;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMoto;
    // End of variables declaration//GEN-END:variables
}
