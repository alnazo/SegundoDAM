package contoller.juegoCoche;

import view.juegoCoche.CarGame;

import java.awt.*;

public class UI {

    CarGame cg;
    Font arial_20;

    public UI(CarGame cg){
        this.cg = cg;
        arial_20 = new Font("Arial", Font.PLAIN, 20);
    }

    public void draw(Graphics2D g2){
        g2.setFont(arial_20);
        g2.setColor(Color.WHITE);
        g2.drawString("Puntuacion: " + cg.puntuacion, 10, 25);
        g2.drawString("Tiempo: " + cg.seconds + "s", 860, 25);
    }

}
