package contoller;

import model.Asignaturas;
import model.Profesor;
import persistence.managerDDBB.ProfesorDAO;

import java.util.List;

public class RegisterController {

    public static boolean addProfesor(String name, String surname, String mail, char[] rawpass, List<Asignaturas> asignaturas){
        boolean res;

        Profesor prof = new Profesor(0, name, surname, asignaturas, mail, new String(rawpass));

        res = ProfesorDAO.create(prof);

        return res;
    }

}
