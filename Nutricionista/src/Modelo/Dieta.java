/**
 * Esta calse fue adaptada para interactuar con una BDD. Por lo que su principal objetivo es la recuperacion y modificacion de datos.
 * 
 * El metodo 'addRenglon()' fue descartado devido a la modificacion realizada a los metodos getter y setter.
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
    private final ArrayList<Menu> dietaDiaria = new ArrayList();

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    
    public Dieta() {
        conectar();
    }

    public Integer getID_Dieta() {
        return ID_Dieta;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Float getPesoInicial() {
        return pesoInicial;
    }

    public Float getPesoFinal() {
        return pesoFinal;
    }

    public Float getTotalDeCalorias() {
        return totalDeCalorias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public ArrayList<Menu> getDietaDiaria() {
        return dietaDiaria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ID_Dieta);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.fechaInicio);
        hash = 97 * hash + Objects.hashCode(this.fechaFin);
        hash = 97 * hash + Objects.hashCode(this.pesoInicial);
        hash = 97 * hash + Objects.hashCode(this.pesoFinal);
        hash = 97 * hash + Objects.hashCode(this.totalDeCalorias);
        hash = 97 * hash + Objects.hashCode(this.paciente);
        hash = 97 * hash + Objects.hashCode(this.dietaDiaria);
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
        return Objects.equals(this.dietaDiaria, other.dietaDiaria);
    }
    
    //-----Funciones SQL-----------------------------------------------------------------------------------------------------------------------------------
    
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
    public void SQLDieta(String nombre, LocalDate fechaInicio, LocalDate fechaFin, Float pesoInicial, Float pesoFinal, Integer DNI) {
        String SQL = "INSERT INTO Dieta(nombre, fechaInicio, fechaFin, pesoInicial, pesoFinal, DNI) " + 
                     "VALUES ('" + nombre + "', '" + fechaInicio + "', '" + fechaFin + "', " + pesoInicial + ", " + pesoFinal + ", " + DNI + ")";
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
                ID_Dieta = resultado.getInt("ID_Dieta");
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
                fechaInicio = LocalDate.parse(resultado.getString("fechaInicio"));
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
                fechaFin = LocalDate.parse(resultado.getString("fechaFin"));
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

    /*Hacerlo de uso privado*/
    private void setSQLTotalDeCalorias(String dni, String idDieta) {
        String SQL = "UPDATE Dieta " + 
                     "SET totalDeCalorias=(SELECT caloriasValorTotal " + 
                                          "FROM Menu " + 
                                          "WHERE ID_Dieta=" + idDieta + ") " + 
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

    public ArrayList<Menu> getSQLDietaDiaria(String idDieta) {
        String SQL = "SELECT * FROM Menu a JOIN Receta b (ON a.NombreM=b.NombreM) WHERE ID_Dieta=" + idDieta;
        dietaDiaria.clear();
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                int idDieta1 = resultado.getInt("ID_Dieta");
                int idMenu = resultado.getInt("ID_Menu");
                String name = resultado.getString("nombre");
                String nombreIng = resultado.getString("NombreI");
                float cantidadIng = resultado.getFloat("cantidadI");
                String dia = resultado.getString("dia");
                String momentoDelDia = resultado.getString("momentoDelDia");
                int porciones = resultado.getInt("porciones");
                float caloriasValorTotal = resultado.getFloat("caloriasValorTotal");
                
                Menu menu = new Menu(idDieta1, idMenu, name, nombreIng, cantidadIng, dia, momentoDelDia, porciones, caloriasValorTotal);
                dietaDiaria.add(menu);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return dietaDiaria;
    }

    public void setSQLDietaDiaria(Integer idDieta, String nombre, String dia, String momentoDelDia, Integer porciones, String dni) {
        dietaDiaria.clear();
        getSQLDietaDiaria(idDieta.toString());
       
        if (dietaDiaria.size() < 35) 
        {    
            Menu menu = new Menu();

            menu.SQLMenu(idDieta, nombre, dia, momentoDelDia, porciones);

            setSQLTotalDeCalorias(dni, idDieta.toString());
        }
        else JOptionPane.showMessageDialog(null, "Ya no puede cargar mas comidas.");
    }

    //-----Metodos Solicitados-----------------------------------------------------------------------------------------------------------------------------
    
    public void cargarPesoYfinalizar(float pesoFin, String dni) {
        LocalDate fechaActual = LocalDate.now();
        getSQLFechaFin(dni);
        
        if (fechaActual.compareTo(fechaFin) >= 0) {
            
        }
    }
    
    public void imprimirDietaDiaria(String idDieta) {
        getSQLDietaDiaria(idDieta);
        
        for (Menu dieta : dietaDiaria) 
        {
            System.out.println(dieta.toString());
        }
    }
    
    /*La dieta diaria cubrira de 3 a 7 dias y cada dia tendra 5 comidas. 
      Retornara un objeto del tipo menu para luego poder usar el numero de ID del mismo para poder realizar
      las modificaciones necesarias.*/
    public Menu modificarDietaDiaria(String idDieta, String dia, String comida) {
        getSQLDietaDiaria(idDieta);
        
        Menu menu = new Menu();
//        String diaDieta = "";
//        String comidaDieta = "";
        
        for (Menu dieta : dietaDiaria) 
        {
            String diaDieta = dieta.getSQLDia(dieta.getNombre());
            String comidaDieta = dieta.getSQLMomentoDelDia(dieta.getNombre());
            
            if (diaDieta.equals(dia) & comidaDieta.equals(comida)) menu = dieta;
        }
        
        return menu;
    }
    
    public void armarDietaDiaria(Integer idDieta, String nombre, String dia, String momentoDelDia, Integer porciones, String dni) {
        getSQLDietaDiaria(idDieta.toString());
        
        if (dietaDiaria.size() < 35)
        {
            setSQLDietaDiaria(idDieta, nombre, dia, momentoDelDia, porciones, dni);
        }
        else JOptionPane.showMessageDialog(null, "Ya no puede cargar mas comidas.");
    }
    
    public void generarDietaDiara(String ingrediente1, String ingrediente2, String ingrediente3, String idDieta) {
    }
}
