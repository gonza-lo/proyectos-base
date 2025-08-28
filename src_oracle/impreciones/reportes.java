
package impreciones;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.conectar;  // Importar tu clase de conexión
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class reportes {

    public static void main(String[] args) {
        // Crear documento
        Document document = new Document();
        try {
            // Ruta de salida del archivo PDF
            String rutaSalida = "d:\\reportes net\\ClientesReporte.pdf"; // Cambiar ruta aquí
            PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));
            document.open();

            // Título del documento
            Paragraph title = new Paragraph("Reporte de Clientes");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Espacio entre título y tabla

            // Usar la conexión existente
            conectar conn = new conectar();  // Instanciar tu clase de conexión
            Connection connection = conn.optenerConexion();  // Obtener la conexión

            // Verificar si la conexión es exitosa
            if (connection != null) {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM Cliente";
                ResultSet resultSet = statement.executeQuery(query);

                // Crear una tabla PDF
                PdfPTable table = new PdfPTable(3); // 3 columnas

                // Encabezados de la tabla
                PdfPCell cell1 = new PdfPCell(new Phrase("ci_cliente"));
                PdfPCell cell2 = new PdfPCell(new Phrase("Nombre"));
                PdfPCell cell3 = new PdfPCell(new Phrase("Apellidos"));

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);

                // Llenar la tabla con los datos
                while (resultSet.next()) {
                    table.addCell(resultSet.getString("ci_cliente"));
                    table.addCell(resultSet.getString("nombre"));
                    table.addCell(resultSet.getString("apellidos"));
                }
                // Agregar la tabla al documento
                document.add(table);
                document.close();

                // Abrir el PDF generado
                File pdfFile = new File(rutaSalida);
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("El sistema no soporta la apertura de archivos.");
                }

                // Cerrar conexión
                conn.desconectar();
            } else {
                System.out.println("Error al conectar con la base de datos.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

