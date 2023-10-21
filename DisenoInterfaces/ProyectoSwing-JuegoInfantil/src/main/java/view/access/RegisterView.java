package view.access;

import constants.Colors;
import contoller.RegisterController;
import model.Asignaturas;
import org.netbeans.validation.api.builtin.stringvalidation.MayusculaValidator;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class RegisterView extends JDialog {

    public RegisterView(JFrame frame) {
        super(frame, true);
        setTitle("Crear cuenta profesor");
        setResizable(false);
        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Content DIALOG

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(Colors.BG_COLOR);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        namePanel.setPreferredSize(new Dimension(400, 50));
        namePanel.setBackground(Colors.BG_COLOR);

        JPanel surPanel = new JPanel();
        surPanel.setLayout(new BorderLayout());
        surPanel.setPreferredSize(new Dimension(400, 50));
        surPanel.setBackground(Colors.BG_COLOR);

        JPanel mailPanel = new JPanel();
        mailPanel.setLayout(new BorderLayout());
        mailPanel.setPreferredSize(new Dimension(400, 50));
        mailPanel.setBackground(Colors.BG_COLOR);

        JPanel passPanel = new JPanel();
        passPanel.setLayout(new BorderLayout());
        passPanel.setPreferredSize(new Dimension(400, 50));
        passPanel.setBackground(Colors.BG_COLOR);

        JPanel labelCheckPanel = new JPanel();
        labelCheckPanel.setBackground(Colors.BG_COLOR);
        labelCheckPanel.setPreferredSize(new Dimension(400,50));
        JPanel checkPanel = new JPanel();
        checkPanel.setLayout(new GridLayout(2, 2));
        checkPanel.setPreferredSize(new Dimension(400, 100));
        checkPanel.setBackground(Colors.BG_COLOR);

        ValidationPanel validationPanel = new ValidationPanel();
        validationPanel.setBackground(Colors.BG_COLOR);
        validationPanel.setPreferredSize(new Dimension(400, 100));

        //Content

        JLabel nameLabel = new JLabel("Nombre");
        JTextField nameField = new JTextField();
        nameField.setToolTipText("Introduzca su nombre");

        JLabel surLabel = new JLabel("Apellido");
        JTextField surField = new JTextField();
        surField.setToolTipText("Introduzca su apellido");

        JLabel mailLabel = new JLabel("Correo");
        JTextField mailField = new JTextField();
        mailField.setToolTipText("Introduzca su correo");

        JLabel passLabel = new JLabel("Contraseña");
        JPasswordField passField = new JPasswordField();
        passField.setToolTipText("Introduzca su contraseña");

        JLabel asigLabel = new JLabel("Asignaturas");

        JCheckBox cb0 = new JCheckBox();
        cb0.setText(Asignaturas.Informatica.name());
        cb0.setBackground(Colors.BG_COLOR);

        JCheckBox cb1 = new JCheckBox();
        cb1.setText(Asignaturas.Biologia.name());
        cb1.setBackground(Colors.BG_COLOR);

        JCheckBox cb2 = new JCheckBox();
        cb2.setText(Asignaturas.Lenguaje.name());
        cb2.setBackground(Colors.BG_COLOR);

        JCheckBox cb3 = new JCheckBox();
        cb3.setText(Asignaturas.Matematicas.name());
        cb3.setBackground(Colors.BG_COLOR);

        JButton registrar = new JButton("Registrar");
        registrar.setEnabled(false);
        ValidationGroup vapgrp = validationPanel.getValidationGroup();
        vapgrp.add(nameField, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator(), StringValidators.NO_WHITESPACE);
        vapgrp.add(surField, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        vapgrp.add(passField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.NO_WHITESPACE);
        vapgrp.add(mailField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.NO_WHITESPACE, StringValidators.EMAIL_ADDRESS);

        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                registrar.setEnabled(validationPanel.getProblem() == null);
            }
        });

        registrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Asignaturas> asignaturas = new ArrayList<>();
                if (cb0.isSelected()) {
                    asignaturas.add(Asignaturas.valueOf(cb0.getText()));
                }
                if (cb1.isSelected()) {
                    asignaturas.add(Asignaturas.valueOf(cb1.getText()));
                }
                if (cb2.isSelected()) {
                    asignaturas.add(Asignaturas.valueOf(cb2.getText()));
                }
                if (cb3.isSelected()) {
                    asignaturas.add(Asignaturas.valueOf(cb3.getText()));
                }
                String name = nameField.getText();
                String surname = surField.getText();
                String mail = mailField.getText();
                char[] pass = passField.getPassword();
                if (!cb0.isSelected() && !cb1.isSelected() && !cb2.isSelected() && !cb3.isSelected()){
                    JOptionPane.showMessageDialog(frame, "Debe seleccionar la asignatura a impartir.");
                } else {
                    boolean res = RegisterController.addProfesor(name, surname, mail, pass, asignaturas);
                    if (res) {
                        JOptionPane.showMessageDialog(frame, "Cuenta creada correctamente.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Ha existido un error al crear la cuenta.");
                    }
                }
            }
        });

        // Fields a Paneles
        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(nameField, BorderLayout.SOUTH);

        surPanel.add(surLabel, BorderLayout.NORTH);
        surPanel.add(surField, BorderLayout.SOUTH);

        mailPanel.add(mailLabel, BorderLayout.NORTH);
        mailPanel.add(mailField, BorderLayout.SOUTH);

        passPanel.add(passLabel, BorderLayout.NORTH);
        passPanel.add(passField, BorderLayout.SOUTH);

        labelCheckPanel.add(asigLabel, BorderLayout.CENTER);

        checkPanel.add(cb0);
        checkPanel.add(cb1);
        checkPanel.add(cb2);
        checkPanel.add(cb3);

        // Adicion contenido global

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.VERTICAL;
        gc.insets = new Insets(0, 0, 10, 0);
        gc.gridx = 0;

        gc.gridy = 0;
        contentPanel.add(namePanel, gc);

        gc.gridy = 1;
        contentPanel.add(surPanel, gc);

        gc.gridy = 2;
        contentPanel.add(mailPanel, gc);

        gc.gridy = 3;
        contentPanel.add(passPanel, gc);

        gc.gridy = 4;
        contentPanel.add(labelCheckPanel, gc);
        gc.insets.top = 20;
        contentPanel.add(checkPanel, gc);
        gc.insets.top = 0;

        gc.gridy = 5;
        contentPanel.add(registrar, gc);

        gc.gridy = 6;
        contentPanel.add(validationPanel, gc);

        jp.add(contentPanel, BorderLayout.CENTER);

        setContentPane(jp);
        contentPanel.setComponentZOrder(checkPanel, 1);
        setVisible(true);

    }
}
