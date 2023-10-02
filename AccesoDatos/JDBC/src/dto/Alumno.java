package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Alumno {
    int id_alumno;
    String nombre;
    int edad;
    String semestre;
    int promedio;
    String escuela;

    public Alumno(int id_alumno, String nombre, int edad, String semestre, int promedio, String escuela) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.edad = edad;
        this.semestre = semestre;
        this.promedio = promedio;
        this.escuela = escuela;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSemestre() {
        return semestre;
    }

    public int getPromedio() {
        return promedio;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }


}
