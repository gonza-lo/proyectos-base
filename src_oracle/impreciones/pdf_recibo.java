
package impreciones;
import conexion.conectar;
import java.awt.*;
import java.awt.print.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class pdf_recibo implements Printable {

    private String ciCliente, nombreCliente, apellidosCliente, numAsiento, precioViaje, fechaViaje, horaEnOficina, horaSalida, destino;

    public pdf_recibo(String ciCliente) {
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
                               "v.precio, v.fecha_viaje, v.hora_en_oficina, v.hora_salida, v.num_asiento, " +
                               "r.destino " +
                               "FROM cliente c " +
                               "INNER JOIN viaje v ON c.ci_cliente = v.ci_cliente " +
                               "INNER JOIN ruta r ON v.id_viaje = r.id_viaje " +
                               "WHERE c.ci_cliente = " + ciCliente;
                
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    nombreCliente = resultSet.getString("nombre");
                    apellidosCliente = resultSet.getString("apellidos");
                    numAsiento = resultSet.getString("num_asiento");
                    precioViaje = resultSet.getString("precio");
                    fechaViaje = resultSet.getString("fecha_viaje");
                    horaEnOficina = resultSet.getString("hora_en_oficina");
                    horaSalida = resultSet.getString("hora_salida");
                    destino = resultSet.getString("destino");
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

        Font fontTitulo = new Font("Courier", Font.BOLD, 16);
        Font fontSubtitulo = new Font("Courier", Font.PLAIN, 10);
        Font fontDatos = new Font("Courier", Font.ITALIC, 10);
        g2d.setFont(fontTitulo);
        
        int y = 50;
        int lineHeight = 12;

        g2d.drawString("TRANS SURAGUA", 100, y);
        y += lineHeight * 2;

        g2d.setFont(fontSubtitulo);
        g2d.drawString("CI Cliente: " + ciCliente, 50, y);
        y += lineHeight;
        g2d.drawString("Nombre: " + nombreCliente, 50, y);
        y += lineHeight;
        g2d.drawString("Apellido: " + apellidosCliente, 50, y);
        y += lineHeight;
        g2d.drawString("Número de Asiento: " + numAsiento, 50, y);
        y += lineHeight;
        g2d.drawString("Precio del Viaje: " + precioViaje, 50, y);
        y += lineHeight;
        g2d.drawString("Fecha: " + fechaViaje, 50, y);
        y += lineHeight;
        g2d.drawString("Hora en Oficina: " + horaEnOficina, 50, y);
        y += lineHeight;
        g2d.drawString("Hora de Salida: " + horaSalida, 50, y);
        y += lineHeight;
        g2d.drawString("Destino: " + destino, 50, y);
        y += lineHeight * 2;

        g2d.drawString("No se acepta devolución de pasajes.", 50, y);
        y += lineHeight;
        g2d.drawString("Equipaje Libre de 15 Kg.", 50, y);
        y += lineHeight;
        g2d.drawString("En oficina 30 minutos de anticipación", 50, y);
        y += lineHeight;
        g2d.drawString("GRACIAS POR SU PREFERENCIA", 50, y);

        return PAGE_EXISTS;
    }

    public static void main(String[] args) {
        String ciCliente = JOptionPane.showInputDialog("Ingrese el CI del cliente:");
        if (ciCliente == null || ciCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un CI válido.");
            return;
        }

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new pdf_recibo(ciCliente));

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