package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Dieta {
    
    private Integer idDieta;
    private ArrayList<Alimento> listA = new ArrayList();
    private ArrayList<menuDiario> menu = new ArrayList();
    private LocalDate fechainicial;
    private LocalDate fechaFinal;
    private Paciente paciente;
    private Double pesoInicial;
    private Double pesoFinal;
    private Double totalCalorias;
    private Boolean estado;

    public Dieta(Integer idDieta, LocalDate fechainicial, LocalDate fechaFinal, Paciente paciente, Double pesoInicial, Double pesoFinal, Double totalCalorias, Boolean estado) {
        this.idDieta = idDieta;
        this.fechainicial = fechainicial;
        this.fechaFinal = fechaFinal;
        this.paciente = paciente;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
        this.estado = estado;
    }

    public Dieta() {
    }

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public ArrayList<Alimento> getListA() {
        return listA;
    }

    public void setListA(ArrayList<Alimento> listA) {
        this.listA = listA;
    }

    public ArrayList<menuDiario> getListM() {
        return listM;
    }

    public void setListM(ArrayList<menuDiario> listM) {
        this.listM = listM;
    }



    public LocalDate getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(LocalDate fechainicial) {
        this.fechainicial = fechainicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(Double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public Double getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(Double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.idDieta);
        hash = 13 * hash + Objects.hashCode(this.listA);
        hash = 13 * hash + Objects.hashCode(this.menu);
        hash = 13 * hash + Objects.hashCode(this.fechainicial);
        hash = 13 * hash + Objects.hashCode(this.fechaFinal);
        hash = 13 * hash + Objects.hashCode(this.paciente);
        hash = 13 * hash + Objects.hashCode(this.pesoInicial);
        hash = 13 * hash + Objects.hashCode(this.pesoFinal);
        hash = 13 * hash + Objects.hashCode(this.totalCalorias);
        hash = 13 * hash + Objects.hashCode(this.estado);
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
        if (!Objects.equals(this.idDieta, other.idDieta)) {
            return false;
        }
        if (!Objects.equals(this.listA, other.listA)) {
            return false;
        }
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        if (!Objects.equals(this.fechainicial, other.fechainicial)) {
            return false;
        }
        if (!Objects.equals(this.fechaFinal, other.fechaFinal)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.pesoInicial, other.pesoInicial)) {
            return false;
        }
        if (!Objects.equals(this.pesoFinal, other.pesoFinal)) {
            return false;
        }
        if (!Objects.equals(this.totalCalorias, other.totalCalorias)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    @Override
    public String toString() {
        return "Dieta{" + "idDieta=" + idDieta + ", listA=" + listA + ", menu=" + menu + ", fechainicial=" + fechainicial + ", fechaFinal=" + fechaFinal + ", paciente=" + paciente + ", pesoInicial=" + pesoInicial + ", pesoFinal=" + pesoFinal + ", totalCalorias=" + totalCalorias + ", estado=" + estado + '}';
    }
    
    
    
}