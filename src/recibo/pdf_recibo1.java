
package recibo;
import conexion.conectar;
import java.awt.*;
import java.awt.print.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class pdf_recibo1 implements Printable {

    private String ciCliente, nombreCliente, apellidosCliente, numAsiento, precioViaje, fechaViaje, horaEnOficina;
    private String idViaje, horaSalida, destino, ciVendedora;

    public pdf_recibo1(String ciCliente) {
        this.ciCliente = ciCliente;
        obtenerDatosCliente(ciCliente);
    }

    private void obtenerDatosCliente(String ciCliente) {
        conectar conn = new conectar();
        Connection connection = conn.optenerConexion();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT c.ci_cliente, c.nombre, c.apellidos, " +
               "v.id_viaje, v.precio, v.fecha_viaje, v.hora_en_oficina, v.hora_salida, v.num_aciento, v.destino, v.ci_vendedora " +
               "FROM cliente c " +
               "INNER JOIN viaje v ON c.ci_cliente = v.ci_cliente " +
               "WHERE c.ci_cliente = " + ciCliente;
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    idViaje = resultSet.getString("id_viaje");
                    nombreCliente = resultSet.getString("nombre");
                    apellidosCliente = resultSet.getString("apellidos");
                    numAsiento = resultSet.getString("num_aciento");
                    precioViaje = resultSet.getString("precio");
                    fechaViaje = resultSet.getString("fecha_viaje");
                    horaEnOficina = resultSet.getString("hora_en_oficina");
                    horaSalida = resultSet.getString("hora_salida");
                    destino = resultSet.getString("destino");
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
        centerText(g2d, "NORTE POTOSI", y, pageFormat);
        y += lineHeight * 2;
        centerText(g2d, "=======================", y, pageFormat);
        y += lineHeight * 2;
        centerText(g2d, "FACTURA", y, pageFormat);
        y += lineHeight ;

        g2d.setFont(fontSubtitulo);
        centerText(g2d, "Factura No.: " + idViaje, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "CI Cliente: " + ciCliente, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Nombre: " + nombreCliente, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Apellido: " + apellidosCliente, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Nro. Asiento: " + numAsiento, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Precio: " + precioViaje + " Bs", y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Fecha: " + fechaViaje, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Hora Oficina: " + horaEnOficina, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Hora Salida: " + horaSalida, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Destino: " + destino, y, pageFormat);
        y += lineHeight;
        centerText(g2d, "vendedora: " + ciVendedora, y, pageFormat);
        y += lineHeight * 2;
        
        centerText(g2d, "-------------------------", y, pageFormat);
        y += lineHeight * 2;
        g2d.setFont(fontDatos);
        centerText(g2d, "* No se acepta devolución.", y, pageFormat);
        y += lineHeight;
        centerText(g2d, "* Equipaje Libre de 15 Kg.", y, pageFormat);
        y += lineHeight;
        centerText(g2d, "* En oficina 30 minutos antes.", y, pageFormat);
        y += lineHeight;
        centerText(g2d, "Gracias por su preferencia", y, pageFormat);

        return PAGE_EXISTS;
    }

    private void centerText(Graphics2D g2d, String text, int y, PageFormat pageFormat) {
        FontMetrics metrics = g2d.getFontMetrics();
        int x = (int) ((pageFormat.getImageableWidth() - metrics.stringWidth(text)) / 2);
        g2d.drawString(text, x, y);
    }

    public static void main(String[] args) {
        String ciCliente = JOptionPane.showInputDialog("Ingrese el CI del cliente:");
        if (ciCliente == null || ciCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un CI válido.");
            return;
        }

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new pdf_recibo1(ciCliente));

        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        paper.setSize(74, 125); // A7 size in points (74 x 105 mm)
        paper.setImageableArea(12, 12, 200, 280); // Margins
        pf.setPaper(paper);

        job.setPrintable(new pdf_recibo1(ciCliente), pf);

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