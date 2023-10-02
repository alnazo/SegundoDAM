import dto.Alumno;
import persistance.conector.ManagerCon;
import persistance.manager.ManagerAlumno;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Connection con = ManagerCon.getConnection("acdt");

        if (con == null) return;

        try {
            Alumno a1 = new Alumno(1, "Raul", 15, "Primero", 8, "Conalep Ecatepec");
            Alumno a2 = new Alumno(2, "Marco", 18, "Sexto", 10, "Conalep Texcoco");
            Alumno a3 = new Alumno(3, "Andres", 16, "Segundo", 6, "Conalep Chalco");
            Alumno a4 = new Alumno(4, "Fabian", 16, "Primero", 7, "Conalep Texcoco");
            Alumno a5 = new Alumno(5, "Angel", 17, "Tercero", 9, "Conalep Ecatepec");
            Alumno a6 = new Alumno(6, "Mario", 19, "Sexto", 8, "Conalep Chimalhuacan");
            Alumno a7 = new Alumno(7, "Carlos", 17, "Segundo", 7, "Conalep Texcoco");

            ManagerAlumno.insert(con, a1);
            ManagerAlumno.insert(con, a2);
            ManagerAlumno.insert(con, a3);
            ManagerAlumno.insert(con, a4);
            ManagerAlumno.insert(con, a5);
            ManagerAlumno.insert(con, a6);
            ManagerAlumno.insert(con, a7);

            String sqlConsultaNombreEscuela = "SELECT nombre, escuela FROM alumno WHERE edad > 17";
            ManagerAlumno.nombreescuela(con, sqlConsultaNombreEscuela);

            System.out.println("-------------------------------------------------");

            a4.setEdad(20);
            ManagerAlumno.update(con, a4);

            Map<String, String> options2 = new HashMap<String, String>(){
                {
                    put("nombre", "Fabian");
                }

            };
            Alumno alumnoFabian = ManagerAlumno.findByOptions(con, options2, null).iterator().next();

            System.out.println("ID: " + alumnoFabian.getId_alumno());
            System.out.println("Nombre: " + alumnoFabian.getNombre());
            System.out.println("Edad: " + alumnoFabian.getEdad());
            System.out.println("Semestre: " + alumnoFabian.getSemestre());
            System.out.println("Promedio: " + alumnoFabian.getPromedio());
            System.out.println("Escuela: " + alumnoFabian.getEscuela());



            System.out.println("-------------------------------------------------");

            Map<String, String> deletes = new HashMap<String, String>(){
                {
                    put("escuela", "Conalep Texcoco");
                }

            };
            ManagerAlumno.delete(con, deletes);

            List<Alumno> all = ManagerAlumno.selectAll(con);
            for (Alumno alum : all) {
                System.out.println("ID: " + alum.getId_alumno());
                System.out.println("Nombre: " + alum.getNombre());
                System.out.println("Edad: " + alum.getEdad());
                System.out.println("Semestre: " + alum.getSemestre());
                System.out.println("Promedio: " + alum.getPromedio());
                System.out.println("Escuela: " + alum.getEscuela());
                System.out.println("------");
            }


            ManagerCon.closeCon(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
