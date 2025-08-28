/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexion;
import java.sql.*;
public class conectar 
{
    Connection conexion = null;
    //private String db= "C:\\SQLite_aprendizaje\\sqlite-tools-win-x64-3460100\\bus_norte_potosi.db";
    public conectar() 
    {
        try 
        {
            
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
             conexion = DriverManager.getConnection(url, "bus_norte_potosi", "gonzalo123");
            
            //Class.forName("org.sqlite.JDBC");
            //conexion = DriverManager.getConnection("jdbc:sqlite:" +db );//direcciona a mi base de datos
           
            //DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            //conexion = DriverManager.getConnection ("jdbc:mysql://localhost/unsxx","root","gonzalo123");
            
            //DriverManager.registerDriver(new org.postgresql.Driver());
            //conexion = DriverManager.getConnection ("jdbc:postgresql://localhost/bus_norte_potosi","postgres","gonzalo123");
            
            if (conexion != null) 
                System.out.println("Conexión a base de datos OK\n");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//final del constructor 
     public Connection optenerConexion() {
        return conexion;
    }
    public void desconectar() {
        conexion = null;
    }   
}//final de la classe conectar