package contoller.juegoCartas.objetos;

import lombok.Getter;
import lombok.Setter;
import sonido.SonidosCartas;
import view.juegoCartas.CardsGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CartasSelector extends Entity {
    public boolean flip;

    CardsGame cg;
    BufferedImage granero;
    @Getter
    @Setter
    String animal;

    @Setter
    int sonidoAnimal;

    public CartasSelector(CardsGame cg) {
        this.cg = cg;

        this.width = cg.getWidth() / 8;
        this.height = cg.getHeight() / 3;

        try {
            this.granero = ImageIO.read(CardsGame.class.getResource("granero.png"));
        } catch (IOException e) {
        }

        this.flip = false;

    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(x, y, width, height);

        g2.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            g2.drawRect(x - i, y - i, width + 2 * i, height + 2 * i);
        }

        if (flip) {
            g2.drawImage(img, x, y, width, height, null);
        } else {
            g2.drawImage(granero, x, y, width, height, null);
        }
    }

    public boolean getArea(int mouseX, int mouseY) {
        boolean minX = x <= mouseX;
        boolean maxX = (x + width) >= mouseX;
        boolean minY = y <= mouseY;
        boolean maxY = (y + height) >= mouseY;

        boolean inX = minX && maxX;
        boolean inY = minY && maxY;

        return inX && inY;
    }


    public void soundEffect(SonidosCartas sonidos) {
        try {
            Thread.sleep(500);
            sonidos.setFile(sonidoAnimal);
            sonidos.play();
        } catch (InterruptedException e) {
        }
    }


}
