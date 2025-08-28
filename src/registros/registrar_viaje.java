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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import trans_norte_potosi_mysql.principal;
import recibo.imprecion;
/**
 *
 * @author Usuario
 */
public class registrar_viaje extends javax.swing.JInternalFrame {

    private javax.swing.JDesktopPane escritorio;
    private int ciCliente;

    // Constructor que acepta JDesktopPane como parámetro
    public registrar_viaje(javax.swing.JDesktopPane escritorio, int ci) {
        initComponents();
        this.escritorio = escritorio;
        this.ciCliente = ci;
        
        setLocation(200, 100);
        // Rellenar automáticamente el campo ci_cliente
        cicli1.setText(String.valueOf(ciCliente));
        cicli1.setEditable(false);
        horof1.removeAllItems();
        horsal1.removeAllItems();
        des1.removeAllItems();
        pla1.removeAllItems();
        cive1.removeAllItems();
        configurarOpcionesComboBox();
    }
    private void configurarOpcionesComboBox() {
    // Opciones disponibles para origen y destino
    String[] opciones = {"06:00:00","06:30:00"};
    String[] opciones2 = {"123 ABC","123 ASD"};
    String[] opciones3 = {"TOMOYO","SURAGUA","TIKA PAMPA","TORORO","ESQUINKACHI"};
    String[] opciones4 = {"102891","123456"};

    // Llenar el JComboBox para origen y destino con las opciones
    for (String opcion : opciones) {
        horof1.addItem(opcion);
        horsal1.addItem(opcion);
    }
    for (String opcion : opciones2) {
        pla1.addItem(opcion);
    }
    for (String opcion : opciones3) {
        des1.addItem(opcion);
    }
    for (String opcion : opciones4) {
        cive1.addItem(opcion);
    }
}
    // Constructor sin parámetros (si necesitas que siga existiendo)
    public registrar_viaje() {
        initComponents();
        setLocation(200, 100);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        asie = new javax.swing.JLabel();
        asie1 = new javax.swing.JTextField();
        pre = new javax.swing.JLabel();
        pre1 = new javax.swing.JTextField();
        fech = new javax.swing.JLabel();
        fech1 = new com.toedter.calendar.JDateChooser();
        horof = new javax.swing.JLabel();
        horof1 = new javax.swing.JComboBox<>();
        horsal = new javax.swing.JLabel();
        horsal1 = new javax.swing.JComboBox<>();
        des = new javax.swing.JLabel();
        des1 = new javax.swing.JComboBox<>();
        pla = new javax.swing.JLabel();
        pla1 = new javax.swing.JComboBox<>();
        cicli = new javax.swing.JLabel();
        cicli1 = new javax.swing.JTextField();
        cive = new javax.swing.JLabel();
        cive1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("registrar viaje");

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        asie.setForeground(new java.awt.Color(255, 255, 255));
        asie.setText("N° asiento");

        asie1.setBackground(new java.awt.Color(255, 255, 255));
        asie1.setForeground(new java.awt.Color(0, 0, 0));

        pre.setForeground(new java.awt.Color(255, 255, 255));
        pre.setText("precio");

        pre1.setBackground(new java.awt.Color(255, 255, 255));
        pre1.setForeground(new java.awt.Color(0, 0, 0));
        pre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre1ActionPerformed(evt);
            }
        });

        fech.setForeground(new java.awt.Color(255, 255, 255));
        fech.setText("fecha");

        fech1.setBackground(new java.awt.Color(255, 255, 255));
        fech1.setForeground(new java.awt.Color(255, 255, 255));
        fech1.setDateFormatString("yyyy'-'MM'-'dd");

        horof.setForeground(new java.awt.Color(255, 255, 255));
        horof.setText("hora en oficina");

        horof1.setBackground(new java.awt.Color(255, 255, 255));
        horof1.setForeground(new java.awt.Color(0, 0, 0));
        horof1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        horsal.setForeground(new java.awt.Color(255, 255, 255));
        horsal.setText("hora salida");

        horsal1.setBackground(new java.awt.Color(255, 255, 255));
        horsal1.setForeground(new java.awt.Color(0, 0, 0));
        horsal1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        des.setForeground(new java.awt.Color(255, 255, 255));
        des.setText("destino");

        des1.setBackground(new java.awt.Color(255, 255, 255));
        des1.setForeground(new java.awt.Color(0, 0, 0));
        des1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        pla.setForeground(new java.awt.Color(255, 255, 255));
        pla.setText("num placa");

        pla1.setBackground(new java.awt.Color(255, 255, 255));
        pla1.setForeground(new java.awt.Color(0, 0, 0));
        pla1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cicli.setForeground(new java.awt.Color(255, 255, 255));
        cicli.setText("ci cliente");

        cicli1.setBackground(new java.awt.Color(255, 255, 255));
        cicli1.setForeground(new java.awt.Color(0, 0, 0));

        cive.setForeground(new java.awt.Color(255, 255, 255));
        cive.setText("ci vendedora");

        cive1.setBackground(new java.awt.Color(255, 255, 255));
        cive1.setForeground(new java.awt.Color(0, 0, 0));
        cive1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
        jLabel1.setText("REGISTRO DE VIAJE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horof1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horof)
                            .addComponent(asie))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(horsal)
                            .addComponent(horsal1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pre1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asie1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cicli1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cive1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(des1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(des)
                                    .addComponent(cicli))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pla, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pla1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cive))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(fech, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(fech1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fech)
                    .addComponent(fech1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asie)
                    .addComponent(pre, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asie1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horsal)
                    .addComponent(horof, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horof1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horsal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(des)
                    .addComponent(pla, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(des1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cicli)
                    .addComponent(cive, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cicli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cive1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Statement  stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        conectar conexion = new conectar();

        String asie = asie1.getText();
        Date fechaSeleccionada = fech1.getDate(); // Obtener la fecha desde JDateChooser
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fech = formato.format(fechaSeleccionada);
        String horof = (String) horof1.getSelectedItem();
        String horsal = (String) horsal1.getSelectedItem();
        double pre=Double.parseDouble(pre1.getText());
        String des = (String) des1.getSelectedItem();
        int cicli= Integer.parseInt(cicli1.getText());
        String pla = (String) pla1.getSelectedItem();
        int cive = Integer.parseInt(cive1.getSelectedItem().toString());

        if(asie.isEmpty())//llama al metodo isEmpty
        {
            JOptionPane.showMessageDialog(null, "No se ingreso el numero de asiento!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try
        {
            stmt = conexion.optenerConexion().createStatement();
            //stmt.executeUpdate("INSERT INTO cliente(nombres,paterno) VALUES ('"+nom.toUpperCase()+"','"+pat.toUpperCase()+"','"+dir.toUpperCase()+"',"+fono+")");
            stmt.executeUpdate("INSERT INTO viaje(num_aciento,fecha_viaje,hora_en_oficina,hora_salida,precio,ci_cliente,num_placa,destino,ci_vendedora) VALUES ('"+asie+"','"+fech+"','"+horof+"','"+horsal+"',"+pre+","+cicli+",'"+pla+"','"+des+"','"+cive+"')");
            System.out.println("Registro insertado correctamente...!!!!");
            JOptionPane.showMessageDialog(null, "Se inserto correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            
            ((principal) escritorio.getTopLevelAncestor()).setImprimir(cicli);
            imprecion viajeForm = new imprecion(escritorio,cicli);
            escritorio.add(viajeForm);
            viajeForm.show();
            asie1.setText("");
            pre1.setText("");
            cicli1.setText("");
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

    private void pre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pre1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asie;
    private javax.swing.JTextField asie1;
    private javax.swing.JLabel cicli;
    private javax.swing.JTextField cicli1;
    private javax.swing.JLabel cive;
    private javax.swing.JComboBox<String> cive1;
    private javax.swing.JLabel des;
    private javax.swing.JComboBox<String> des1;
    private javax.swing.JLabel fech;
    private com.toedter.calendar.JDateChooser fech1;
    private javax.swing.JLabel horof;
    private javax.swing.JComboBox<String> horof1;
    private javax.swing.JLabel horsal;
    private javax.swing.JComboBox<String> horsal1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pla;
    private javax.swing.JComboBox<String> pla1;
    private javax.swing.JLabel pre;
    private javax.swing.JTextField pre1;
    // End of variables declaration//GEN-END:variables
}
