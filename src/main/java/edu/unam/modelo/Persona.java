package edu.unam.modelo;

public class Persona {
    public String nombre;
    public String apellido;
    public String cuil;
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCuil() {
        return cuil;
    }


    public Persona(String nombre, String apellido, String cuil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
    }

}