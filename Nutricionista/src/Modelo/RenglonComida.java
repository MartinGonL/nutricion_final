
package Modelo;

import java.util.Objects;

public class RenglonComida {
    private Integer nroRenglon;
    private Alimento alimento;
    private Double cantidadGrs;
    private Double subTotalCalorias;

    public RenglonComida(Integer nroRenglon, Alimento alimento, Double cantidadGrs, Double subTotalCalorias) {
        this.nroRenglon = nroRenglon;
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subTotalCalorias = subTotalCalorias;
    }

    public RenglonComida() {
    }

    public Integer getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(Integer nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Double getCantidadGrs() {
        return cantidadGrs;
    }

    public void setCantidadGrs(Double cantidadGrs) {
        this.cantidadGrs = cantidadGrs;
    }

    public Double getSubTotalCalorias() {
        return subTotalCalorias;
    }

    public void setSubTotalCalorias(Double subTotalCalorias) {
        this.subTotalCalorias = subTotalCalorias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nroRenglon);
        hash = 37 * hash + Objects.hashCode(this.alimento);
        hash = 37 * hash + Objects.hashCode(this.cantidadGrs);
        hash = 37 * hash + Objects.hashCode(this.subTotalCalorias);
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
        final RenglonComida other = (RenglonComida) obj;
        if (!Objects.equals(this.nroRenglon, other.nroRenglon)) {
            return false;
        }
        if (!Objects.equals(this.alimento, other.alimento)) {
            return false;
        }
        if (!Objects.equals(this.cantidadGrs, other.cantidadGrs)) {
            return false;
        }
        return Objects.equals(this.subTotalCalorias, other.subTotalCalorias);
    }

    @Override
    public String toString() {
        return "RenglonComida{" + "nroRenglon=" + nroRenglon + ", alimento=" + alimento + ", cantidadGrs=" + cantidadGrs + ", subTotalCalorias=" + subTotalCalorias + '}';
    }
    
    
}
