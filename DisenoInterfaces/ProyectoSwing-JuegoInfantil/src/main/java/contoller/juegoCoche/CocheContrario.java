package contoller.juegoCoche;

import view.juegoCoche.CarGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CocheContrario extends Entity {

    CarGame cg;
    String coche;
    int posX, segs;
    public boolean active;

    public CocheContrario(CarGame cg, String coche, int width, int height, int posX) {
        this.cg = cg;
        this.coche = coche;
        this.width = width;
        this.height = height;
        this.posX = posX;

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = this.width - 10;
        solidArea.height = this.height - 10;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = posX;
        y = -height;
        speed = 2;
        active = false;

        try {
            img = ImageIO.read(CarGame.class.getResource(coche));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (active) {
            y += speed;

            if (y >= 800) {
                active = false;
                y = -height;
                cg.puntuacion += 50;
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (active) {
            g2.drawImage(img, x, y, width, height, null);
        }
    }

    public void setSegs(int segs) {
        this.segs = segs;

        switch (this.segs) {
            //AccelerationSystem
            case 20:
                speed += 3;
                break;
            case 40:
            case 60:
                speed += 5;
                break;
            case 80:
            case 100:
                speed += 10;
                break;

            //AccelerationSound
            case 19:
            case 39:
            case 59:
            case 79:
            case 99:
                cg.playSE(2);
                break;
        }
    }

}
