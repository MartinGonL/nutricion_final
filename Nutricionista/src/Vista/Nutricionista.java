/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Persistencia.Conexion;
import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author IK
 */
public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             Conexion a = new Conexion();
             a.conectar();
    }
    
}
