package Vista;

import Persistencia.Conexion;
import java.sql.Connection;

public class Testdeconsola {
    public static void main(String[] args) {
        
        Connection con = Conexion.getConexion();
        
    }
}
