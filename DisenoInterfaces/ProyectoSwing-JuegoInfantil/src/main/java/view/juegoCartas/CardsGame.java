package view.juegoCartas;

import javax.swing.*;
import java.awt.*;

public class CardsGame {
    JFrame jf;
    public CardsGame(){
        jf = new JFrame("Juego de Memoria");
        jf.setSize(new Dimension(1000, 1000));
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);



        jf.setVisible(true);
    }


}
