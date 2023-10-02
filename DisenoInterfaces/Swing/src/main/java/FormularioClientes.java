import javax.swing.*;

public class FormularioClientes extends JFrame {

    private JPanel formularioCliente;
    private JTextField searchField;
    private JButton searchButton;
    private JPanel header;
    private JPanel searchContent;
    private JPanel infoContent;
    private JPanel body;
    private JLabel headerInformation;
    private JPanel formContent;
    private JPanel bodyActionsContent;
    private JButton button1;
    private JButton button2;
    private JButton lastButton;
    private JButton button4;
    private JButton button5;
    private JButton firstButton;
    private JButton previewButton;
    private JButton nextButton;
    private JPanel cliendIDField;
    private JTextField textField1;
    private JPanel nombreField;
    private JPanel apellidosField;
    private JPanel direccionField;
    private JPanel emailField;
    private JPanel telefonoField;

    public FormularioClientes(){
        setTitle("FormularioCliente");
        setContentPane(formularioCliente);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


}
