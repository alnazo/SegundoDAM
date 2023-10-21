package contoller;

import main.App;
import model.Profesor;
import persistence.managerDDBB.ProfesorDAO;
import view.profesor.InformacionProfesor;

import javax.swing.*;
import java.util.List;

public class LoginController {

    public static void login(String mail, String pass){
        List<Profesor> profesores = ProfesorDAO.read();

        Profesor getProf = ProfesorDAO.getProfesor(mail, pass);

        if(profesores.contains(getProf) && getProf != null){
            new InformacionProfesor(getProf);
        } else {
            JOptionPane.showMessageDialog(App.frame, "Usuario o contraseña erroneas.");
        }

    }

}
