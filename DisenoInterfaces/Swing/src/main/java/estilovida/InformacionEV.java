package estilovida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformacionEV extends JDialog {

    private JPanel informationPanel;
    private JPanel titlePanel;
    private JPanel inforPanel;
    private JButton closeWindowButton;
    private JPanel closePanel;

    public InformacionEV(JFrame parent, boolean modal){
        super(parent, modal);
        setTitle("Sobre la empresa");
        setSize(500, 300);
        setContentPane(informationPanel);
        setResizable(false);
        closeWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



    }

}
