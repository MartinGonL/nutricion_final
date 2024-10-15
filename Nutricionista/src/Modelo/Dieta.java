package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Dieta {
    
    private Integer idDieta;
    private ArrayList<Comida> comidas = new ArrayList();
    private Paciente paciente;
    private Double pesoInicial;
    private Double pesoFinal;
    private LocalDate fechainicial;
    private LocalDate fechaFinal;

    public Dieta(Paciente paciente, Double pesoInicial, Double pesoFinal, LocalDate fechainicial, LocalDate fechaFinal) {
        this.paciente = paciente;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechainicial = fechainicial;
        this.fechaFinal = fechaFinal;
    }

    public Dieta() {
    }

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idDieta);
        hash = 53 * hash + Objects.hashCode(this.comidas);
        hash = 53 * hash + Objects.hashCode(this.paciente);
        hash = 53 * hash + Objects.hashCode(this.pesoInicial);
        hash = 53 * hash + Objects.hashCode(this.pesoFinal);
        hash = 53 * hash + Objects.hashCode(this.fechainicial);
        hash = 53 * hash + Objects.hashCode(this.fechaFinal);
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
        if (!Objects.equals(this.comidas, other.comidas)) {
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
        if (!Objects.equals(this.fechainicial, other.fechainicial)) {
            return false;
        }
        return Objects.equals(this.fechaFinal, other.fechaFinal);
    }

    @Override
    public String toString() {
        return "Dieta{" + "idDieta=" + idDieta + ", comidas=" + comidas + ", paciente=" + paciente + ", pesoInicial=" + pesoInicial + ", pesoFinal=" + pesoFinal + ", fechainicial=" + fechainicial + ", fechaFinal=" + fechaFinal + '}';
    }
}
