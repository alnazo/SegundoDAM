package view;

import view.UI.CustomButtom;
import view.UI.TopBar;

import javax.swing.*;
import java.awt.*;

public class BaseView extends JFrame{

    public static JFrame frame;
    public static JPanel panel;

    public BaseView(){
        BaseView.panel = content();
        setTitle("Inicio");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(BaseView.panel);

        setVisible(true);
    }

    public JPanel content() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(125, 190, 199));

        JButton buttonCars = new CustomButtom(255, 132, 132, 150, 150, "view/img/coche.png", "Juego Coche");

        JButton buttonCard =new CustomButtom(187, 255, 133, 150, 150, "view/img/carta.png", "Juego memoria");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        centerPanel.add(buttonCars, gbc);
        centerPanel.add(buttonCard, gbc);


        panel.add(new TopBar(true), BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }


}
