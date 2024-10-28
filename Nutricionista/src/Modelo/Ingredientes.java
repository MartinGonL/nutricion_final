/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;


public class Ingredientes {
    private String nombre;
    private float cantidadCaloriasEn100gs;
    
     private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;

    public Ingredientes() {
        this.conexion = Conexion.getConexion();
    }
    
    
    public Ingredientes(String nombre, float cantidadCaloriasEn100gs) {
        this.nombre = nombre;
        this.cantidadCaloriasEn100gs = cantidadCaloriasEn100gs;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCantidadCaloriasEn100gs() {
        return cantidadCaloriasEn100gs;
    }

    public void setCantidadCaloriasEn100gs(float cantidadCaloriasEn100gs) {
        this.cantidadCaloriasEn100gs = cantidadCaloriasEn100gs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Float.floatToIntBits(this.cantidadCaloriasEn100gs);
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
        final Ingredientes other = (Ingredientes) obj;
        if (Float.floatToIntBits(this.cantidadCaloriasEn100gs) != Float.floatToIntBits(other.cantidadCaloriasEn100gs)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ingredientes{");
        sb.append("nombre=").append(nombre);
        sb.append(", cantidadCaloriasEn100gs=").append(cantidadCaloriasEn100gs);
        sb.append('}');
        return sb.toString();
    }
    
    //-----Funciones SQL-----------------------------------------------------------------------------------------------------------------------------------

    /*Constructor SQL*/
    
    public void SQLingrediente (String nombre, float cantidadCaloriasEn100gs){
        String SQL = "INSERT INTO ingrediente(NombreIng, ValorCD100g) " + 
                     "VALUES ('" + nombre + "', " + cantidadCaloriasEn100gs + ")";
        System.out.println(SQL);
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
 public String getSQLNombre(String nombre) {
        String SQL = "SELECT nombre FROM Ingrediente WHERE nombreIng=" + nombre;
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
public float getSQLcantidadCaloriasEn100gs(float cantidadCaloriasEn100gs) {
        String SQL = "SELECT valorCD100g FROM Ingrediente WHERE valorCD100G=" + cantidadCaloriasEn100gs;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                cantidadCaloriasEn100gs = resultado.getFloat("Calorias por porcion");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return cantidadCaloriasEn100gs;
}
        public void setSQLcantidadCaloriasEn100gs(float cantidadCaloriasEn100gs) {
        String SQL = "UPDATE Ingrediente SET valorCD100G='" + cantidadCaloriasEn100gs ;
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


