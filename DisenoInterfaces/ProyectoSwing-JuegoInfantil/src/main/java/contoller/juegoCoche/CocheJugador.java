package contoller.juegoCoche;

import contoller.events.CarHandlerListener;
import view.juegoCoche.CarGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CocheJugador extends Entity {
    CarGame cg;
    CarHandlerListener chl;

    public CocheJugador(CarGame cg, CarHandlerListener chl) {
        this.cg = cg;
        this.chl = chl;
        this.width = 100;
        this.height = 220;
        this.collision = false;

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = width - 10;
        solidArea.height = height - 10;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 300;
        y = 550;
        speed = 10;

        try {
            img = ImageIO.read(CarGame.class.getResource("car.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        cg.collisionCheck.check(this);

        if (!collision) {
            if (chl.leftPress) {
                if (x >= 210) x -= speed;
            }
            if (chl.rightPress) {
                if (x <= 680) x += speed;
            }
        }

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(img, x, y, width, height, null);
    }

}
