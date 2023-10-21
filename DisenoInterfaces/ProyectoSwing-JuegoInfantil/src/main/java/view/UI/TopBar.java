package view.UI;

import constants.Colors;
import main.App;
import view.BaseView;
import view.access.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TopBar extends JPanel {

    public TopBar(boolean login){
        super(false);
        setBackground(Colors.GRAY_BAR);
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

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                App.frame.setTitle("Area Profesor");
                App.frame.repaint();
                App.frame.setContentPane(LoginView.content());
            }
        });
        return button;
    }

    private JButton volverButton(){
        JButton button = new JButton();

        button.setText("< Volver");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                App.frame.setTitle("Inicio");
                App.frame.repaint();
                App.frame.setContentPane(BaseView.content());
                App.frame.setVisible(true);
            }
        });

        return button;
    }

}
