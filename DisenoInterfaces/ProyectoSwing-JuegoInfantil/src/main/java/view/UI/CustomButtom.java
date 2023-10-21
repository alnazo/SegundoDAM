package view.UI;

import javax.swing.*;
import java.awt.*;

public class CustomButtom extends JButton {

    public CustomButtom(Color color, Dimension dim, String pathImg, String altName) {
        setBackground(color);
        setPreferredSize(dim);

        if (pathImg != null){
            setIcon(new ImageIcon("src/main/resources/"+pathImg));
        } else {
            setText(altName);
        }
    }

}