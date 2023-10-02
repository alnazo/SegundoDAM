import estilovida.EstiloVidaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JButton formularioClientesButton;
    private JPanel panel1;
    private JButton calculadoraButton;
    private JButton estiloDeVidaButton;

    public Principal() {
        super("Principal");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        formularioClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioClientes fc = new FormularioClientes();
                fc.setVisible(true);
            }
        });

        calculadoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculadora cal = new Calculadora();
                cal.setVisible(true);
            }
        });

        estiloDeVidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EstiloVidaPrincipal evp = new EstiloVidaPrincipal();
                evp.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new Principal();
    }


}
