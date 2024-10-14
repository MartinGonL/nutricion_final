/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import com.mysql.jdbc.PreparedStatement;
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
    
    /*private static Connection connection;
    
    public Conexion() {}
    
    public static Connection getConexion(){
        if(connection == null){
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                
                connection = DriverManager.getConnection ("jdbc:mysql://localhost/nutricionista", "root", "");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion ");
            }
        }
        
        return connection;
    }
    */
     private static Connection coneccion;
        public Conexion() {
        try 
        {
            Class.forName("org.mariadb.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers.");
        }
    }
    
    public void conectar() {
        try 
        {   
            coneccion = DriverManager.getConnection("jdbc:mysql://localhost/nutricionista", "root", "");
            JOptionPane.showMessageDialog(null, "Conexion Exitosa.");
        }
        catch (SQLException ex) 
        {    
            JOptionPane.showInternalMessageDialog(null, "Error al establecer la Coneccion.");
        }
    }

    PreparedStatement prepareStatement(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
