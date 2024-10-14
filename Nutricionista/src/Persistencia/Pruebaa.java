/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package Persistencia;

import com.mysql.jdbc.PreparedStatement;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author IK
 */
/*public class Pruebaa {
     static Conexion b = new Conexion();
             
    private static PreparedStatement sentencia;
    public static void cargarDato(String nombreRelacion, TreeMap<String, String> datos) {
        String atributos = "INSTERT INTO `" + nombreRelacion + "` (";
        String valores = "VALUES (";
        int count = 0;
        
        for (Map.Entry<String, String> dato : datos.entrySet()) 
        {
            String org = ((datos.size()-1) == count) ? ") " : ", ";
            try 
            {
                atributos += dato.getKey() + org;
                if (Integer.parseInt(dato.getValue())*0 == 0) valores += dato.getValue() + org;
            } 
            catch (NumberFormatException ex) 
            {
                valores += "'" + dato.getValue() + "'" + org;
            }
            count++;
        }
        
        String SQL = atributos + valores;
        System.out.println(SQL);
        try 
        {
            sentencia = b.prepareStatement(SQL);
            
            int filas = sentencia.executeUpdate();
            if (filas > 0) 
            {
                JOptionPane.showInternalMessageDialog(null, "Dato cargado con exito.");
            }
        }
       // catch (SQLException ex) 
      //  {
        //    JOptionPane.showInternalMessageDialog(null, "Falla en la Sintaxis.");
        //}
    } // ------------> Probar
}*/
