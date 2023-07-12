package edu.unam;

import edu.unam.modelo.Accion;
import edu.unam.modelo.Expediente;
import edu.unam.modelo.Persona;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // Crear personas
        Persona iniciante1 = new Persona("Juan", "Pérez", "1234567890");
        Persona iniciante2 = new Persona("María", "Gómez", "0987654321");
        Persona persona1 = new Persona("Juan", "Pérez", "1234567890");
        Persona persona2 = new Persona("María", "Gómez", "0987654321");
        Persona persona3 = new Persona("Carlos", "López", "9876543210");
        Persona persona4 = new Persona("Laura", "Rodríguez", "0123456789");
        Persona persona5 = new Persona("Pedro", "Martínez", "4567890123");
        Persona persona6 = new Persona("Ana", "García", "3456789012");
        Persona persona7 = new Persona("Luis", "Fernández", "2345678901");
        Persona persona8 = new Persona("Sofía", "Sánchez", "5678901234");
        Persona persona9 = new Persona("Diego", "Hernández", "8901234567");
        Persona persona10 = new Persona("Valeria", "Torres", "6789012345");

        // Crear acciones
        Accion accion1 = new Accion("Realizar investigación", LocalDate.now());
        Accion accion2 = new Accion("Revisar documentación", LocalDate.now());
        Accion accion3 = new Accion("Revisar control", LocalDate.now());

        // Crear expedientes
        Expediente expediente1 = new Expediente( "Expediente de reclamo", LocalDate.now(), iniciante1);
        expediente1.getAcciones().add(accion1);
        expediente1.getAcciones().add(accion2);
        expediente1.getInvolucrados().add(persona1);
        expediente1.getInvolucrados().add(persona2);
        expediente1.getInvolucrados().add(persona3);
        expediente1.getInvolucrados().add(persona4);
        expediente1.getInvolucrados().add(persona5);
        expediente1.getInvolucrados().add(persona6);
        expediente1.getInvolucrados().add(persona7);
        expediente1.getInvolucrados().add(persona8);
        expediente1.getInvolucrados().add(persona9);
        expediente1.getInvolucrados().add(persona10);



        // Imprimir información de los expedientes
        System.out.println("Expediente 1:");
        System.out.println("ID: " + expediente1.getId());
        System.out.println("Nota: " + expediente1.getNota());
        System.out.println("Fecha de ingreso: " + expediente1.getFechaIngreso());
        System.out.println("Iniciante: " + expediente1.getIniciante().getNombre() + " " + expediente1.getIniciante().getApellido());
        System.out.println("Involucrados: ");
        expediente1.getInvolucrados().forEach((x)->{
            System.out.println("●\t"+ x.nombre + " " + x.apellido);
        });
        System.out.println("Acciones: ");
        expediente1.getAcciones().forEach((x)->{
            System.out.println("●\t"+ x.descripcion + " "+ x.fecha);
        });

        System.out.println();
    }
}
