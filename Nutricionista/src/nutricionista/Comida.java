/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista;

/**
 *
 * @author IK
 */
public class Comida {
    private String comida;
    private String detalle;
    private int cantCalorias;
    private int id_comida;

    public Comida() {
    }

    public Comida(String comida, String detalle, int cantCalorias, int id_comida) {
        this.comida = comida;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
        this.id_comida = id_comida;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }

    public int getId_comida() {
        return id_comida;
    }

    public void setId_comida(int id_comida) {
        this.id_comida = id_comida;
    }

    @Override
    public String toString() {
        return "Comida{" + "comida=" + comida + ", detalle=" + detalle + ", cantCalorias=" + cantCalorias + ", id_comida=" + id_comida + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
