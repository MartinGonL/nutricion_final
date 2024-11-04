/**
 * Esta calse fue adaptada para interactuar con una BDD. Por lo que su principal objetivo es la recuperacion y modificacion de datos.
 * 
 * Los metodos 'cambiarPesoDeseado()' y 'actualizarPesoAct()' fueron descartados devido a la modificacion realizada a los metodos getter y setter.
 */
package ModeloSQL;

import Persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Paciente {
    
    private Integer DNI;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Float altura;
    private Float pesoActual;
    private Float pesoBuscado;
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;

    public Paciente() {
        this.conexion = Conexion.getConexion();
    }

    public Paciente(Integer DNI, String nombre, String apellido, Integer edad, Float altura, Float pesoActual, Float pesoBuscado) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
    }

    public Integer getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public Float getAltura() {
        return altura;
    }

    public Float getPesoActual() {
        return pesoActual;
    }

    public Float getPesoBuscado() {
        return pesoBuscado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.DNI);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.apellido);
        hash = 41 * hash + Objects.hashCode(this.edad);
        hash = 41 * hash + Objects.hashCode(this.altura);
        hash = 41 * hash + Objects.hashCode(this.pesoActual);
        hash = 41 * hash + Objects.hashCode(this.pesoBuscado);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        if (!Objects.equals(this.altura, other.altura)) {
            return false;
        }
        if (!Objects.equals(this.pesoActual, other.pesoActual)) {
            return false;
        }
        return Objects.equals(this.pesoBuscado, other.pesoBuscado);
    }

    @Override
    public String toString() {
        return "Paciente:\nDNI: " + DNI + ".\nNombre: " + nombre + ".\nApellido: " + apellido + ".Edad: " + edad + ".\nAltura: " + altura + ".\nPeso Actual: " + pesoActual + ".\nPeso Buscado: " + pesoBuscado + ".\n";
    }
    
    //-----Funciones SQL-----------------------------------------------------------------------------------------------------------------------------------

    /*Constructor SQL*/
    public void SQLPaciente(Integer DNI, String nombre, String apellido, Integer edad, Float altura, Float pesoActual, Float pesoBuscado) {
        String SQL = "INSERT INTO paciente(DNI, nombre, apellido, edad, altura, pesoActual, pesoBuscado) " + 
                     "VALUES (" + DNI + ", '" + nombre + "', '" + apellido + "', " + edad + ", " + altura + ", " + pesoActual + ", " + pesoBuscado + ")";
        System.out.println(SQL);
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Paciente Agregado.");

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
    }

    public ArrayList<Paciente> getAll(String dni) {
        ArrayList<Paciente> pacientes = new ArrayList();
        
        String SQL = "SELECT * FROM paciente WHERE dni LIKE '" + dni + "%'";
        System.out.println(SQL);
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                String nom = resultado.getString("nombre");
                String ape = resultado.getString("apellido");
                int dni1 = resultado.getInt("dni");
                int ed = resultado.getInt("edad");
                float alt = resultado.getFloat("altura");
                float pA = resultado.getFloat("pesoActual");
                float pB = resultado.getFloat("pesoBuscado");
                
                Paciente paciente = new Paciente(dni1, nom, ape, ed, alt, pA, pB);
                pacientes.add(paciente);
            }
        } 
        catch (SQLException ex){}
        
        return pacientes;
    }
    
    public String getSQLNombre(String dni) {
        String SQL = "SELECT nombre FROM Paciente WHERE dni=" + dni;
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
        String SQL = "UPDATE Paciente SET nombre='" + nombre + "' WHERE dni=" + dni;
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

    public String getSQLApellido(String dni) {
        String SQL = "SELECT apellido FROM Paciente WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                apellido = resultado.getString("apellido");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return apellido;
    }

    public void setSQLApellido(String apellido, String dni) {
        String SQL = "UPDATE Paciente SET apellido='" + apellido + "' WHERE dni=" + dni;
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

    public Integer getSQLEdad(String dni) {
        String SQL = "SELECT edad FROM Paciente WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                edad = resultado.getInt("edad");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return edad;
    }

    public void setSQLEdad(Integer edad, String dni) {
        String SQL = "UPDATE Paciente SET edad=" + edad + " WHERE dni=" + dni;
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

    public Float getSQLAltura(String dni) {
        String SQL = "SELECT altura FROM Paciente WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                altura = resultado.getFloat("altura");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return altura;
    }

    public void setSQLAltura(Float altura, String dni) {
        String SQL = "UPDATE Paciente SET altura=" + altura + " WHERE dni=" + dni;
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

    public Float getSQLPesoActual(String dni) {
        String SQL = "SELECT pesoActual FROM Paciente WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                pesoActual = resultado.getFloat("pesoActual");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return pesoActual;
    }

    public void setSQLPesoActual(Float pesoActual, String dni) {
        String SQL = "UPDATE Paciente SET pesoActual=" + pesoActual + " WHERE dni=" + dni;
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

    public Float getSQLPesoBuscado(String dni) {
        String SQL = "SELECT pesoBuscado FROM Paciente WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                pesoBuscado = resultado.getFloat("pesoBuscado");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return pesoBuscado;
    }

    public void setSQLPesoBuscado(Float pesoBuscado, String dni) {
        String SQL = "UPDATE Paciente SET pesoBuscado=" + pesoBuscado + " WHERE dni=" + dni;
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

    //-----Metodos Solicitados-----------------------------------------------------------------------------------------------------------------------------
    
    public Float seAcercaAlPeso(String dni, Float pesoAct) {
        Float result = 0F;
        
        String SQL = "SELECT pesoActual, pesoBuscado FROM Paciente WHERE DNI=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                pesoActual = resultado.getFloat("pesoActual");
                pesoBuscado = resultado.getFloat("pesoBuscado");
            }
            
            /*Cheque si el objetivo del cliente es bajar (true) o subir (false) de peso, realizo el calculo respectivo...*/
            result = (pesoActual > pesoBuscado) ? pesoAct - pesoBuscado : pesoBuscado - pesoAct;
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        /*...y retorno lo que le falta al cliente para llegar a su peso deseado.*/
        return result;
    }
    
    public ArrayList<Paciente> llegaronAlPesoDeseado() {
        ArrayList<Paciente> pacientes = new ArrayList();
        
        String SQL = "SELECT DNI, nombre, apellido, edad, altura, pesoActual, pesoBuscado FROM Paciente a JOIN Dieta b (ON a.ID_Dieta=b.ID_Dieta) WHERE a.pesoBuscado=b.pesoFinal";
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                DNI = resultado.getInt("DNI");
                nombre = resultado.getString("nombre");
                apellido = resultado.getString("apellido");
                edad = resultado.getInt("edad");
                altura = resultado.getFloat("altura");
                pesoActual = resultado.getFloat("pesoActual");
                pesoBuscado = resultado.getFloat("pesoBuscado");
                
                Paciente paciente = new Paciente(DNI, nombre, apellido, edad, altura, pesoActual, pesoBuscado);
                
                pacientes.add(paciente);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return pacientes;
    }
}
/**/