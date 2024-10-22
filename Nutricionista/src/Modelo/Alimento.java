package Modelo;

import java.util.Objects;

public class Alimento {
    
    private Integer codComida;
    private String nombre;
    private Integer tipoComida;
    private Double caloriasPor100Grs;
    private String detalle;
    private Boolean baja;

    public Alimento(Integer codComida, String nombre, Integer tipoComida, Double caloriasPor100Grs, String detalle, Boolean baja) {
        this.codComida = codComida;
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100Grs = caloriasPor100Grs;
        this.detalle = detalle;
        this.baja = baja;
    }

    public Alimento() {
    }

    public Integer getCodComida() {
        return codComida;
    }

    public void setCodComida(Integer codComida) {
        this.codComida = codComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(Integer tipoComida) {
        this.tipoComida = tipoComida;
    }

    public Double getCaloriasPor100Grs() {
        return caloriasPor100Grs;
    }

    public void setCaloriasPor100Grs(Double caloriasPor100Grs) {
        this.caloriasPor100Grs = caloriasPor100Grs;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Boolean getBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codComida);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.tipoComida);
        hash = 67 * hash + Objects.hashCode(this.caloriasPor100Grs);
        hash = 67 * hash + Objects.hashCode(this.detalle);
        hash = 67 * hash + Objects.hashCode(this.baja);
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
        final Alimento other = (Alimento) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.detalle, other.detalle)) {
            return false;
        }
        if (!Objects.equals(this.codComida, other.codComida)) {
            return false;
        }
        if (!Objects.equals(this.tipoComida, other.tipoComida)) {
            return false;
        }
        if (!Objects.equals(this.caloriasPor100Grs, other.caloriasPor100Grs)) {
            return false;
        }
        return Objects.equals(this.baja, other.baja);
    }

    @Override
    public String toString() {
        return "Alimento{" + "codComida=" + codComida + ", nombre=" + nombre + ", tipoComida=" + tipoComida + ", caloriasPor100Grs=" + caloriasPor100Grs + ", detalle=" + detalle + ", baja=" + baja + '}';
    }
    

   
}
