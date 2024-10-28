package Modelo;

import Persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Objects;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Menu {
    
    private Integer ID_Dieta;
    private Integer ID_Menu;
    private String nombre;
    private final TreeMap<String, Float> ingredientes = new TreeMap();
    private String dia;
    private String momentoDelDia;
    private Integer porciones;
    private Float caloriasValorTotal;

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    
    public Menu() {
        this.conexion = Conexion.getConexion();
    }

    public Menu(Integer ID_Dieta, Integer ID_Menu, String nombre, String nombreIng, Float cantidadIng, String dia, String momentoDelDia, Integer porciones, Float caloriasValorTotal) {
        this.ID_Dieta = ID_Dieta;
        this.ID_Dieta = ID_Menu;
        this.nombre = nombre;
        this.ingredientes.put(nombreIng, cantidadIng);
        this.dia = dia;
        this.momentoDelDia = momentoDelDia;
        this.porciones = porciones;
        this.caloriasValorTotal = caloriasValorTotal;
    }

    public Integer getID_Dieta() {
        return ID_Dieta;
    }

    public Integer getID_Menu() {
        return ID_Menu;
    }

    public String getNombre() {
        return nombre;
    }

    public TreeMap<String, Float> getIngredientes() {
        return ingredientes;
    }

    public String getDia() {
        return dia;
    }

    public String getMomentoDelDia() {
        return momentoDelDia;
    }

    public Integer getPorciones() {
        return porciones;
    }

    public Float getCaloriasValorTotal() {
        return caloriasValorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ID_Dieta);
        hash = 29 * hash + Objects.hashCode(this.ID_Menu);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.ingredientes);
        hash = 29 * hash + Objects.hashCode(this.dia);
        hash = 29 * hash + Objects.hashCode(this.momentoDelDia);
        hash = 29 * hash + Objects.hashCode(this.porciones);
        hash = 29 * hash + Objects.hashCode(this.caloriasValorTotal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.momentoDelDia, other.momentoDelDia)) {
            return false;
        }
        if (!Objects.equals(this.ID_Dieta, other.ID_Dieta)) {
            return false;
        }
        if (!Objects.equals(this.ID_Menu, other.ID_Menu)) {
            return false;
        }
        if (!Objects.equals(this.ingredientes, other.ingredientes)) {
            return false;
        }
        if (!Objects.equals(this.porciones, other.porciones)) {
            return false;
        }
        return Objects.equals(this.caloriasValorTotal, other.caloriasValorTotal);
    }

    @Override
    public String toString() {
        return "Menu:\nID Dieta: " + ID_Dieta + ".\nID Menu: " + ID_Menu + ".\nNombre: " + nombre + ".\nIngredientes: " + ingredientes + ".\nDia: " + dia + ".\nomentoDelDia=" + momentoDelDia + ", porciones=" + porciones + ", caloriasValorTotal=" + caloriasValorTotal + '}';
    }
    
    //-----Funciones SQL-----------------------------------------------------------------------------------------------------------------------------------
    
    /*Constructor SQL*/
    public void SQLMenu(Integer ID_Dieta, String nombre, String dia, String momentoDelDia, Integer porciones) {
        /*1° Se buscan los detalles de la receta, sus componentes y cantidades.*/
        String SQL = "SELECT NombreI, cantidadIng, valorCada100 FROM Receta a JOIN Ingrediente b (ON a.NombreI=b.NombreI) WHERE NombreM='" + nombre + "'";
        float valorCada100 = 0F;
        ingredientes.clear();
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) {
                String nombreIng = resultado.getString("NombreI");
                float cantidadIng = resultado.getFloat("cantidadIng");
                valorCada100 = resultado.getFloat("valorCada100");
             
                ingredientes.put(nombreIng, cantidadIng);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis. (1)");
        }
        
        /*2° Se calcula el valor de calorias total que posee el menu*/
        for (Float value : ingredientes.values()) 
        {
            caloriasValorTotal += valorCada100 * value / 100;
        }
        
        /*3° Finalmente se utilizan los datos recolectados para crear un nuevo menu para el paciente.*/
        SQL = "INSERT INTO Menu(ID_Dieta, NombreM, detalle, dia, momentoDelDia, porciones, caloriasValorTotal)" + 
              "VALUES (" + ID_Dieta + ", '" + nombre + "', '" + ingredientes + "', '" + dia + "', '" + momentoDelDia + "', " + porciones + ", " + caloriasValorTotal + ")";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Menu Agregado.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis. (2)");
        }
    }

    public Integer getSQLID_Dieta(String idMenu) {
        String SQL = "SELECT ID_Dieta FROM Menu WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                ID_Dieta = resultado.getInt("ID_Dieta");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return ID_Dieta;
    }

    public void setSQLID_Dieta(Integer ID_Dieta, String idMenu) {
        String SQL = "UPDATE Menu SET ID_Dieta=" + ID_Dieta + " WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }
    
    public Integer getSQLID_Menu(String idMenu) {
        String SQL = "SELECT ID_Menu FROM Menu WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                ID_Menu = resultado.getInt("ID_Menu");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return ID_Menu;
    }
    
    public String getSQLNombre(String idMenu) {
        String SQL = "SELECT nombre FROM Menu WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                nombre = resultado.getString("nombre");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return nombre;
    }

    public void setSQLNombre(String nombre, String idMenu) {
        String SQL = "UPDATE Menu SET nombre='" + nombre + "' WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public TreeMap<String, Float> getSQLIngredientes(String idMenu) {
        String SQL = "SELECT NombreI, cantidadIng FROM Receta WHERE ID_Menu=" + idMenu;
        ingredientes.clear();
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) {
                String nombreIng = resultado.getString("NombreI");
                float cantidadIng = resultado.getFloat("cantidadIng");
             
                ingredientes.put(nombreIng, cantidadIng);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis. (1)");
        }
        
        return ingredientes;
    }

    public void setSQLIngredientes(String idMenu, String nameI, float cantidadI) {
        String SQL = "INCERT INTO Receta (ID_Menu, NombreI, cantidadIng) VALUES (" + idMenu + ", '" + nameI + "', " + cantidadI + ")";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public String getSQLDia(String idMenu) {
        String SQL = "SELECT dia FROM Menu WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                dia = resultado.getString("dia");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return dia;
    }

    public void setSQLDia(String dia, String idMenu) {
        String SQL = "UPDATE Menu SET dia='" + dia + "' WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public String getSQLMomentoDelDia(String idMenu) {
        String SQL = "SELECT momentoDelDia FROM Menu WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                momentoDelDia = resultado.getString("momentoDelDia");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return momentoDelDia;
    }

    public void setSQLMomentoDelDia(String momentoDelDia, String idMenu) {
        String SQL = "UPDATE Menu SET momentoDelDia='" + momentoDelDia + "' WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public Integer getSQLPorciones(String idMenu) {
        String SQL = "SELECT porciones FROM Menu WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                porciones = resultado.getInt("porciones");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return porciones;
    }

    public void setSQLPorciones(Integer porciones, String idMenu) {
        String SQL = "UPDATE Menu SET porciones=" + porciones + " WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public Float getSQLCaloriasValorTotal(String idMenu) {
        String SQL = "SELECT caloriasValorTotal FROM Menu WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                caloriasValorTotal = resultado.getFloat("caloriasValorTotal");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return caloriasValorTotal;
    }

    public void setSQLCaloriasValorTotal(Float caloriasValorTotal, String idMenu) {
        String SQL = "UPDATE Menu SET caloriasValorTotal=" + caloriasValorTotal + " WHERE ID_Menu=" + idMenu;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }
    
}
