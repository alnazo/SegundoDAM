import javax.swing.*;

public class Calculadora extends JFrame {
    private JPanel calcPanel;
    private JLabel resultadoCalc;
    private JPanel operationsPanel;
    private JPanel numPanel;
    private JButton plusButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton eqButton;
    private JButton ceButton;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton a0Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton decButton;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JPanel resultPanel;
    private JPanel buttonsPanel;


    public Calculadora(){
        setTitle("Calculadora Simple");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(calcPanel);
        setSize(300, 385);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
