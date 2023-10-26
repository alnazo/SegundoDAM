package view;

import constants.Colors;
import view.UI.CustomButtom;
import view.UI.TopBar;
import view.juegoCartas.CardsGame;
import view.juegoCoche.CarGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BaseView {
    public static JFrame carGame;

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


        buttonCars.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                carGame = new JFrame("Juego del Coche");
                carGame.setSize(new Dimension(1000, 800));
                carGame.setLocationRelativeTo(null);
                carGame.setResizable(false);
                carGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                CarGame carsPanel = new CarGame();
                carGame.add(carsPanel);
                carGame.setVisible(true);

                carGame.addWindowFocusListener(new WindowAdapter() {
                    @Override
                    public void windowLostFocus(WindowEvent e) {
                        if (carsPanel.seconds > 0){
                            carsPanel.stopMusic();
                            carsPanel.gameCar = null;
                            carsPanel.resetGame();
                        }
                    }
                });

                carsPanel.init();
            }
        });

        JButton buttonCard =new CustomButtom(
                Colors.GREEN_CARDS,
                new Dimension(150, 150),
                "view/img/carta.png",
                "Juego memoria");

        buttonCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CardsGame();
            }
        });

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
