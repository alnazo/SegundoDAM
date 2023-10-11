package view.UI;

import contoller.ButtonMouseListener;
import view.profesor.LoginView;

import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {

    public TopBar(boolean login){
        super(false);
        setBackground(new Color(217, 217, 217));
        setVisible(true);
        setLayout(new BorderLayout());
        if (login){
            add(loginButton(), BorderLayout.EAST);
        } else {
            add(volverButton(), BorderLayout.WEST);
        }

    }

    private JButton loginButton(){
        JButton button = new JButton();

        button.setText("Area Profesor");

        button.addMouseListener(new ButtonMouseListener(LoginView.content(), "Area Profesor"));

        return button;
    }

    private JButton volverButton(){
        JButton button = new JButton();

        button.setText("<- Volver");

        //button.addMouseListener(new ButtonMouseListener(new BaseView().content(), "Inicio"));

        return button;
    }

}
