package ModeloSQL;

import Persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DecimalFormat;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Iterator;
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
    private Double totalDeCalorias;
    private Paciente paciente;
    private final ArrayList<Menu> dietaDiaria = new ArrayList();

    private final Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    
    public Dieta() {
        this.conexion = Conexion.getConexion();
    }

    public Dieta(Integer ID_Dieta, Integer DNI, boolean estadoDieta, String detalle, LocalDate fechaInicio, LocalDate fechaFin, Float pesoFinal, Double totalDeCalorias) {
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

    public Double getTotalDeCalorias() {
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
        catch (SQLException ex) {}
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
                double totCal = resultado.getFloat("totalCalorias");
                
                Dieta dieta = new Dieta(idDiet, dni1, estado, det, fI, fF, pF, totCal);
                dietas.add(dieta);
            }
        } 
        catch (SQLException ex) {}
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
        catch (SQLException ex) {}
        
        return ID_Dieta;
    }

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
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis de get Estado Dieta."); }
        
        return estadoDieta;         
    }

    public void setSQLEstadoDieta(Boolean estadoDieta, String dni) {
        String SQL = "UPDATE dieta SET estado=" + estadoDieta + " WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            sentencia.executeUpdate();
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis de set Estado Dieta."); }
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
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis."); }
        
        return detalle;
    }

    public void setSQLDetalle(String detalle, String dni) {
        String SQL = "UPDATE dieta SET detalle='" + detalle + "' WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            sentencia.executeUpdate();
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis."); }
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
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis."); }
        
        return fechaInicio;
    }

    public void setSQLFechaInicio(LocalDate fechaInicio, String dni) {
        String SQL = "UPDATE dieta SET fechaIni='" + fechaInicio + "' WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            sentencia.executeUpdate();
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis."); }
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
        catch (SQLException ex) {}
        
        return fechaFin;
    }

    public void setSQLFechaFin(LocalDate fechaFin, String dni) {
        String SQL = "UPDATE dieta SET fechaFin='" + fechaFin + "' WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            sentencia.executeUpdate();
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis."); }
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
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis."); }
        
        return pesoFinal;
    }

    public void setSQLPesoFinal(Float pesoFinal, String dni) {
        String SQL = "UPDATE dieta SET pesoFinal=" + pesoFinal + " WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            sentencia.executeUpdate();
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis."); }
    }

    public Double getSQLTotalDeCalorias(String dni) {
        String SQL = "SELECT TRUNCATE(SUM(valorTotal), 2) as valorTotal FROM colacion a JOIN menu b ON a.NombreM=b.NombreM WHERE ID_Dieta=" + getSQLID_Dieta(dni);
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) { totalDeCalorias = Double.valueOf(resultado.getFloat("valorTotal")); }
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis get Calorias Totales."); }
        
        DecimalFormat df = new DecimalFormat("#.##");
        String tdc = df.format(totalDeCalorias).replace(',', '.');
        totalDeCalorias = Double.valueOf(tdc);
        return totalDeCalorias;
    }

    public void setSQLTotalDeCalorias(String dni) {
        String SQL = "UPDATE dieta SET totalCalorias=" + getSQLTotalDeCalorias(dni) + " WHERE dni=" + dni;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            sentencia.executeUpdate();
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis set Calorias Totales."); }
    }
    
    public Paciente getSQLPaciente(String dni) {
        String SQL = "SELECT b.dni, b.estado, nombre, apellido, edad, altura, pesoActual, pesoBuscado FROM dieta a JOIN paciente b ON a.dni=b.dni WHERE a.dni=" + dni;
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
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la Sintaxis getSQLPaciente."); }
        
        return paciente;
    }

    public ArrayList<Menu> getSQLDietaDiaria(String dni) {
        String SQL = "SELECT a.NombreM, dia, momentoDelDia, porciones, valorTotal FROM colacion a JOIN menu b ON a.NombreM=b.NombreM WHERE ID_Dieta=" + getSQLID_Dieta(dni);
        dietaDiaria.clear();
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                String name = resultado.getString("NombreM");
                String dia = resultado.getString("dia");
                String momentoDelDia = resultado.getString("momentoDelDia");
                int porciones = resultado.getInt("porciones");
                float caloriasValorTotal = resultado.getFloat("valorTotal");
                
                Menu menu = new Menu(name, dia, momentoDelDia, porciones, caloriasValorTotal);
                dietaDiaria.add(menu);
            }
        } 
        catch (SQLException ex) {}
        
        return dietaDiaria;
    }

    //-----Metodos Solicitados-----------------------------------------------------------------------------------------------------------------------------
    
    public boolean chequearFecha(String dni) {
        String fechaActual = LocalDate.now().toString();
        boolean confirm = false;
        getSQLFechaFin(dni);
        
        try { if (fechaActual.compareTo(fechaFin.toString()) >= 0) confirm = true; }
        catch (NullPointerException ex) {}
        
        return confirm;
    }
    
    public int generarDietaDiara(String ingrediente, String dni, int count) {
        dietaDiaria.clear();
        String SQL = "SELECT a.NombreM, valorTotal FROM menu a JOIN receta b on a.NombreM=b.NombreM WHERE b.NombreI LIKE '" + ingrediente + "%'";
        float calTotal;
        String name;
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()) 
            {
                name = resultado.getString("NombreM");
                String dia = "";
                String momentoDelDia = "";
                int porciones = 0;
                calTotal = resultado.getFloat("valorTotal");
                
                Menu menu = new Menu(name, dia, momentoDelDia, porciones, calTotal);
                dietaDiaria.add(menu);
            }
        } 
        catch (SQLException ex) { System.out.println("Error en generarDietaDiaria."); }
        
        if (!dietaDiaria.isEmpty()) 
        {
            int countI = (count == 2) ? 1 : 0;
            String momento = "";
            String dia = "";
            for (int v = countI; v < 2; v++) 
            {
                switch (count) {
                    case 0 -> { momento = (v == 0) ? "Desayuno" : "Merienda"; }
                    case 1 -> { momento = (v == 0) ? "Almuerzo" : "Cena"; }
                    case 2 -> { momento = "Snack"; }
                }
                name = ajustarAlObjetivo(dietaDiaria, dni);
                for (int d = 0; d < 3; d++) 
                {
                    switch (d) {
                        case 0 -> { dia = "Lunes"; }
                        case 1 -> { dia = "Miercoles"; }
                        case 2 -> { dia = "Viernes"; }
                    }
                    crearColacion(name, dni, dia, momento);
                }
            }
            count++;
        }
        else JOptionPane.showMessageDialog(null, "Aun no hay comidas que contengan este ingrediente.");
        return count;
    }
    
    private String ajustarAlObjetivo(ArrayList<Menu> menus, String dni) {
        float pesoAct = getSQLPaciente(dni).getPesoActual();
        float pesoBus = getSQLPaciente(dni).getPesoBuscado();
        float calTotal = 0;
        String name = "";
        for (Menu menu : dietaDiaria) 
        {
            if (pesoAct > pesoBus) 
            {
                if (calTotal < menu.getCaloriasValorTotal() | calTotal == 0) 
                {
                    name = menu.getNombre();
                    calTotal = menu.getCaloriasValorTotal();
                }
            }
            else
            {
                if (calTotal > menu.getCaloriasValorTotal()) 
                {
                    name = menu.getNombre();
                    calTotal = menu.getCaloriasValorTotal();
                }
            }
        }
        Iterator<Menu> it = menus.iterator();
        while (it.hasNext()) { if (it.next().getNombre().equals(name) & dietaDiaria.size() > 1) it.remove(); }
        return name;
    }
    
    private void crearColacion(String name, String dni, String dia, String momento) {
        String SQL = "INSERT INTO colacion(ID_Dieta, NombreM, dia, momentoDelDia, porciones) VALUES (" + getSQLID_Dieta(dni) + ", '" + name + "', '" + dia + "', '" + momento + "', 1)";
        System.out.println(SQL);
        try 
        {
            sentencia = conexion.prepareStatement(SQL);
            sentencia.executeUpdate();
        } 
        catch (SQLException ex) { System.out.println("Error en crearColacion."); }
    }
}
