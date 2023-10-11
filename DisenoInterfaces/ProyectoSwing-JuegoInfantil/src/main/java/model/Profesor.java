package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    String nombre;
    String apellido;
    Asignaturas[] asignaturas;
}

