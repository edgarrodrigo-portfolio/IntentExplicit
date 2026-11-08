package com.example.intentexplicit;

import java.io.Serializable;

/** Ficha de usuario. Implementa Serializable para poder viajar en los Extras del Intent. */
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String nombre;
    private final String apellidos;
    private final int edad;
    private final boolean matriculado;

    public Persona(String nombre, String apellidos, int edad, boolean matriculado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.matriculado = matriculado;
    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public int getEdad() { return edad; }
    public boolean isMatriculado() { return matriculado; }
}
