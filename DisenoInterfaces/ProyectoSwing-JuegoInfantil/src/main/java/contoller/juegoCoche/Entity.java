package contoller.juegoCoche;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int x, y, width, height;
    public int speed;
    public BufferedImage img;
    public Rectangle solidArea;
    public boolean collision = true;
}
