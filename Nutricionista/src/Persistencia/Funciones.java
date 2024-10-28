package Persistencia;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Funciones {
    private static Connection conexion;
    private static PreparedStatement sentencia;
    private static ResultSet resultado;
    
    public static TreeMap<String, String> parametros(JPanel panel) {
        TreeMap<String, String> data = new TreeMap();

        for (Component componente : panel.getComponents()) 
        {
            if (componente instanceof JTextField txt)
            {
                if (!txt.getText().equals("")) data.put(txt.getName(), txt.getText());
            }
            if (componente instanceof JPasswordField txp)
            {
                if (!(String.valueOf(txp.getPassword())).equals("")) data.put(txp.getName(), String.valueOf(txp.getPassword()));
            }
        }
        
        return data;
    }
    
    /**
     * @param jPanel
     * @return true: Campos llenos. // false: Campos vacios.
     */
    public static Boolean checkField(JPanel jPanel) {
        Boolean flag = false;

        for (Component component : jPanel.getComponents()) {
            if (component instanceof JTextField jTextField) {
                flag = !jTextField.getText().equals("");
            }
        }

        return flag;
    }

    /**
     * Recetear las cajas de texto y los combobox.
     * 
     * @param jPanel 
     */
    public static void cleanField(JPanel jPanel) {
        for (Component component : jPanel.getComponents()) {
            if (component instanceof JTextField txt) {
                txt = (JTextField) component;
                txt.setText("");
            }
            
            if (component instanceof JComboBox box) {
                box = (JComboBox) component;
                box.setSelectedIndex(-1);
            }
        }
    }
    
    private void eliminarRegistro(String nombreTabla,String id, String valorID) {
       conexion = Conexion.getConexion();
       String SQL = "DELETE FROM '" + nombreTabla + "' WHERE " + id + "= '" + valorID + "' ";
        try {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            if(filas > 0){
                JOptionPane.showMessageDialog(null, "Dato Borrado Correctamente! ");
            }
        
                
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la Sintaxis ");
        }
    }  
        private void eliminarRegistro(String nombreTabla,String id, Integer valorID) {
       conexion = Conexion.getConexion();
       String SQL = "DELETE FROM '" + nombreTabla + "' WHERE " + id + "= " + valorID;
        try {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            if(filas > 0){
                JOptionPane.showMessageDialog(null, "Dato Borrado Correctamente! ");
            }
        
                
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la Sintaxis ");
        }
    } 
}
