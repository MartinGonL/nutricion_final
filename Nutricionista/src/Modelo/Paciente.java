package Modelo;

import java.util.Objects;

public class Paciente {
    
    private Integer pacienteNro;
    private Integer edad;
    private String nombre;
    private String apellido;
    private Integer altura;
    private Integer pesoBuscado;

    public Paciente(Integer pacienteNro, Integer edad, String nombre, String apellido, Integer altura, Integer pesoBuscado) {
        this.pacienteNro = pacienteNro;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.pesoBuscado = pesoBuscado;
    }

    public Paciente() {
    }

    public Integer getPacienteNro() {
        return pacienteNro;
    }

    public void setPacienteNro(Integer pacienteNro) {
        this.pacienteNro = pacienteNro;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(Integer pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.pacienteNro);
        hash = 41 * hash + Objects.hashCode(this.edad);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.apellido);
        hash = 41 * hash + Objects.hashCode(this.altura);
        hash = 41 * hash + Objects.hashCode(this.pesoBuscado);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.pacienteNro, other.pacienteNro)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        if (!Objects.equals(this.altura, other.altura)) {
            return false;
        }
        return Objects.equals(this.pesoBuscado, other.pesoBuscado);
    }

    @Override
    public String toString() {
        return "Paciente{" + "pacienteNro=" + pacienteNro + ", edad=" + edad + ", nombre=" + nombre + ", apellido=" + apellido + ", altura=" + altura + ", pesoBuscado=" + pesoBuscado + '}';
    }
    

   
}
