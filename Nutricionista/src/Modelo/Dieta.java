/**
 * Esta calse fue adaptada para interactuar con una BDD. Por lo que su principal objetivo es la recuperacion y modificacion de datos.
 * 
 * Los metodos 'cambiarPesoDeseado()' y 'actualizarPesoAct()' fueron descartados devido a la modificacion realizada a los metodos getter y setter.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Dieta {
    
    private Integer ID_Dieta;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Float pesoInicial;
    private Float pesoFinal;
    private Float totalDeCalorias;
    private Paciente paciente;
    private ArrayList<Menu> menus = new ArrayList();

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    
    public Dieta() {
        conectar();
    }
   
    /*Realizo la conexion*/
    private void conectar() {
        try 
        {
            Class.forName("org.mariadb.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Nutricionista", "root", "");
            JOptionPane.showMessageDialog(null, "Conexion Exitosa.");
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers.");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error al establecer la Conexion.");
        }
    }
    
    /*Contructor SQL*/
    public Dieta(String nombre, LocalDate fechaInicio, LocalDate fechaFin, Float pesoInicial, Float pesoFinal, Float totalDeCalorias, Integer DNI) {
        String SQL = "INSERT INTO Dieta(nombre, fechaInicio, fechaFin, pesoInicial, pesoFinal, TotalDeCalorias, DNI) " + 
                     "VALUES ('" + nombre + "', '" + fechaInicio + "', '" + fechaFin + "', " + pesoInicial + ", " + pesoFinal + ", " + totalDeCalorias + ", " + DNI + ")";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Dieta Creada.");

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public Integer getSQLID_Dieta(String dni) {
        String SQL = "SELECT ID_Dieta FROM Dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                nombre = resultado.getString("ID_Dieta");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return ID_Dieta;
    }

    public String getSQLNombre(String dni) {
        String SQL = "SELECT nombre FROM Dieta WHERE dni=" + dni;
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

    public void setSQLNombre(String nombre, String dni) {
        String SQL = "UPDATE Dieta SET nombre='" + nombre + "' WHERE dni=" + dni;
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

    public LocalDate getSQLFechaInicio(String dni) {
        String SQL = "SELECT fechaInicio FROM Dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                fechaInicio = resultado.getDate("fechaInicio");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return fechaInicio;
    }

    public void setSQLFechaInicio(LocalDate fechaInicio, String dni) {
        String SQL = "UPDATE Dieta SET fechaInicio='" + fechaInicio + "' WHERE dni=" + dni;
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

    public LocalDate getSQLFechaFin(String dni) {
        String SQL = "SELECT fechaFin FROM Dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                fechaFin = resultado.getDate("fechaFin");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return fechaFin;
    }

    public void setSQLFechaFin(LocalDate fechaFin, String dni) {
        String SQL = "UPDATE Dieta SET fechaFin='" + fechaFin + "' WHERE dni=" + dni;
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

    public Float getSQLPesoInicial(String dni) {
        String SQL = "SELECT pesoInicial FROM Dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                pesoInicial = resultado.getFloat("pesoInicial");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return pesoInicial;
    }

    public void setSQLPesoInicial(Float pesoInicial, String dni) {
        String SQL = "UPDATE Dieta SET pesoInicial=" + pesoInicial + " WHERE dni=" + dni;
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

    public Float getSQLPesoFinal(String dni) {
        String SQL = "SELECT pesoFinal FROM Dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                pesoFinal = resultado.getFloat("pesoFinal");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return pesoFinal;
    }

    public void setSQLPesoFinal(Float pesoFinal, String dni) {
        String SQL = "UPDATE Dieta SET pesoFinal=" + pesoFinal + " WHERE dni=" + dni;
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

    public Float getSQLTotalDeCalorias(String dni) {
        String SQL = "SELECT totalDeCalorias FROM Dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                totalDeCalorias = resultado.getFloat("totalDeCalorias");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return totalDeCalorias;
    }

    /*Controlar este metodo*/
    public void setSQLTotalDeCalorias(String dni, String idDieta) {
        String SQL = "UPDATE Dieta " + 
                     "SET totalDeCalorias=(SELECT valorTotal " + 
                                          "FROM Dieta a " + 
                                          "JOIN Menu b (ON a.ID_Dieta = b.ID_Dieta) " + 
                                          "WHERE a.ID_Dieta=" + idDieta + ") " + 
                     "WHERE dni=" + dni;
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

    public Paciente getSQLPaciente(String dni) {
        String SQL = "SELECT dni, nombre, apellido, edad, altura, pesoActual, pesoBuscado FROM Dieta a JOIN Paciente b (ON a.dni=b.dni) WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                int DNI = resultado.getInt("dni");
                String name = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int edad = resultado.getInt("edad");
                float altura = resultado.getFloat("altura");
                float pesoActual = resultado.getFloat("pesoActual");
                float pesoBuscado = resultado.getFloat("pesoBuscado");
                
                paciente = new Paciente(DNI, name, apellido, edad, altura, pesoActual, pesoBuscado);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return paciente;
    }

    /*Controlar este metodo*/
    public void setSQLPaciente(String dni, String idDieta) {
        String SQL = "UPDATE Dieta " + 
                     "SET dni=(SELECT dni " + 
                              "FROM Paciente " + 
                              "WHERE dni=" + dni + ") " +  
                     "WHERE ID_Dieta=" + idDieta;
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

    public ArrayList<Menu> getSQLMenus(String idDieta) {
        String SQL = "SELECT * FROM Menu a JOIN Receta b (ON a.NombreM=b.NombreM) WHERE ID_Dieta=" + idDieta;
        menus.clear();
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) 
            {
                int idDieta1 = resultado.getInt("ID_Dieta");
                String name = resultado.getString("nombre");
                String nombreIng = resultado.getString("NombreI");
                float cantidadIng = resultado.getFloat("cantidadI");
                String dia = resultado.getString("dia");
                String momentoDelDia = resultado.getString("momentoDelDia");
                int porciones = resultado.getInt("porciones");
                float caloriasValorTotal = resultado.getFloat("caloriasValorTotal");
                
                Menu menu = new Menu(idDieta1, name, nombreIng, cantidadIng, dia, momentoDelDia, porciones, caloriasValorTotal);
                menus.add(menu);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return menus;
    }

    public void setMenus(Menu menu, String idDieta) {
        //Llamar al contructor SQL de menu.
//        String SQL = "UPDATE Dieta SET pesoFinal=" + pesoFinal + " WHERE ID_Dieta=" + idDieta;
//        try 
//        {
//            sentencia = conexion.prepareStatement(SQL);
//            int filas = sentencia.executeUpdate();
//            
//            if (filas > 0) JOptionPane.showMessageDialog(null, "Modificacion Realizada.");
//        } 
//        catch (SQLException ex) 
//        {
//            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
//        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.ID_Dieta);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.fechaInicio);
        hash = 17 * hash + Objects.hashCode(this.fechaFin);
        hash = 17 * hash + Objects.hashCode(this.pesoInicial);
        hash = 17 * hash + Objects.hashCode(this.pesoFinal);
        hash = 17 * hash + Objects.hashCode(this.totalDeCalorias);
        hash = 17 * hash + Objects.hashCode(this.paciente);
        hash = 17 * hash + Objects.hashCode(this.menus);
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
        final Dieta other = (Dieta) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.ID_Dieta, other.ID_Dieta)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        if (!Objects.equals(this.pesoInicial, other.pesoInicial)) {
            return false;
        }
        if (!Objects.equals(this.pesoFinal, other.pesoFinal)) {
            return false;
        }
        if (!Objects.equals(this.totalDeCalorias, other.totalDeCalorias)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return Objects.equals(this.menus, other.menus);
    }

    @Override
    public String toString() {
        return "Dieta:\nID Dieta: " + ID_Dieta + ".\n Nombre: " + nombre + ".\n Fecha Inicio: " + fechaInicio + ".\n Fecha Fin: " + fechaFin + ".\n Peso Inicial: " + pesoInicial + ".\n Peso Final: " + pesoFinal + ".\n Total De Calorias: " + totalDeCalorias + ".\n Paciente: " + paciente.toString() + ".\n Menus: " + menus + ".\n";
    }
    
    //Metodos Solicitados.
    //--------------------------------------------------------------------------
    
    public void cargarPesoYfinalizar(float pesoFin, String dni) {
        LocalDate fechaActual = LocalDate.now();
        getSQLFechaFin(dni);
        
        if (fechaActual.compareTo(fechaFin) >= 0) {
            
        }
    }
    
    //--------------------------------------------------------------------------
}
