
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
            //Class.forName("org.sqlite.JDBC");
            //conexion = DriverManager.getConnection("jdbc:sqlite:" +db );//direcciona a mi base de datos
           
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost/bus_norte_potosi","root","gonzalo123");
            
            //DriverManager.registerDriver(new org.postgresql.Driver());
            //conexion = DriverManager.getConnection ("jdbc:postgresql://localhost//bus_norte_potosi","postgres","gonzalo123");
            
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

    public Connection obtenerConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//final de la classe conectar