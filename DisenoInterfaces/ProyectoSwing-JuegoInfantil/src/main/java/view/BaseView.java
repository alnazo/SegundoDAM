package view;

import constants.Colors;
import main.App;
import view.UI.CustomButtom;
import view.UI.TopBar;

import javax.swing.*;
import java.awt.*;

public class BaseView {

    public static JPanel content() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Colors.BG_COLOR);


        JButton buttonCars = new CustomButtom(
                Colors.RED_CARS,
                new Dimension(150, 150),
                "view/img/coche.png",
                "Juego Coche");

        JButton buttonCard =new CustomButtom(
                Colors.GREEN_CARDS,
                new Dimension(150, 150),
                "view/img/carta.png",
                "Juego memoria");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10 ,0 ,10);

        gbc.gridx=0;
        gbc.gridy=0;
        centerPanel.add(buttonCars, gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        centerPanel.add(buttonCard, gbc);


        panel.add(new TopBar(true), BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }
}
