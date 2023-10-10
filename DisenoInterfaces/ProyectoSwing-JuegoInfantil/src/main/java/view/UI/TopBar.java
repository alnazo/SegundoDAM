package view.UI;

import view.BaseView;
import view.profesor.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        return button;
    }

    private JButton volverButton(){
        JButton button = new JButton();

        button.setText("<- Volver");

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        return button;
    }

}
