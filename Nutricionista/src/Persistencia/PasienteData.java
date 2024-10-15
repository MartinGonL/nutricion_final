package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

public class PasienteData {

    private static Connection conexion;
    private static PreparedStatement sentencia;
    private static ResultSet resultado;

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
            sentencia = conexion.prepareStatement(SQL);
            
            int filas = sentencia.executeUpdate();
            if (filas > 0) 
            {
                JOptionPane.showInternalMessageDialog(null, "Dato cargado con exito.");
            }
        }
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "Falla en la Sintaxis.");
        }
    }

    public static void buscarDato(String nombreRelacion, TreeMap<String, String> datos) {
        String select = (datos.isEmpty()) ? "SELECT * " : "SELECT ";
        String valor = (datos.isEmpty()) ? "FROM " + nombreRelacion : " FROM " + nombreRelacion + " WHERE ";
        int count = 0;

        if (!datos.isEmpty())
        {
            for (Map.Entry<String, String> dato : datos.entrySet()) 
            {
                select += dato.getKey();
                valor +=  dato;
                
                if ((datos.size() - 1) != count) 
                {
                    select += ", ";
                    valor += " AND ";
                } 
                count++;
            }
        }
        
        String SQL = select + valor;
        
        try {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery(/*sql*/);
            
            while (resultado.next()) {
                System.out.println(resultado.getString("idAlumno"));
                System.out.println(resultado.getString("dni"));
                System.out.println(resultado.getString("apellido"));
                System.out.println(resultado.getString("nombre"));
                System.out.println(resultado.getString("fechaNacimiento"));
                System.out.println(resultado.getString("estado"));
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "Falla en la Sintaxis.");
        }
    }    

    public static void actualizarDato(String nombreRelacion, TreeMap<String, String> datos) {
        String SQL = "UPDATE `" + nombreRelacion + "` SET ";
        /*Configurar en caso de querer hacer una modificacion generalizada.*/
//        String valores = "WHERE ";
        int count = 0;
        
        for (Map.Entry<String, String> dato : datos.entrySet()) 
        {
            try 
            {
//                atributos += dato.getKey() + org;
                if (Integer.parseInt(dato.getValue())*0 == 0) SQL += dato;
            } 
            catch (NumberFormatException ex) 
            {
                SQL += dato.getKey() + "='" + dato.getValue() + "'";
            }
            finally 
            {
                if ((datos.size()-1) != count) SQL += ", ";
                count++;
            }
        }
        
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            
            int filas = sentencia.executeUpdate();
            if (filas > 0) 
            {
                JOptionPane.showInternalMessageDialog(null, "Dato cargado con exito.");
            }
        }
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "Falla en la Sintaxis.");
        }
    }

    public static void eliminarDato(String nombreRelacion, TreeMap<String, String> datos) {
        String SQL = "DELETE FROM `" + nombreRelacion + "` WHERE ";
        int count = 0;
        
        for (Map.Entry<String, String> dato : datos.entrySet()) 
        {
            try 
            {
                if (Integer.parseInt(dato.getValue())*0 == 0) SQL += dato;
            } 
            catch (NumberFormatException ex) 
            {
                SQL += dato.getKey() + "='" + dato.getValue() + "'";
            }
            finally 
            {
                if ((datos.size()-1) != count) SQL += " AND ";
                count++;
            }
        }
        
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            
            int filas = sentencia.executeUpdate();
            if (filas > 0) 
            {
                JOptionPane.showInternalMessageDialog(null, "Dato cargado con exito.");
            }
        }
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "Falla en la Sintaxis.");
        }
    }
}
