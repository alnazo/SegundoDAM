import javax.swing.*;

public class Principal extends JFrame {
    private JButton button1;
    private JPanel panel1;

    public Principal(){
        super("Manejo de evento propio");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        button1.addMouseListener(new MiactionListener());

    }

    public static void main(String[] args) {
        new Principal();
    }


}
