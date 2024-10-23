package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static Connection conect;
    private static Conexion conexion;

    private Conexion() {
        try 
        {
            Class.forName("org.mariadb.jdbc.Driver");
            
            conect = DriverManager.getConnection("jdbc:mysql://localhost/nutricionista", "root", "");
            JOptionPane.showMessageDialog(null, "Conexion Exitosa.");
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers.");
        }
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "Error al establecer la Coneccion.");
        }
    }
    
    public static Connection getConexion (){
        if (conexion == null) {
            conexion = new Conexion();
        }
        
        return conect;
    }
    
    public static void main(String[] args) {
        Conexion.getConexion();
    }
}
