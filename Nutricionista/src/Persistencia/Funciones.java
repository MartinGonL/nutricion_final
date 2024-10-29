package Persistencia;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Funciones {
    private static Connection conexion;
    private static PreparedStatement sentencia;
    
//    public static TreeMap<String, String> parametros(JPanel panel) {
//        TreeMap<String, String> data = new TreeMap();
//
//        for (Component componente : panel.getComponents()) 
//        {
//            if (componente instanceof JTextField txt)
//            {
//                if (!txt.getText().equals("")) data.put(txt.getName(), txt.getText());
//            }
//            if (componente instanceof JPasswordField txp)
//            {
//                if (!(String.valueOf(txp.getPassword())).equals("")) data.put(txp.getName(), String.valueOf(txp.getPassword()));
//            }
//        }
//        
//        return data;
//    }
    
    /**
     * @param jPanel
     * @return true: Campos llenos. // false: Campos vacios.
     */
    public static Boolean checkField(JPanel jPanel) {
        Boolean flag = false;

        for (Component component : jPanel.getComponents()) 
        {
            if (component instanceof JTextField jTextField) 
            {
                flag = !jTextField.getText().equals("");
            }
        }

        return flag;
    }
    
    /**
     * @param jPanel
     * @return numero de campos de texto completados.
     */
    public static int countField(JPanel jPanel) {
        int count = 0;

        for (Component component : jPanel.getComponents()) 
        {
            if (component instanceof JTextField jTextField) 
            {
                if (!jTextField.getText().equals("")) count++;
            }
        }

        return count;
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
    
    /**
     * @param nombreTabla
     * @param nombreID
     * @param valorID 
     */
    public static void eliminarRegistro(String nombreTabla, String nombreID, String valorID) {
        conexion = Conexion.getConexion();
        String SQL = "DELETE FROM " + nombreTabla + " WHERE " + nombreID + "=";
        
        try 
        {
            if (Integer.parseInt(valorID)*0 == 0) 
            {
                SQL += valorID;
            }
        } 
        catch (NumberFormatException ex) 
        {
            SQL += "'" + valorID + "'";
        }
        System.out.println(SQL);
        try
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0)
            {
                JOptionPane.showMessageDialog(null, "Dato Borrado Correctamente! ");
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis ");
        }
    }
}
