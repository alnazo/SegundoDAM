import dto.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ListadoPersonas extends JFrame {
    private JPanel panelList;
    private JPanel selectorPanel;
    private JPanel infoPanel;
    private JComboBox comboBox1;
    private JButton mostrarButton;
    private JPanel namePanel;
    private JPanel surnamePanel;
    private JPanel agePanel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel ageLabel;
    private Persona select;
    public ListadoPersonas(){
        super("ComboBox");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelList);
        setVisible(true);

        Persona p1 = new Persona("Jorge", "Lopez", 24);
        Persona p2 = new Persona("Marisa", "Muñoz", 29);
        Persona p3 = new Persona("Andres", "Carranza", 20);
        Persona p4 = new Persona("Martin", "Martinez", 32);

        select = p1;

        comboBox1.addItem(p1.getNombre());
        comboBox1.addItem(p2.getNombre());
        comboBox1.addItem(p3.getNombre());
        comboBox1.addItem(p4.getNombre());

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox1.getSelectedIndex();
                switch (index){
                    case 0:
                        select = p1;
                        break;
                    case 1:
                        select = p2;
                        break;
                    case 2:
                        select = p3;
                        break;
                    case 3:
                        select = p4;
                        break;
                }

            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameLabel.setText(select.getNombre());
                surnameLabel.setText(select.getApellidos());
                ageLabel.setText(Integer.toString(select.getEdad()));
            }
        });

    }


    public static void main(String[] args) {
        new ListadoPersonas();
    }




}
