package ModeloSQL;

import Persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Objects;

import javax.swing.JOptionPane;

public class Ingrediente {

    private String nombre;
    private float caloriasCda100g;
    
    private final Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;

    public Ingrediente() {
        this.conexion = Conexion.getConexion();
    }

    public Ingrediente(String nombre, float caloriasCda100g) {
        this.nombre = nombre;
        this.caloriasCda100g = caloriasCda100g;
        this.conexion = Conexion.getConexion();
    }
    
    public String getNombre() {
        return nombre;
    }

    public float getCaloriasCda100g() {
        return caloriasCda100g;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Float.floatToIntBits(this.caloriasCda100g);
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
        final Ingrediente other = (Ingrediente) obj;
        if (Float.floatToIntBits(this.caloriasCda100g) != Float.floatToIntBits(other.caloriasCda100g)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Ingredientes:\nNombre: " + nombre + ".\nCantidad de Calorias (100g): " + caloriasCda100g + ".\n";
    }
    
    //-----Funciones SQL-----------------------------------------------------------------------------------------------------------------------------------

    /*Constructor SQL*/
    public void SQLIngrediente(String nombre, float caloriasCda100g){
        String SQL = "INSERT INTO ingrediente(NombreI, ValorCD100g) " + 
                     "VALUES ('" + nombre + "', " + caloriasCda100g + ")";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Ingrediente Agregado.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }   
    }

    public ArrayList<Ingrediente> getAll(String nom) {
        ArrayList<Ingrediente> ingredientes = new ArrayList();
        
        String SQL = "SELECT * FROM ingrediente WHERE NombreI LIKE '" + nom + "%'";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                String name = resultado.getString("NombreI");
                float calorias = resultado.getFloat("valorCD100g");
                
                Ingrediente ingrediente = new Ingrediente(name, calorias);
                ingredientes.add(ingrediente);
            }
        } 
        catch (SQLException ex){}
        
        return ingredientes;
    }
    
    public String getSQLNombre(String nom) {
        String SQL = "SELECT NombreI FROM Ingrediente WHERE NombreI='" + nom + "'";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                nombre = resultado.getString("NombreI");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return nombre;
    }
    
    public void setSQLNombre(String nombre, String nom) {
        String SQL = "UPDATE ingrediente SET NombreI='" + nombre + "' WHERE NombreI='" + nom + "'";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex){}    
    }
    
    public float getSQLCaloriasCda100g(String nom) {
        String SQL = "SELECT valorCD100g FROM Ingrediente WHERE NombreI='" + nom + "'";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                caloriasCda100g = resultado.getFloat("valorCD100g");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return caloriasCda100g;
    }
    
    public void setSQLCaloriasCda100g(float caloriasCda100g, String nom) {
        String SQL = "UPDATE Ingrediente SET valorCD100G=" + caloriasCda100g + "WHERE NombreI='" + nom + "'";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
        } 
        catch (SQLException ex){}    
    }
}
