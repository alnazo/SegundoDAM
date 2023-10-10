package view;

import view.UI.TopBar;

import javax.swing.*;
import java.awt.*;

public class BaseView extends JFrame{

    public BaseView(){
        super("Inicio");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(content());
    }

    private JPanel content(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(125, 190, 199));
        panel.setVisible(true);

        panel.setLayout(new BorderLayout());
        panel.add(new TopBar(true), BorderLayout.PAGE_START);


        return panel;
    }


}
