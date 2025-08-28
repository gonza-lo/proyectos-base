/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trans_norte_potosi_mysql;
import java.sql.*;
import conexion.conectar;

/**
 *
 * @author Usuario
 */
public class acceso {
    public boolean iniciarSecion(String nom, String pas){
        String consulta= "SELECT * FROM usuarios WHERE username= ? AND password = ? ";
        try
        {
            conectar conexion= new conectar();
            PreparedStatement stmt = conexion.optenerConexion().prepareStatement(consulta);
            stmt.setString(1, nom);
            stmt.setString(2, pas);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
