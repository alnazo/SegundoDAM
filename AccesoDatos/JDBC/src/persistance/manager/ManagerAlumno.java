package persistance.manager;

import dto.Alumno;

import java.sql.*;
import java.util.*;

public class ManagerAlumno {

    public static void nombreescuela(Connection con, String sql) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString(1) + " // " + rs.getString(2));
        }
    }

    public static List<Alumno> selectAll(Connection con) throws SQLException {
       Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM alumno");

        List<Alumno> alumnos = new ArrayList<>();

        while (rs.next()){
            Alumno alumno = new Alumno(
                    rs.getInt("id_alumno"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("semestre"),
                    rs.getInt("promedio"),
                    rs.getString("escuela")
            );
            alumnos.add(alumno);
        }

        return alumnos;
    }

    public static void insert(Connection con, Alumno alumno) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO alumno (nombre, edad, semestre, promedio, escuela) VALUES (?, ?, ?, ?, ?)");

        stmt.setString(1, alumno.getNombre());
        stmt.setInt(2, alumno.getEdad());
        stmt.setString(3, alumno.getSemestre());
        stmt.setInt(4, alumno.getPromedio());
        stmt.setString(5, alumno.getEscuela());

        stmt.executeUpdate();
    }

    public static void update(Connection con, Alumno alumno) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE alumno SET nombre = ?, edad = ?, semestre = ?, promedio = ?, escuela = ? WHERE id_alumno = ?");

        stmt.setString(1, alumno.getNombre());
        stmt.setInt(2, alumno.getEdad());
        stmt.setString(3, alumno.getSemestre());
        stmt.setInt(4, alumno.getPromedio());
        stmt.setString(5, alumno.getEscuela());
        stmt.setInt(6, alumno.getId_alumno());

        stmt.executeUpdate();
    }

    public static void delete(Connection con, Map<String, String> map) throws SQLException {
        Statement stmt = con.createStatement();

        StringBuilder sql = new StringBuilder("DELETE FROM alumno WHERE ");
        int contador = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (!value.equals("")) {
                contador++;
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value.length() > 0) {
                if (key.equals("edad") || key.equals("promedio")) {
                    sql.append(String.format(key + " = " + value));
                } else {
                    sql.append(String.format(key + " LIKE '%s'", "%" + value + "%"));
                }
                contador--;
            }
            if (contador > 0 && value.length() > 0) {
                sql.append(" AND ");
            }
        }

        stmt.execute(sql.toString());
    }

    public static Set<Alumno> findByOptions (Connection con, Map<String, String> map, Character operator) throws SQLException {
        Statement stmt = con.createStatement();

        StringBuilder sql = new StringBuilder("SELECT * FROM alumno WHERE ");

        int contador = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (!value.equals("")) {
                contador++;
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value.length() > 0) {
                if (key.equals("edad") || key.equals("promedio")) {
                    sql.append(String.format(key + " " + operator + " " + value));
                } else {
                    sql.append(String.format(key + " LIKE '%s'", "%" + value + "%"));
                }
                contador--;
            }
            if (contador > 0 && value.length() > 0) {
                sql.append(" AND ");
            }
        }

        ResultSet rs = stmt.executeQuery(sql.toString());

        Set<Alumno> alumnos = new HashSet<>();
        while (rs.next()) {
            alumnos.add(new Alumno(
                    rs.getInt("id_alumno"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("semestre"),
                    rs.getInt("promedio"),
                    rs.getString("escuela")
            ));
        }

        return alumnos;

    }

}
