package edu.unam.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reunion {
    public LocalDate fecha;
    public ArrayList<Expediente> minuta = new ArrayList<>();
    public ArrayList<Persona> asistencias = new ArrayList<>();

    public Reunion(LocalDate fecha) {
        this.fecha = fecha;
    }
    public boolean hasPeople(){
        return !asistencias.isEmpty();
    }
}