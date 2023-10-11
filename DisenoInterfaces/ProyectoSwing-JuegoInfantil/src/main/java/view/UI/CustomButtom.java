package view.UI;

import javax.swing.*;
import java.awt.*;

public class CustomButtom extends JButton {

    public CustomButtom(int colorR, int colorG, int colorB, int sizeX, int sizeY, String pathImg, String altName) {
        setBackground(new Color(colorR, colorG, colorB));
        setPreferredSize(new Dimension(sizeX, sizeY));

        if (pathImg != null){
            setIcon(new ImageIcon("src/main/resources/"+pathImg));
        } else {
            setText(altName);
        }
    }

}