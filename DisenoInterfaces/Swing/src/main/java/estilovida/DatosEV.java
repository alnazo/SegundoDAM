package estilovida;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatosEV extends JDialog {
    private JPanel datosPanel;
    private JPanel dPersoPanel;
    private JPanel tabPanel;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;

    private JButton closeWindowButton;
    private JPanel closePanel;
    private JPanel fieldDatesPanel;

    public DatosEV(JFrame parent, boolean modal) {
        super(parent, modal);
        setTitle("Datos personales");
        setSize(800, 600);
        setContentPane(datosPanel);
        setResizable(false);
        closeWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        String[] colums = {"Nombre", "Apellidos", "DNI"};
        String[][] datas = {
                {"Jimena", "Ponce", "12345678A"},
                {"Aine", "Groce", "98765423A"},
                {"Vivaan", "Hanks", "25874169L"},
                {"Briar", "Tabor", "36125487J"},
                {"Elliotte", "Newhouse", "97643155T"}
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setDataVector(datas, colums);
        table1.setModel(model);
    }
}
