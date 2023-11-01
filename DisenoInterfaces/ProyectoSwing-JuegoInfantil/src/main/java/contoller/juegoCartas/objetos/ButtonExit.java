package contoller.juegoCartas.objetos;

import view.juegoCartas.CardsGame;

import java.awt.*;

public class ButtonExit extends Entity {

    CardsGame cg;

    public ButtonExit(CardsGame cg) {
        this.cg = cg;

        this.width = 75;
        this.height = 75;

        setDefultValues();
    }

    public void setDefultValues() {
        this.x = cg.getWidth() - 25;
        this.y = 25;
    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.PLAIN, 24));
        g2.drawString("X", x, y);

    }

    public boolean getArea(int mouseX, int mouseY) {
        boolean minX = x <= mouseX;
        boolean maxX = (x + width) >= mouseX;
        boolean minY = y >= mouseY;
        boolean maxY = (y + height) >= mouseY;

        boolean inX = minX && maxX;
        boolean inY = minY && maxY;

        return inX && inY;
    }

}
