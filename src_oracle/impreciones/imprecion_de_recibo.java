/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package impreciones;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.conectar;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class imprecion_de_recibo extends javax.swing.JInternalFrame {

    public imprecion_de_recibo() {
        initComponents();
        setLocation(300,100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("impresiones");

        jButton1.setText("generar boleta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Document document = new Document(PageSize.A6);
        try {
            
            String ciCliente = JOptionPane.showInputDialog("Ingrese el CI del cliente:");
            if (ciCliente == null || ciCliente.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un CI válido.");
                return;
            }

            String rutaSalida = "d:\\reportes net\\zpruevareciboReporte.pdf"; // Cambiar ruta aquí
            PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));
            document.open();

            Font letraTitulo = new Font(Font.FontFamily.COURIER, 20, Font.BOLD); // Fuente tipo recibo para el título
            Font letraSubTitulo = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
            //Font fontContent = FontFactory.getFont("Arial", 12, Font.NORMAL);
            Font letraDatos = new Font(Font.FontFamily.COURIER, 12, Font.ITALIC);// Fuente tipo recibo para el contenido

            String imagePath = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\trans_norte_potosi_oracle\\src\\impreciones\\autobus.png"; // Ajusta la ruta si es necesario
            Image img = Image.getInstance(imagePath);
            img.scaleToFit(40, 40); 
            img.setAlignment(Element.ALIGN_LEFT);

            Paragraph titulo = new Paragraph("TRANS SURAGUA", letraTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);

            // Crear un contenedor para la imagen y el título
            PdfPTable contenedorTitulo = new PdfPTable(2); // 2 columnas: una para la imagen y otra para el título
            contenedorTitulo .setWidthPercentage(100);
            contenedorTitulo .addCell(new PdfPCell(img, true));
            contenedorTitulo .addCell(new PdfPCell(titulo));
            contenedorTitulo .addCell(new PdfPCell(new Paragraph(" "))); 
            document.add(contenedorTitulo );
            document.add(new Paragraph(" ", letraSubTitulo)); 

            conectar conn = new conectar(); 
            Connection connection = conn.optenerConexion(); 

            if (connection != null) {
                Statement statement = connection.createStatement();
                // Ajustar la consulta SQL para obtener los datos del cliente, los detalles del viaje y el destino
                String query = "SELECT c.ci_cliente, c.nombre, c.apellidos, " +
                               "v.precio, v.fecha_viaje, v.hora_en_oficina, v.hora_salida, v.num_asiento, " +
                               "r.destino " +
                               "FROM cliente c " +
                               "INNER JOIN viaje v ON c.ci_cliente = v.ci_cliente " +
                               "INNER JOIN ruta r ON v.id_viaje = r.id_viaje " +
                               "WHERE c.ci_cliente = " + ciCliente;

                ResultSet resultSet = statement.executeQuery(query);

                PdfPTable table = new PdfPTable(2); 
                table.setWidthPercentage(100);

                // Verificar si se encontraron datos
                boolean datosEncontrados = false;
                while (resultSet.next()) {

                    // Agregar celdas con la etiqueta y su respectivo valor
                    table.addCell(new PdfPCell(new Phrase("CI Cliente:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("ci_cliente"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Nombre:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("nombre"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Apellido:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("apellidos"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Número de Asiento:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("num_asiento"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Precio del Viaje:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("precio"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Fecha:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("fecha_viaje"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Hora en Oficina:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("hora_en_oficina"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Hora de Salida:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("hora_salida"), letraDatos )));

                    table.addCell(new PdfPCell(new Phrase("Destino:", letraSubTitulo)));
                    table.addCell(new PdfPCell(new Phrase(resultSet.getString("destino"), letraDatos )));

                    datosEncontrados = true;
                }

                // Verificar si se encontraron datos
                if (!datosEncontrados) {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el CI ingresado.");
                } else {
                    // Agregar la tabla al documento si hay datos
                    document.add(table);
                }

                // Cerrar el documento y la conexión
                document.close();
                conn.desconectar();

                File pdfFile = new File(rutaSalida);
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("El sistema no soporta la apertura de archivos.");
                }

            } else {
                System.out.println("Error al conectar con la base de datos.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
