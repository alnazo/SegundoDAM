package estilovida;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEV extends JDialog {
    private JPanel menuPanel;
    private JTable table1;
    private JButton closeWindowButton;

    public MenuEV(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Menú semanal");
        setSize(1400, 125);
        setContentPane(menuPanel);
        setResizable(false);

        closeWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        String[] colums = {"", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        String[][] datas = {
                {"Dia", "Ensalada cesar", "Macarrones carbonada", "Tortilla de espinacas", "Ensalada caprese", "Rape zebozado"},
                {"Noche", "Pisto con huevo frito", "Hamburguesa con patatas", "Chuleta de cerdo glaseada", "Tortilla de patatas", "Tempura de verduras"}
        };

        table1.setModel(new DefaultTableModel(datas, colums));

    }


}
