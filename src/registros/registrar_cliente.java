/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package registros;

import conexion.conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import trans_norte_potosi_mysql.principal;

/**
 *
 * @author Usuario
 */
public class registrar_cliente extends javax.swing.JInternalFrame {

private javax.swing.JDesktopPane escritorio;

    // Constructor que acepta JDesktopPane como parámetro
    public registrar_cliente(javax.swing.JDesktopPane escritorio) {
        initComponents();
        this.escritorio = escritorio;
        setLocation(200, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ci1 = new javax.swing.JTextField();
        ci = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        nom1 = new javax.swing.JTextField();
        pat = new javax.swing.JLabel();
        pat1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        ci1.setBackground(new java.awt.Color(255, 255, 255));
        ci1.setForeground(new java.awt.Color(0, 0, 0));
        ci1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ci1ActionPerformed(evt);
            }
        });

        ci.setForeground(new java.awt.Color(255, 255, 255));
        ci.setText("N° ci");

        nom.setForeground(new java.awt.Color(255, 255, 255));
        nom.setText("nombre");

        nom1.setBackground(new java.awt.Color(255, 255, 255));
        nom1.setForeground(new java.awt.Color(0, 0, 0));

        pat.setForeground(new java.awt.Color(255, 255, 255));
        pat.setText("apellido");

        pat1.setBackground(new java.awt.Color(255, 255, 255));
        pat1.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO CLIENTE");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Pictures\\proyecto tran norte\\cliente.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ci)
                    .addComponent(nom)
                    .addComponent(pat)
                    .addComponent(ci1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(nom1)
                    .addComponent(pat1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(128, 128, 128))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(ci)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ci1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ci1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ci1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ci1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Statement stmt = null; 
    conectar conexion = new conectar();
  
    String nom = nom1.getText();
    String pat = pat1.getText();
    int ci = Integer.parseInt(ci1.getText());

    if (nom.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No se ingreso el nombre!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try { 
        stmt = conexion.optenerConexion().createStatement();
        stmt.executeUpdate("INSERT INTO cliente(ci_cliente, nombre, apellidos) VALUES (" + ci + ",'" + nom.toUpperCase() + "','" + pat.toUpperCase() + "')");
        System.out.println("Registro insertado correctamente...!!!!");
        JOptionPane.showMessageDialog(null, "Se inserto correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

        ((principal) escritorio.getTopLevelAncestor()).setCiCliente(ci);
        registrar_viaje viajeForm = new registrar_viaje(escritorio,ci);
        escritorio.add(viajeForm);
        viajeForm.show();
        
        nom1.setText("");
        pat1.setText("");
        ci1.setText("");

        this.dispose(); 
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conexion != null) {
            try { conexion.desconectar(); } 
            catch (Exception e) { System.out.println(e.getMessage()); }
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ci;
    private javax.swing.JTextField ci1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField nom1;
    private javax.swing.JLabel pat;
    private javax.swing.JTextField pat1;
    // End of variables declaration//GEN-END:variables
}
