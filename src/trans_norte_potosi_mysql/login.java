/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trans_norte_potosi_mysql;

//import login.*;

import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        setLocation(200,100);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        contraceña = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        ingresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Pictures\\proyecto tran norte\\bus_oficial.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 650));

        nombre.setBackground(new java.awt.Color(255, 255, 255));
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 210, -1));

        usuario.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setText("usuario");
        jPanel2.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        contraceña.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        contraceña.setForeground(new java.awt.Color(255, 255, 255));
        contraceña.setText("contraceña");
        jPanel2.add(contraceña, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 87, -1));

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 210, -1));

        ingresar.setBackground(new java.awt.Color(0, 0, 51));
        ingresar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ingresar.setForeground(new java.awt.Color(255, 255, 255));
        ingresar.setText("ingreasar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        jPanel2.add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 200, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INICIAR SESION");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 160, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Pictures\\proyecto tran norte\\login_icono.png")); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 240, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        String usuario=nombre.getText();
        String contraceña = new String(password.getPassword());
        acceso  login = new acceso();
        if(login.iniciarSecion(usuario, contraceña)){
            JOptionPane.showMessageDialog(null, "inicio de secion exitoso");
            
            principal enlace=new principal();
            enlace.setVisible(true);
            hide();
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "usuario o contraceña incorrecta");
        }
    }//GEN-LAST:event_ingresarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contraceña;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
