package view.access;

import constants.Colors;
import contoller.LoginController;
import main.App;
import org.netbeans.validation.api.builtin.stringvalidation.MayusculaValidator;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import view.BaseView;
import view.UI.TopBar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JPanel {

    public static JPanel content(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Colors.BG_COLOR);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        userPanel.setPreferredSize(new Dimension(400,50));
        userPanel.setBackground(Colors.BG_COLOR);

        JPanel passPanel = new JPanel();
        passPanel.setLayout(new BorderLayout());
        passPanel.setPreferredSize(new Dimension(400,50));
        passPanel.setBackground(Colors.BG_COLOR);

        JPanel valPanel = new JPanel();
        valPanel.setLayout(new BorderLayout());
        valPanel.setPreferredSize(new Dimension(400, 100));

        JPanel buttonsPanel = new JPanel();
        GridLayout gl = new GridLayout();
        gl.setHgap(25);
        buttonsPanel.setLayout(gl);
        buttonsPanel.setBackground(Colors.BG_COLOR);

        // Content

        JLabel mailLabel = new JLabel("Correo:");
        JTextField mailField = new JTextField();
        mailField.setToolTipText("Introduzca su usuario");

        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        passField.setToolTipText("Introduzca su contraseña");

        ValidationPanel validationPanel = new ValidationPanel();
        validationPanel.setBackground(Colors.BG_COLOR);

        ValidationGroup vapgrp = validationPanel.getValidationGroup();
        vapgrp.add(mailField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.NO_WHITESPACE, StringValidators.EMAIL_ADDRESS);
        vapgrp.add(passField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.NO_WHITESPACE);

        userPanel.add(mailLabel, BorderLayout.NORTH);
        userPanel.add(mailField, BorderLayout.SOUTH);

        passPanel.add(passLabel, BorderLayout.NORTH);
        passPanel.add(passField, BorderLayout.SOUTH);

        valPanel.add(validationPanel, BorderLayout.CENTER);

        JButton subbmit = new JButton("Acceder");
        subbmit.setEnabled(false);
        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                subbmit.setEnabled(validationPanel.getProblem() == null);
            }
        });

        subbmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String mail = mailField.getText();
                String pass = new String(passField.getPassword());

                LoginController.login(mail, pass);
            }
        });

        JButton register = new JButton("Registrar");
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterView(App.frame);
            }
        });

        JLabel forgottenPass = new JLabel("¿Has olvidado la contraseña?");
        forgottenPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(App.frame, "Contacte con el administrador \n Tlf: 648-336-555"); //Numero de telefono indicado aleatorio
            }
        });

        // Adicion de elementos a la visualización

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        gbc.gridx=0;
        gbc.gridy=0;
        centerPanel.add(userPanel, gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        centerPanel.add(passPanel, gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        centerPanel.add(valPanel, gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        buttonsPanel.add(subbmit);
        buttonsPanel.add(register);
        centerPanel.add(buttonsPanel, gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        centerPanel.add(forgottenPass, gbc);


        panel.add(new TopBar(false), BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }


}
