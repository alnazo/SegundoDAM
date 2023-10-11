package view.profesor;

import view.UI.TopBar;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {

    public static JPanel content(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(125, 190, 199));




        panel.add(new TopBar(false), BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);


        return panel;
    }


}
