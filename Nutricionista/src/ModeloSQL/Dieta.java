package ModeloSQL;

import Persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Dieta {
    
    private Integer ID_Dieta;
    private Integer DNI;
    private Boolean estadoDieta; 
    private String detalle;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Float pesoFinal;
    private Float totalDeCalorias;
    private Paciente paciente;
    private final ArrayList<Menu> dietaDiaria = new ArrayList();

    private final Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    
    public Dieta() {
        this.conexion = Conexion.getConexion();
    }

    public Dieta(Integer ID_Dieta, Integer DNI, boolean estadoDieta, String detalle, LocalDate fechaInicio, LocalDate fechaFin, Float pesoFinal, Float totalDeCalorias) {
        this.ID_Dieta = ID_Dieta;
        this.DNI = DNI;
        this.estadoDieta = estadoDieta;
        this.detalle = detalle;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pesoFinal = pesoFinal;
        this.totalDeCalorias = totalDeCalorias;
        this.conexion = Conexion.getConexion();        
    }

    public Integer getID_Dieta() {
        return ID_Dieta;
    }

    public Integer getDNI() {
        return DNI;
    }

    public Boolean getEstadoDieta() {
        return estadoDieta;
    }
    
    public String getDetalle() {
        return detalle;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
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
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.ID_Dieta);
        hash = 59 * hash + Objects.hashCode(this.DNI);
        hash = 59 * hash + Objects.hashCode(this.estadoDieta);
        hash = 59 * hash + Objects.hashCode(this.detalle);
        hash = 59 * hash + Objects.hashCode(this.fechaInicio);
        hash = 59 * hash + Objects.hashCode(this.fechaFin);
        hash = 59 * hash + Objects.hashCode(this.pesoFinal);
        hash = 59 * hash + Objects.hashCode(this.totalDeCalorias);
        hash = 59 * hash + Objects.hashCode(this.paciente);
        hash = 59 * hash + Objects.hashCode(this.dietaDiaria);
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
        if (!Objects.equals(this.detalle, other.detalle)) {
            return false;
        }
        if (!Objects.equals(this.ID_Dieta, other.ID_Dieta)) {
            return false;
        }
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        if (!Objects.equals(this.estadoDieta, other.estadoDieta)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
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

    @Override
    public String toString() {
        return "Dieta:\nID_Dieta: " + ID_Dieta + ".\nDNI: " + DNI + ".\nEstadoDiet: =" + estadoDieta + ".\nDetalle: " + detalle + ".\nFecha de Inicio: " + fechaInicio + ".\nFecha de Fin: " + fechaFin + ".\nPeso Final: " + pesoFinal + ".\nTotal De Calorias: " + totalDeCalorias + ".\nPaciente: " + paciente + ".\n";
    }
    
    //-----Funciones SQL-----------------------------------------------------------------------------------------------------------------------------------
    
    /*Contructor SQL*/
    public void SQLDieta(Integer DNI, String detalle, LocalDate fechaInicio, LocalDate fechaFin) {
        String SQL = "INSERT INTO dieta(dni, detalle, fechaIni, fechaFin) " + 
                     "VALUES (" + DNI + ", '" + detalle + "', '" + fechaInicio + "', '" + fechaFin + "')";
        System.out.println(SQL);
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            int filas = sentencia.executeUpdate();
            
            if (filas > 0) JOptionPane.showMessageDialog(null, "Dieta Creada.");

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en el cargado de dieta.");
        }
    }

    public ArrayList<Dieta> getAll(String dni) {
        ArrayList<Dieta> dietas = new ArrayList();
        String SQL = "SELECT * FROM dieta WHERE dni LIKE '" + dni + "%'";
        
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                int idDiet = resultado.getInt("ID_Dieta");
                int dni1 = resultado.getInt("dni");
                boolean estado = resultado.getBoolean("estado");
                String det = resultado.getString("detalle");
                LocalDate fI = LocalDate.parse(resultado.getString("fechaIni"));
                LocalDate fF = LocalDate.parse(resultado.getString("fechaFin"));
                float pF = resultado.getFloat("pesoFinal");
                float totCal = resultado.getFloat("totalCalorias");
                
                Dieta dieta = new Dieta(idDiet, dni1, estado, det, fI, fF, pF, totCal);
                dietas.add(dieta);
            }
        } 
        catch (SQLException ex){}
        
        return dietas;
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
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return ID_Dieta;
    }

    // metodo cargado por martin!
    public Boolean getSQLEstadoDieta(String dni) {
        String SQL = "SELECT estado FROM dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                estadoDieta = resultado.getBoolean("estado");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return estadoDieta;         
    }

    //metodo cargado por martin
    public void setSQLEstadoDieta(Boolean estadoDieta, String dni) {
        String SQL = "UPDATE dieta SET estado='" + estadoDieta + "' WHERE dni=" + dni;
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
    
    public String getSQLDetalle(String dni) {
        String SQL = "SELECT detalle FROM dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                detalle = resultado.getString("detalle");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return detalle;
    }

    public void setSQLDetalle(String detalle, String dni) {
        String SQL = "UPDATE dieta SET detalle='" + detalle + "' WHERE dni=" + dni;
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
        String SQL = "SELECT fechaIni FROM dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                fechaInicio = LocalDate.parse(resultado.getString("fechaIni"));
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return fechaInicio;
    }

    public void setSQLFechaInicio(LocalDate fechaInicio, String dni) {
        String SQL = "UPDATE dieta SET fechaIni='" + fechaInicio + "' WHERE dni=" + dni;
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
        String SQL = "SELECT fechaFin FROM dieta WHERE dni=" + dni;
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
        String SQL = "UPDATE dieta SET fechaFin='" + fechaFin + "' WHERE dni=" + dni;
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
        String SQL = "SELECT pesoFinal FROM dieta WHERE dni=" + dni;
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
        String SQL = "UPDATE dieta SET pesoFinal=" + pesoFinal + " WHERE dni=" + dni;
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
        String SQL = "SELECT totalCalorias FROM dieta WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                totalDeCalorias = resultado.getFloat("totalCalorias");
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
        String SQL = "UPDATE dieta " + 
                     "SET totalCalorias=(SELECT valorTotal " + 
                                          "FROM menu " + 
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
    
    //REVISAR ESTO
    public Paciente getSQLPaciente(String dni) {
        String SQL = "SELECT b.dni, b.estado, nombre, apellido, edad, altura, pesoActual, pesoBuscado FROM dieta a JOIN paciente b (ON a.dni=b.dni) WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                int dni1 = resultado.getInt("dni");
                boolean estadoPaciente = resultado.getBoolean("estado");
                String name = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int edad = resultado.getInt("edad");
                float altura = resultado.getFloat("altura");
                float pesoActual = resultado.getFloat("pesoActual");
                float pesoBuscado = resultado.getFloat("pesoBuscado");
                
                paciente = new Paciente(dni1, estadoPaciente, name, apellido, edad, altura, pesoActual, pesoBuscado);
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
        String SQL = "UPDATE dieta " + 
                     "SET dni=(SELECT dni " + 
                              "FROM paciente " + 
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

    /*VER SI ESTE METODO ES NECESARIO*/
    public ArrayList<Menu> getSQLDietaDiaria(String idDieta) {
        String SQL = "SELECT * FROM menu a JOIN receta b (ON a.ID_Menu=b.ID_Menu) WHERE ID_Dieta=" + idDieta;
        dietaDiaria.clear();
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                String name = resultado.getString("nombre");
                String nombreIng = resultado.getString("NombreI");
                float cantidadIng = resultado.getFloat("cantidadI");
                String dia = resultado.getString("dia");
                String momentoDelDia = resultado.getString("momentoDelDia");
                int porciones = resultado.getInt("porciones");
                float caloriasValorTotal = resultado.getFloat("valorTotal");
                
                Menu menu = new Menu(name, nombreIng, cantidadIng, dia, momentoDelDia, porciones, caloriasValorTotal);
                dietaDiaria.add(menu);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
        }
        
        return dietaDiaria;
    }

    public void setSQLDietaDiaria(String dni, String nombreM, String dia, String momentoDelDia) {
        dietaDiaria.clear();
        getSQLID_Dieta(dni);
        getSQLDietaDiaria(ID_Dieta.toString());
       
        if (dietaDiaria.size() < 35) 
        {    
            Menu menu = new Menu();

            menu.SQLMenu(nombreM);
//            menu.SQLMenu(ID_Dieta, nombreM, dia, momentoDelDia);

            setSQLTotalDeCalorias(dni, ID_Dieta.toString());
        }
        else JOptionPane.showMessageDialog(null, "Ya no puede cargar mas comidas.");
    }

    //-----Metodos Solicitados-----------------------------------------------------------------------------------------------------------------------------
    
    /*Controlar este metodo...*/
    public void cargarPesoYfinalizar(float pesoFin, String dni) {
        String fechaActual = LocalDate.now().toString();
        getSQLFechaFin(dni);
        
        if (fechaActual.compareTo(fechaFin.toString()) >= 0) 
        {
            setSQLPesoFinal(pesoFinal, dni);
        }
        else JOptionPane.showMessageDialog(null, "Solo podra cargar su peso final el dia " + fechaFin);
    }
    
    public void imprimirDietaDiaria(String idDieta) {
        getSQLDietaDiaria(idDieta);
        
        for (Menu dieta : dietaDiaria) 
        {
            System.out.println(dieta.toString());
        }
    }

    /*Probar*/
    public ArrayList<Menu> generarDietaDiara(String ingrediente1, String ingrediente2, String ingrediente3, int idDieta) {
        String[] dia = {"Lunes", "Martes", "Miercoles"};
        String[] momentos = {"Desayuno", "Almuerzo", "Snack", "Merienda", "Cena"};
        
        for (int countD = 0; countD < 3; countD++) 
        {
            for (int countM = 0; countM < 5; countM++) 
            {
                String SQL = "SELECT `NombreM`, `NombreI`, `cantidadIng`, `dia`, `momentoDia`, `porciones`, `valorTotal` FROM menu a JOIN receta b ON a.ID_Menu=b.ID_Menu WHERE NombreI='" + ingrediente1 + 
                             "' OR NombreI='" + ingrediente2 + 
                             "' OR NombreI='" + ingrediente3 + 
                             "' AND dia='" + dia[countD] + "' " +
                             "' AND momentoDia='" + momentos[countM] + "'";
                
                try 
                {
                    sentencia = conexion.prepareStatement(SQL);
                    resultado = sentencia.executeQuery();
                    
                    while (resultado.next()) {
                        String nombrem = resultado.getString("NombreM");
                        String nombrei = resultado.getString("NombreI");
                        float canti = resultado.getFloat("cantidadIng");
                        String dia1 = resultado.getString("dia");
                        String momDia = resultado.getString("momentoDia");
                        int porc = resultado.getInt("porciones");
                        float valTot = resultado.getFloat("valorTotal");
                        
                        Menu menu = new Menu(nombrem, nombrei, canti, dia1, momDia, porc, valTot);
                        dietaDiaria.add(menu);
                    }
                } 
                catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Error en la Sintaxis.");
                }
            }
        }
        
        return dietaDiaria;
    }
}
