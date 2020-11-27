
package view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author bue221
 */
public class VPrincipal extends javax.swing.JFrame {

    
    VPruebaVista tipo;
    VEstacionamiento estacionamiento;
    VRetirar1 retirar;
    VCargo cargo;
    VUsuario usuario;
    VListar listar;
    VAcerca acerca;
    VTrabajador trabajador;
    VSede sede;

    /**
     * Creates new form VPrincipal
     */
    public VPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        setSize(1250, 600);
        
        tipo = new VPruebaVista();
        tipo.setBounds(300,0,600,460);
        add(tipo);
        tipo.setVisible(false);
        
        estacionamiento = new VEstacionamiento();
        estacionamiento.setBounds(300,0,600,460);
        add(estacionamiento);
        estacionamiento.setVisible(false);
        
        cargo = new VCargo();
        cargo.setBounds(300,0,600,460);
        add(cargo);
        cargo.setVisible(false);
        
        usuario = new VUsuario();
        usuario.setBounds(300,0,800,460);
        add(usuario);
        usuario.setVisible(false);

        listar = new VListar();
        listar.setBounds(300, 0, 600, 460);
        add(listar);
        listar.setVisible(false);

        acerca = new VAcerca();
        acerca.setBounds(300, 0, 473, 460);
        add(acerca);
        acerca.setVisible(false);

        retirar = new VRetirar1();
        retirar.setBounds(300, 0, 950, 460);
        add(retirar);
        retirar.setVisible(false);

        trabajador = new VTrabajador();
        trabajador.setBounds(300, 0, 950, 400);
        add(trabajador);
        trabajador.setVisible(false);

        sede = new VSede();
        sede.setBounds(300, 0, 600, 600);
        add(sede);
        sede.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnRetirarVehiculo = new javax.swing.JButton();
        btnVehiculo = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnSede = new javax.swing.JButton();
        btnCargo = new javax.swing.JButton();
        btnEstacionamiento = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnTipoVehiculo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(65, 169, 173));

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ParkingSoft");

        btnRetirarVehiculo.setBackground(new java.awt.Color(34, 44, 63));
        btnRetirarVehiculo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnRetirarVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnRetirarVehiculo.setText("Retirar Vehiculo");
        btnRetirarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarVehiculoActionPerformed(evt);
            }
        });

        btnVehiculo.setBackground(new java.awt.Color(34, 44, 63));
        btnVehiculo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnVehiculo.setText("Listar Vehiculos");
        btnVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculoActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(34, 44, 63));
        jButton4.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnSede.setBackground(new java.awt.Color(34, 44, 63));
        btnSede.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnSede.setForeground(new java.awt.Color(255, 255, 255));
        btnSede.setText("Sedes");
        btnSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSedeActionPerformed(evt);
            }
        });

        btnCargo.setBackground(new java.awt.Color(34, 44, 63));
        btnCargo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnCargo.setForeground(new java.awt.Color(255, 255, 255));
        btnCargo.setText("Cargo");
        btnCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargoActionPerformed(evt);
            }
        });

        btnEstacionamiento.setBackground(new java.awt.Color(34, 44, 63));
        btnEstacionamiento.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnEstacionamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnEstacionamiento.setText("Estacionamiento");
        btnEstacionamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstacionamientoActionPerformed(evt);
            }
        });

        btnUsuario.setBackground(new java.awt.Color(34, 44, 63));
        btnUsuario.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setText("Usuarios");
        btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuarioMouseClicked(evt);
            }
        });
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnTipoVehiculo.setBackground(new java.awt.Color(34, 44, 63));
        btnTipoVehiculo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnTipoVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnTipoVehiculo.setText("Tipo de Vehiculo");
        btnTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSede, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetirarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetirarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSede, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jMenu1.setText("Acerca del proyecto");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("ir al repo");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cerrar sesión");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 524, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetirarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarVehiculoActionPerformed
        // TODO add your handling code here:

        tipo.setVisible(false);
        estacionamiento.setVisible(false);
        usuario.setVisible(false);
        retirar.setVisible(true);
        listar.setVisible(false);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        sede.setVisible(false);
        cargo.setVisible(false);
    }//GEN-LAST:event_btnRetirarVehiculoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/bue221/ProyectoFinal"));
        } catch (URISyntaxException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al ir al repositorio");
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed

        tipo.setVisible(false);
        estacionamiento.setVisible(false);
        usuario.setVisible(true);
        retirar.setVisible(false);
        listar.setVisible(false);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        sede.setVisible(false);
        cargo.setVisible(false);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculoActionPerformed

        tipo.setVisible(false);
        estacionamiento.setVisible(false);
        usuario.setVisible(false);
        retirar.setVisible(false);
        listar.setVisible(true);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        sede.setVisible(false);
        cargo.setVisible(false);
    }//GEN-LAST:event_btnVehiculoActionPerformed


    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        tipo.setVisible(false);
        estacionamiento.setVisible(false);
        usuario.setVisible(false);
        retirar.setVisible(false);
        listar.setVisible(false);
        acerca.setVisible(true);
        trabajador.setVisible(false);
        sede.setVisible(false);
        cargo.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btnUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseClicked

        tipo.setVisible(false);
        estacionamiento.setVisible(false);
        usuario.setVisible(true);
        retirar.setVisible(false);
        listar.setVisible(false);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        sede.setVisible(false);
        cargo.setVisible(false);
    }//GEN-LAST:event_btnUsuarioMouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        VLogin login = new VLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void btnSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSedeActionPerformed
        estacionamiento.setVisible(false);
        tipo.setVisible(false);
        usuario.setVisible(false);
        retirar.setVisible(false);
        listar.setVisible(false);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        cargo.setVisible(false);
        sede.setVisible(true);
    }//GEN-LAST:event_btnSedeActionPerformed

    private void btnCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargoActionPerformed
        estacionamiento.setVisible(false);
        tipo.setVisible(false);
        usuario.setVisible(false);
        retirar.setVisible(false);
        listar.setVisible(false);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        cargo.setVisible(true);
        sede.setVisible(false);
    }//GEN-LAST:event_btnCargoActionPerformed

    private void btnEstacionamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstacionamientoActionPerformed
        estacionamiento.setVisible(true);
        tipo.setVisible(false);
        usuario.setVisible(false);
        retirar.setVisible(false);
        listar.setVisible(false);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        cargo.setVisible(false);
        sede.setVisible(false);
    }//GEN-LAST:event_btnEstacionamientoActionPerformed

    private void btnTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoVehiculoActionPerformed
        estacionamiento.setVisible(false);
        tipo.setVisible(true);
        usuario.setVisible(false);
        retirar.setVisible(false);
        listar.setVisible(false);
        acerca.setVisible(false);
        trabajador.setVisible(false);
        cargo.setVisible(false);
        sede.setVisible(false);
    }//GEN-LAST:event_btnTipoVehiculoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargo;
    private javax.swing.JButton btnEstacionamiento;
    private javax.swing.JButton btnRetirarVehiculo;
    private javax.swing.JButton btnSede;
    private javax.swing.JButton btnTipoVehiculo;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVehiculo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
