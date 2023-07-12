package edu.unam.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Expediente {
    public long id;
    public String nota;
    public LocalDate fechaIngreso;
    public String estado;
    public Persona iniciante;
    public ArrayList<Persona> involucrados = new ArrayList<>();
    public ArrayList<Accion> acciones = new ArrayList<>();

    public Expediente(String nota,LocalDate fechaIngreso,Persona iniciante) {
        this.nota = nota;
        this.fechaIngreso = fechaIngreso;
        this.iniciante = iniciante;
    }

    public long getId() {
        return id;
    }

    public String getNota() {
        return nota;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Persona getIniciante() {
        return iniciante;
    }

    public ArrayList<Persona> getInvolucrados() {
        return involucrados;
    }

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setIniciante(Persona iniciante) {
        this.iniciante = iniciante;
    }
}
