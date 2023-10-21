package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    int id;
    String nombre;
    String apellido;
    List<Asignaturas> asignaturas = new ArrayList<>();
    String correo;
    String rawPass;

    public Profesor(ResultSet res) throws SQLException {
        this.id = res.getInt("id");
        this.nombre = res.getString("nombre");
        this.apellido = res.getString("apellido");

        String[] getasignaturas = res.getString("asignatura").split(",");
        for (String asignatura : getasignaturas) {
            Asignaturas as = Asignaturas.valueOf(asignatura.trim());
            this.asignaturas.add(as);
        }
        this.correo = res.getString("correo");
        this.rawPass = res.getString("rawPass");
    }

}

