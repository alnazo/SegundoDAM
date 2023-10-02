package estilovida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstiloVidaPrincipal extends JFrame {

    private JPanel princip;
    private JButton informacionButton;
    private JButton loginButton;
    private JButton menusButton;
    private JButton datosButton;

    public EstiloVidaPrincipal() {
        super("Estilo de vida");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(princip);
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginEV lev = new LoginEV(new JFrame(), true);
                lev.setVisible(true);
            }
        });

        datosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosEV dev = new DatosEV(new JFrame(), true);
                dev.setVisible(true);
            }
        });

        menusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuEV mev = new MenuEV(new JFrame(), true);
                mev.setVisible(true);
            }
        });

        informacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformacionEV iev = new InformacionEV(new JFrame(), true);
                iev.setVisible(true);
            }
        });

    }

}
