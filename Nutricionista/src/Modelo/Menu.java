package Modelo;

import java.util.TreeMap;

public class Menu {
    
    private Integer ID_Dieta;
    private String nombre;
    private TreeMap<String, Float> ingredientes = new TreeMap();
    private String dia;
    private String momentoDelDia;
    private Integer porciones;
    private Float caloriasValorTotal;

    public Menu() {
    }

    public Menu(Integer ID_Dieta, String nombre, String nombreIng, Float cantidadIng, String dia, String momentoDelDia, Integer porciones, Float caloriasValorTotal) {
        this.ID_Dieta = ID_Dieta;
        this.nombre = nombre;
        this.ingredientes.put(nombreIng, cantidadIng);
        this.dia = dia;
        this.momentoDelDia = momentoDelDia;
        this.porciones = porciones;
        this.caloriasValorTotal = caloriasValorTotal;
    }
    
}
