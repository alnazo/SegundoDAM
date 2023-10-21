package persistence.managerDDBB;

import model.Profesor;
import persistence.connector.SQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    private final static SQLConnector connector = new SQLConnector();

    public static boolean create(Profesor prof) {
        try {
            boolean res;

            String asignaturas = prof.getAsignaturas().toString();
            String sql = "INSERT INTO profesores (nombre, apellido, asignatura, correo, rawPass) VALUES (?, ?, ?, ?, ?)";

            Connection con = connector.getSQLConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, prof.getNombre());
            stmt.setString(2, prof.getApellido());
            stmt.setString(3, asignaturas.substring(1, asignaturas.length() - 1));
            stmt.setString(4, prof.getCorreo());
            stmt.setString(5, prof.getRawPass());

            res = stmt.executeUpdate() > 0;
            con.close();

            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Profesor> read() {
        List<Profesor> profesores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM profesores";

            Connection con = connector.getSQLConnection();

            Statement stmt = con.createStatement();

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                profesores.add(new Profesor(res));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    public static boolean update(Profesor prof) {
        try {
            boolean res;
            String sql = "UPDATE profesores SET nombre = ? , apellido = ? , asignatura = ? , correo = ? , rawPass = ? WHERE id = ?";

            String arrAsignaturas = prof.getAsignaturas().toString();
            String asignaturas = arrAsignaturas.substring(1, arrAsignaturas.length() - 1);
            Connection con = connector.getSQLConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, prof.getNombre());
            stmt.setString(2, prof.getApellido());
            stmt.setString(3, asignaturas);
            stmt.setString(4, prof.getCorreo());
            stmt.setString(5, prof.getRawPass());
            stmt.setInt(6, prof.getId());

            res = stmt.executeUpdate() > 0;
            con.close();

            return res;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void delete(Profesor prof) {
        try {
            if (prof != null) {
                String sql = "DELETE FROM profesores WHERE id = " + prof.getId();

                Connection con = connector.getSQLConnection();
                Statement stmt = con.createStatement();

                stmt.execute(sql);

                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Profesor getProfesor(String correo, String pass) {
        try {
            String sql = "SELECT * FROM profesores WHERE correo = ? AND rawPass = ?";

            Connection con = connector.getSQLConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, correo);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();

            Profesor prof = null;
            while (rs.next()) {
                prof = new Profesor(rs);
            }

            con.close();

            return prof;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
