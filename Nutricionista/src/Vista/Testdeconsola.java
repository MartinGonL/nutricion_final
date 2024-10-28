package Vista;

import ModeloSQL.Paciente;

public class Testdeconsola {
    public static void main(String[] args) {
        
        Paciente paciente = new Paciente();
        
        paciente.SQLPaciente(87654321, "laura", "amaya", 21, 1.73f, 74F, 68F);
    }
}
