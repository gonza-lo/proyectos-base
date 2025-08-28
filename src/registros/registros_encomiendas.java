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
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import recibo.imprecion_enco;
import trans_norte_potosi_mysql.principal;

public class registros_encomiendas extends javax.swing.JInternalFrame {
    private javax.swing.JDesktopPane escritorio;
    private int ci_destinatario;

    // Constructor que acepta JDesktopPane como parámetro
    public registros_encomiendas(JDesktopPane escritorio, int cides) {
        initComponents();
        this.escritorio = escritorio;
        this.ci_destinatario = cides;
        
        setLocation(200, 100);
        // Rellenar automáticamente el campo ci_cliente
        cides1.setText(String.valueOf(ci_destinatario));
        cides1.setEditable(false);
        civen1.removeAllItems();
        configurarOpcionesComboBox();
    }
    private void configurarOpcionesComboBox(){
        String[] opciones4 = {"102891","123456"};
        for (String opcion : opciones4) {
        civen1.addItem(opcion);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desc = new javax.swing.JLabel();
        desc1 = new javax.swing.JTextField();
        dest = new javax.swing.JLabel();
        dest1 = new javax.swing.JTextField();
        pre = new javax.swing.JLabel();
        pre1 = new javax.swing.JTextField();
        cides = new javax.swing.JLabel();
        cides1 = new javax.swing.JTextField();
        civen = new javax.swing.JLabel();
        civen1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setText("descripcion");

        desc1.setBackground(new java.awt.Color(255, 255, 255));
        desc1.setForeground(new java.awt.Color(0, 0, 0));

        dest.setForeground(new java.awt.Color(255, 255, 255));
        dest.setText("destino");

        dest1.setBackground(new java.awt.Color(255, 255, 255));
        dest1.setForeground(new java.awt.Color(0, 0, 0));

        pre.setForeground(new java.awt.Color(255, 255, 255));
        pre.setText("precio");

        pre1.setBackground(new java.awt.Color(255, 255, 255));
        pre1.setForeground(new java.awt.Color(0, 0, 0));
        pre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre1ActionPerformed(evt);
            }
        });

        cides.setForeground(new java.awt.Color(255, 255, 255));
        cides.setText("ci destinatario");

        cides1.setBackground(new java.awt.Color(255, 255, 255));
        cides1.setForeground(new java.awt.Color(0, 0, 0));

        civen.setForeground(new java.awt.Color(255, 255, 255));
        civen.setText("ci vendedora");

        civen1.setBackground(new java.awt.Color(204, 204, 204));
        civen1.setForeground(new java.awt.Color(0, 0, 0));
        civen1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO ENCOMIENDAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cides1)
                    .addComponent(dest1)
                    .addComponent(civen)
                    .addComponent(cides)
                    .addComponent(pre)
                    .addComponent(dest)
                    .addComponent(desc1)
                    .addComponent(pre1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(civen1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(desc))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(desc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(dest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cides)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cides1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(civen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(civen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pre1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Statement  stmt = null; 
      ResultSet rs = null;
      PreparedStatement pstmt = null;
      conectar conexion = new conectar();
      
      String desc=desc1.getText();
      String dest=dest1.getText();
      double pre=Double.parseDouble(pre1.getText());
      int cides=Integer.parseInt(cides1.getText());
      int civen = Integer.parseInt(civen1.getSelectedItem().toString());
      
      if(desc.isEmpty())//llama al metodo isEmpty
       {
          JOptionPane.showMessageDialog(null, "No se ingreso la descripcion!", "Advertencia", JOptionPane.WARNING_MESSAGE);
          return;
       }
      
     try 
      { 
          stmt = conexion.optenerConexion().createStatement();
          //stmt.executeUpdate("INSERT INTO cliente(nombres,paterno) VALUES ('"+nom.toUpperCase()+"','"+pat.toUpperCase()+"','"+dir.toUpperCase()+"',"+fono+")"); 
          stmt.executeUpdate("INSERT INTO incomienda(descripcion,destino,precio,ci_destinatario,ci_vendedora) VALUES ('"+desc+"','"+dest+"',"+pre+","+cides+",'"+civen+"')"); 
          System.out.println("Registro insertado correctamente...!!!!");
          JOptionPane.showMessageDialog(null, "Se inserto correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
          
          ((principal) escritorio.getTopLevelAncestor()).setImprimirenco(cides);
          imprecion_enco viajeForm = new imprecion_enco(escritorio,cides);
          escritorio.add(viajeForm);
          desc1.setText("");
          dest1.setText("");
          pre1.setText("");
          cides1.setText("");
          this.dispose();
      } 
      catch( SQLException e ) 
      {e.printStackTrace();} 
      finally 
      { 
	  if (conexion != null ) 
	  { 
	    try    
	    {conexion.desconectar();} 
	    catch( Exception e ) 
	    {System.out.println( e.getMessage());} 
          } 
      }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cides;
    private javax.swing.JTextField cides1;
    private javax.swing.JLabel civen;
    private javax.swing.JComboBox<String> civen1;
    private javax.swing.JLabel desc;
    private javax.swing.JTextField desc1;
    private javax.swing.JLabel dest;
    private javax.swing.JTextField dest1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pre;
    private javax.swing.JTextField pre1;
    // End of variables declaration//GEN-END:variables
}
