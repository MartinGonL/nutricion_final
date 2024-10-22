
package Modelo;

import java.util.ArrayList;
import java.util.Objects;


public class menuDiario {
    private Integer codMenu;
    private Integer dia;
    private ArrayList<RenglonComida> reglon = new ArrayList();
    private Dieta dieta;
    private Double caloriasDelMenu;
    private Boolean estado;

    public menuDiario(Integer codMenu, Integer dia, Dieta dieta, Double caloriasDelMenu, Boolean estado) {
        this.codMenu = codMenu;
        this.dia = dia;
        this.dieta = dieta;
        this.caloriasDelMenu = caloriasDelMenu;
        this.estado = estado;
    }

    public menuDiario() {
    }

    public Integer getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(Integer codMenu) {
        this.codMenu = codMenu;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public ArrayList<RenglonComida> getReglon() {
        return reglon;
    }

    public void setReglon(ArrayList<RenglonComida> reglon) {
        this.reglon = reglon;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Double getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(Double caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.codMenu);
        hash = 41 * hash + Objects.hashCode(this.dia);
        hash = 41 * hash + Objects.hashCode(this.reglon);
        hash = 41 * hash + Objects.hashCode(this.dieta);
        hash = 41 * hash + Objects.hashCode(this.caloriasDelMenu);
        hash = 41 * hash + Objects.hashCode(this.estado);
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
        final menuDiario other = (menuDiario) obj;
        if (!Objects.equals(this.codMenu, other.codMenu)) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.reglon, other.reglon)) {
            return false;
        }
        if (!Objects.equals(this.dieta, other.dieta)) {
            return false;
        }
        if (!Objects.equals(this.caloriasDelMenu, other.caloriasDelMenu)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    @Override
    public String toString() {
        return "menuDiario{" + "codMenu=" + codMenu + ", dia=" + dia + ", reglon=" + reglon + ", dieta=" + dieta + ", caloriasDelMenu=" + caloriasDelMenu + ", estado=" + estado + '}';
    }
    
    
    
}
