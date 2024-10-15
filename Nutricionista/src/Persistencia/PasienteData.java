package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PasienteData {

    private static Connection conexion;

    public PasienteData() {
        try 
        {
            Class.forName("org.mariadb.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers.");
        }
    }

    public static void conectar() {
        try 
        {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/nutricionista", "root", "");
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
