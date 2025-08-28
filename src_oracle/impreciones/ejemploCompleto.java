/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impreciones;
//EJEMPLO AJUSTANDO EL TAMAÑO DE HOJA, TIPO DE LETRA, NUMERO DE PAGINAS
//IMPRIMIR DATOS DE UN ARREGLO

import java.awt.*;
import java.awt.print.*;

public class ejemploCompleto implements Printable 
{
    private String[] data;

    public ejemploCompleto(String[] data) 
    {
        this.data = data;
    }

    public static void main(String[] args) 
    {
        // Datos de ejemplo en el arreglo
        String[] datos = {
            "Línea 1: Hola Mundo",
            "Línea 2: Ejemplo de impresión",
            "Línea 3: Cambiando configuraciones",
            "Línea 4: Número de copias, fuente, y más"
        };

        // Crear un trabajo de impresión
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new ejemploCompleto(datos)); //Se esta llamando al constructor y se enviar el vector datos 

        // Configurar el formato de página
        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        
        // Configurar tamaño de hoja (por ejemplo, A5)
        double width = 595.0;  // Ancho en puntos (1 punto = 1/72 de pulgada)
        double height = 842.0; // Alto en puntos (A5 es aproximadamente 595x842 puntos)
        paper.setSize(width, height);
        paper.setImageableArea(50, 50, width - 100, height - 100); // Márgenes
        
        pf.setPaper(paper);
        pf.setOrientation(PageFormat.PORTRAIT); // Orientación vertical

        // Establecer el formato de página en el trabajo de impresión
        job.setCopies(2); // Configurar el número de copias a 2
        job.setPrintable(new ejemploCompleto(datos), pf);

        // Mostrar el cuadro de diálogo de impresión
        if (job.printDialog()) 
        {
            try 
            {
                job.print(); // Enviar el trabajo a la impresora
            } 
            catch (PrinterException e) 
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) 
    {
        if (pageIndex > 0) { // Solo imprimir una página
            return NO_SUCH_PAGE;
        }

        // Obtener el contexto gráfico y configurar la fuente
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        // Moverse al área de impresión
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        // Imprimir cada línea del arreglo
        int yPosition = 100;
        for(int i=0; i<=3; i++)
        {
            g2d.drawString(data[i], 100, yPosition);
            yPosition += 20; // Espacio entre líneas
        }

        return PAGE_EXISTS;
    }
}

