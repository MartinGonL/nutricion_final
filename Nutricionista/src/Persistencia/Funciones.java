package Persistencia;

import java.awt.Component;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Funciones {
    
    /**
     * @param panel
     * @return TreeMap con los param. necesarios para generar una sentencia SQL.
     */
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
}
