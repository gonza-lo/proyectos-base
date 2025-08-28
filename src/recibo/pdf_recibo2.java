/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recibo;

import conexion.conectar;
import java.awt.*;
import java.awt.print.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class pdf_recibo2 implements Printable {

    private String ciDestinatario, nombreRemitente, apellidosRemitente, nombreDestinatario, apellidosDestinatario;
    private String idEncomienda, descripcionEncomienda, destinoEncomienda, precioEncomienda, ciVendedora;

    public pdf_recibo2(String ciDestinatario) {
        this.ciDestinatario = ciDestinatario;
        obtenerDatosEncomienda(ciDestinatario);
    }

    private void obtenerDatosEncomienda(String ciDestinatario) {
        conectar conn = new conectar();
        Connection connection = conn.optenerConexion();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT e.ci_destinatario, e.nombre_remitente, e.apellido_remitente, " +
                               "e.nombre_destinatario, e.apellido_destinatario, " +
                               "en.id_encomienda, en.descripcion, en.destino, en.precio, en.ci_vendedora " +
                               "FROM envia e " +
                               "INNER JOIN incomienda en ON e.ci_destinatario = en.ci_destinatario " +
                               "WHERE e.ci_destinatario = '" + ciDestinatario + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    idEncomienda = resultSet.getString("id_encomienda");
                    nombreRemitente = resultSet.getString("nombre_remitente");
                    apellidosRemitente = resultSet.getString("apellido_remitente");
                    nombreDestinatario = resultSet.getString("nombre_destinatario");
                    apellidosDestinatario = resultSet.getString("apellido_destinatario");
                    descripcionEncomienda = resultSet.getString("descripcion");
                    destinoEncomienda = resultSet.getString("destino");
                    precioEncomienda = resultSet.getString("precio");
                    ciVendedora = resultSet.getString("ci_vendedora");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el CI ingresado.");
                }

                conn.desconectar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        Font fontTitulo = new Font("Monospaced", Font.BOLD, 12);
        Font fontSubtitulo = new Font("Monospaced", Font.PLAIN, 10);
        Font fontDatos = new Font("Monospaced", Font.ITALIC, 9);

        int y = 20;
        int lineHeight = 12;

        g2d.setFont(fontTitulo);
        centerText(g2d, "SINDICATO DE TRANSPORTE", y, pageFormat);
        y += lineHeight * 2;
        centerText(g2d, "TRANS NORTE", y, pageFormat);
        y += lineHeight * 2;
        centerText(g2d, "=======================", y, pageFormat);
        y += lineHeight * 2;
        centerText(g2d, "ENCOMIENDA", y, pageFormat);
        y += lineHeight * 2;

        g2d.setFont(fontSubtitulo);
        centerText(g2d, "id encomienda: " + idEncomienda, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "CI Destinatario: " + ciDestinatario, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Nombre Remitente: " + nombreRemitente, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Apellido Remitente: " + apellidosRemitente, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Nombre Destinatario: " + nombreDestinatario, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Apellido Destinatario: " + apellidosDestinatario, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Descripción: " + descripcionEncomienda, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Destino: " + destinoEncomienda, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Precio: " + precioEncomienda + " Bs", y, pageFormat);
        y += lineHeight;
        centerText(g2d, "ci vendedora: " + ciVendedora, y, pageFormat);
        y += lineHeight * 2;

        centerText(g2d, "-------------------------", y, pageFormat);
        y += lineHeight * 2;
        g2d.setFont(fontDatos);
        centerText(g2d, "* No se acepta devolución.", y, pageFormat);

        return PAGE_EXISTS;
    }

    private void centerText(Graphics2D g2d, String text, int y, PageFormat pageFormat) {
        FontMetrics metrics = g2d.getFontMetrics();
        int x = (int) ((pageFormat.getImageableWidth() - metrics.stringWidth(text)) / 2);
        g2d.drawString(text, x, y);
    }

    public static void main(String[] args) {
        String ciDestinatario = JOptionPane.showInputDialog("Ingrese el CI del destinatario:");
        if (ciDestinatario == null || ciDestinatario.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un CI válido.");
            return;
        }

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new pdf_recibo2(ciDestinatario));

        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        paper.setSize(74, 105); // A7 size in points (74 x 105 mm)
        paper.setImageableArea(12, 12, 200, 280); // Margins
        pf.setPaper(paper);

        job.setPrintable(new pdf_recibo2(ciDestinatario), pf);

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}