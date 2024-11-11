package ModeloSQL;

import Persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Objects;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Menu {
    
    private Integer ID_Dieta;
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

    public Menu(String nombre, Float caloriasValorTotal) {
        this.nombre = nombre;
        this.caloriasValorTotal = caloriasValorTotal;
    }
    
    public Menu(String nombre, String nombreIng, Float cantidadIng, String dia, String momentoDelDia, Integer porciones, Float caloriasValorTotal) {
        this.nombre = nombre;
        this.ingredientes.put(nombreIng, cantidadIng);
        this.dia = dia;
        this.momentoDelDia = momentoDelDia;
        this.porciones = porciones;
        this.caloriasValorTotal = caloriasValorTotal;
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
        return "Menu:\nNombre: " + nombre + ".\nIngredientes: " + ingredientes + ".\nDia: " + dia + ".\nomentoDelDia=" + momentoDelDia + ", porciones=" + porciones + ", caloriasValorTotal=" + caloriasValorTotal + '}';
    }
    
    //-----Funciones SQL-----------------------------------------------------------------------------------------------------------------------------------
    
    /*Constructor SQL*/
    public void SQLMenu(String nombreM) {
        String SQL = "INSERT INTO menu(NombreM)" + 
              "VALUES ('" + nombreM + "')";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Menu Agregado.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public ArrayList<Menu> getAll(String nomComida) {
        ArrayList<Menu> menus = new ArrayList();
        
        String SQL = "SELECT * FROM menu WHERE NombreM LIKE '" + nomComida + "%'";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                String name = resultado.getString("NombreM");
                float calorias = resultado.getFloat("valorTotal");
                
                Menu menu = new Menu(name, calorias);
                menus.add(menu);
            }
        } 
        catch (SQLException ex){}
        
        return menus;
    }

    public String getSQLNombre(String nomComida) {
        String SQL = "SELECT nombre FROM menu WHERE NombreM='" + nomComida + "'";
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

    public void setSQLNombre(String nombre, String nomComida) {
        String SQL = "UPDATE menu SET nombre='" + nombre + "' WHERE NombreM='" + nomComida + "'";
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

    public TreeMap<String, Float> getSQLIngredientes(String nomComida) {
        String SQL = "SELECT NombreI, cantidadIng FROM receta WHERE NombreM='" + nomComida + "'";
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

    public void setSQLIngredientes(String nomComida, String nameI, float cantidadI) {
        String SQL = "INSERT INTO receta(NombreM, NombreI, cantidadIng) VALUES ('" + nomComida + "', '" + nameI + "', " + cantidadI + ")";
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

    public String getSQLDia(String nomComida) {
        String SQL = "SELECT dia FROM menu WHERE NombreM='" + nomComida + "'";
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

    public void setSQLDia(String dia, String nomComida) {
        String SQL = "UPDATE menu SET dia='" + dia + "' WHERE NombreM='" + nomComida + "'";
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

    public String getSQLMomentoDelDia(String nomComida) {
        String SQL = "SELECT momentoDelDia FROM menu WHERE NombreM='" + nomComida + "'";
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

    public void setSQLMomentoDelDia(String momentoDelDia, String nomComida) {
        String SQL = "UPDATE menu SET momentoDelDia='" + momentoDelDia + "' WHERE NombreM='" + nomComida + "'";
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

    public Integer getSQLPorciones(String nomComida) {
        String SQL = "SELECT porciones FROM menu WHERE NombreM='" + nomComida + "'";
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

    public void setSQLPorciones(Integer porciones, String nomComida) {
        String SQL = "UPDATE menu SET porciones=" + porciones + " WHERE NombreM='" + nomComida + "'";
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

    private Float getSQLCaloriasValorTotal(String nomComida) {
        String SQL = "SELECT cantidadIng, valorCD100g FROM receta a JOIN ingrediente b ON a.NombreI=b.NombreI WHERE NombreM='" + nomComida + "'";
        caloriasValorTotal = 0F;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) {
                float cantidadIng = resultado.getFloat("cantidadIng");
                float valorCda100 = resultado.getFloat("valorCD100g");
             
                caloriasValorTotal += valorCda100 * cantidadIng / 100;
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return caloriasValorTotal;
    }

    /*Corroborar Calculo*/
    public void setSQLCaloriasValorTotal(String nomComida) {
        getSQLCaloriasValorTotal(nomComida);
        String SQL = "UPDATE menu SET valorTotal=" + caloriasValorTotal + " WHERE NombreM='" + nomComida + "'";
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
    
    public Integer getSQLID_Dieta(String dni) {
        String SQL = "SELECT ID_Dieta FROM dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                ID_Dieta = resultado.getInt("ID_Dieta");
            }
        } 
        catch (SQLException ex) {}
        return ID_Dieta;
    }
    
    public Integer estructurarDieta(int count, String DNI, String name, String day, String timeDay, int portions) {
        getSQLID_Dieta(DNI);
        String SQL = "INSERT INTO colacion(ID_Dieta, NombreM, dia, momentoDelDia, porciones) VALUES (" + ID_Dieta + ", '" + name + "', '" + day + "', '" + timeDay + "', " + portions + ")";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int fila = sentencia.executeUpdate();
            if (fila > 0) 
            {
                JOptionPane.showMessageDialog(null, "Dato establecido.");
                count--;
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        return count;
    }
}
