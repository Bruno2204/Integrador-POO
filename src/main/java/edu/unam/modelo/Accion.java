package edu.unam.modelo;

import java.time.LocalDate;

public class Accion {
    public String descripcion;
    public LocalDate fecha;

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Accion(String descripcion,LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

}
