
package recibo;
import conexion.conectar;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.Paper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class pdf_recibo implements Printable {

    private String ciCliente;
    private String nombreCliente;
    private String apellidosCliente;
    private String numAsiento;
    private String precioViaje;
    private String fechaViaje;
    private String horaEnOficina;
    private String horaSalida;
    private String destino;

    public pdf_recibo(String ciCliente) {
        this.ciCliente = ciCliente;
        obtenerDatosCliente();
    }

    private void obtenerDatosCliente() {
        conectar conn = new conectar();
        Connection connection = conn.obtenerConexion();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT c.ci_cliente, c.nombre, c.apellidos, " +
                               "v.precio, v.fecha_viaje, v.hora_en_oficina, v.hora_salida, v.num_aciento, " +
                               "r.destino " +
                               "FROM cliente c " +
                               "INNER JOIN viaje v ON c.ci_cliente = v.ci_cliente " +
                               "INNER JOIN ruta r ON v.id_viaje = r.id_viaje " +
                               "WHERE c.ci_cliente = " + ciCliente;

                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    nombreCliente = resultSet.getString("nombre");
                    apellidosCliente = resultSet.getString("apellidos");
                    numAsiento = resultSet.getString("num_aciento");
                    precioViaje = resultSet.getString("precio");
                    fechaViaje = resultSet.getString("fecha_viaje");
                    horaEnOficina = resultSet.getString("hora_en_oficina");
                    horaSalida = resultSet.getString("hora_salida");
                    destino = resultSet.getString("destino");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el CI ingresado.");
                }
                conn.desconectar(); // Cerrar conexión
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        g2d.setFont(new Font("Monospaced", Font.PLAIN, 8));
        FontMetrics fm = g2d.getFontMetrics();

        int y = 50;
        int lineHeight = 12;
        int pageWidth = (int) pageFormat.getImageableWidth();

        String texto;

        texto = "SINDICATO TRANSPORTE";
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "\"TRANS. SURAGUA\"";
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "LLALLAGUA, SURAGUA, ORKABAMBA, VISCACHANI";
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight * 2;

        texto = "CI Cliente: " + ciCliente;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Nombre: " + nombreCliente;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Apellido: " + apellidosCliente;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Número de Asiento: " + numAsiento;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Precio del Viaje: " + precioViaje;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Fecha: " + fechaViaje;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Hora en Oficina: " + horaEnOficina;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Hora de Salida: " + horaSalida;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Destino: " + destino;
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight * 2;

        texto = "No se acepta devolución de pasajes.";
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "Equipaje Libre de 15 Kg.";
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "En oficina 30 minutos de anticipación";
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);
        y += lineHeight;

        texto = "GRACIAS POR SU PREFERENCIA";
        g2d.drawString(texto, getCenteredX(fm, texto, pageWidth), y);

        return PAGE_EXISTS;
    }

    private int getCenteredX(FontMetrics fm, String text, int pageWidth) {
        return (pageWidth - fm.stringWidth(text)) / 2;
    }

    // Método para ser llamado desde el botón
    public void imprimirRecibo(String ciCliente) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new pdf_recibo(ciCliente));

        PageFormat pageFormat = job.defaultPage();
        Paper paper = new Paper();
        double width = 4.5 * 50;
        double height = 6 * 50;
        paper.setSize(width, height);
        paper.setImageableArea(10, 10, width - 20, height - 20);
        pageFormat.setPaper(paper);

        job.setPrintable(new pdf_recibo(ciCliente), pageFormat);

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