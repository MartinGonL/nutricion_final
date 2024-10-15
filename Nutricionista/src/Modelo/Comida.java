package Modelo;

import java.util.Objects;

public class Comida {
    
    private Integer id_comida;
    private String nombre;
    private String detalle;
    private Double cantCalorias;

    public Comida(String nombre, String detalle, Double cantCalorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
    }

    public Comida() {
    }

    public Integer getId_comida() {
        return id_comida;
    }

    public void setId_comida(Integer id_comida) {
        this.id_comida = id_comida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(Double cantCalorias) {
        this.cantCalorias = cantCalorias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id_comida);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.detalle);
        hash = 17 * hash + Objects.hashCode(this.cantCalorias);
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
        final Comida other = (Comida) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.detalle, other.detalle)) {
            return false;
        }
        if (!Objects.equals(this.id_comida, other.id_comida)) {
            return false;
        }
        return Objects.equals(this.cantCalorias, other.cantCalorias);
    }

    @Override
    public String toString() {
        return "Comida{" + "id_comida=" + id_comida + ", nombre=" + nombre + ", detalle=" + detalle + ", cantCalorias=" + cantCalorias + '}';
    }
}
