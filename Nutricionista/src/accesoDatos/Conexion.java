/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Conexion {
    
    private static Connection connection;
    
    public Conexion() {}
    
    public static Connection getConexion(){
        if(connection == null){
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                
                connection = DriverManager.getConnection ("jdbc:mysql://localhost/test", "root", "");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion ");
            }
        }
        
        return connection;
    }
    
}
