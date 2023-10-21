package view.profesor;

import constants.Colors;
import main.App;
import model.Asignaturas;
import model.Profesor;
import persistence.managerDDBB.ProfesorDAO;
import view.BaseView;
import view.UI.TopBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class InformacionProfesor extends JDialog {


    public InformacionProfesor(Profesor prof){
        super(App.frame, prof.getNombre() + " " + prof.getApellido());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(600, 600));
        setContentPane(content(prof, false));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel content(Profesor prof, boolean edit_save){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

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
        checkPanel.setLayout(new GridLayout(Asignaturas.values().length / 2, 2));
        checkPanel.setPreferredSize(new Dimension(400, 100));
        checkPanel.setBackground(Colors.BG_COLOR);

        //Content
        JLabel nameLabel = new JLabel("Nombre");
        JTextField nameField = new JTextField();
        nameField.setText(prof.getNombre());
        nameField.setEnabled(edit_save);

        JLabel surLabel = new JLabel("Apellido");
        JTextField surField = new JTextField();
        surField.setText(prof.getApellido());
        surField.setEnabled(edit_save);

        JLabel mailLabel = new JLabel("Correo");
        JTextField mailField = new JTextField();
        mailField.setText(prof.getCorreo());
        mailField.setEnabled(edit_save);

        JLabel passLabel = new JLabel("Contraseña");
        JPasswordField passField = new JPasswordField();
        passField.setText(prof.getRawPass());
        passField.setEnabled(edit_save);

        JLabel asigLabel = new JLabel("Asignaturas");
        JCheckBox cb0 = new JCheckBox();
        cb0.setText(Asignaturas.Informatica.name());
        cb0.setBackground(Colors.BG_COLOR);
        cb0.setSelected(prof.getAsignaturas().contains(Asignaturas.Informatica));
        cb0.setEnabled(edit_save);

        JCheckBox cb1 = new JCheckBox();
        cb1.setText(Asignaturas.Biologia.name());
        cb1.setBackground(Colors.BG_COLOR);
        cb1.setSelected(prof.getAsignaturas().contains(Asignaturas.Biologia));
        cb1.setEnabled(edit_save);

        JCheckBox cb2 = new JCheckBox();
        cb2.setText(Asignaturas.Lenguaje.name());
        cb2.setBackground(Colors.BG_COLOR);
        cb2.setSelected(prof.getAsignaturas().contains(Asignaturas.Lenguaje));
        cb2.setEnabled(edit_save);

        JCheckBox cb3 = new JCheckBox();
        cb3.setText(Asignaturas.Matematicas.name());
        cb3.setBackground(Colors.BG_COLOR);
        cb3.setSelected(prof.getAsignaturas().contains(Asignaturas.Matematicas));
        cb3.setEnabled(edit_save);

        JButton editar = new JButton("Editar");
        JButton save = new JButton("Guardar");

        editar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InformacionProfesor.this.setContentPane(InformacionProfesor.this.content(prof, true));
                InformacionProfesor.this.setVisible(true);
                InformacionProfesor.this.revalidate();
                InformacionProfesor.this.repaint();

            }
        });

        save.addMouseListener(new MouseAdapter() {
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
                String pass = new String(passField.getPassword());

                Profesor editProf = new Profesor(prof.getId(), name, surname, asignaturas, mail, pass);

                if (prof.equals(editProf)){
                    JOptionPane.showMessageDialog(InformacionProfesor.this, "No se han modificado ningun campo");
                    InformacionProfesor.this.setContentPane(InformacionProfesor.this.content(prof, false));
                    InformacionProfesor.this.repaint();
                    InformacionProfesor.this.revalidate();
                    InformacionProfesor.this.setVisible(true);
                } else {
                    ProfesorDAO.update(editProf);
                    JOptionPane.showMessageDialog(InformacionProfesor.this, "Se ha modificado correctamente");
                    InformacionProfesor.this.setContentPane(InformacionProfesor.this.content(editProf, false));
                    InformacionProfesor.this.repaint();
                    InformacionProfesor.this.revalidate();
                    InformacionProfesor.this.setVisible(true);
                }
            }
        });

        JButton eliminar = new JButton("Borrar");
        eliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = JOptionPane.showConfirmDialog(InformacionProfesor.this, "Esta seguro de querer eliminar su cuenta");
                switch (i){
                    case 0:
                        ProfesorDAO.delete(prof);
                        JOptionPane.showMessageDialog(InformacionProfesor.this, "Cuenta borrada correctamente");
                        InformacionProfesor.this.dispose();
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(InformacionProfesor.this, "Su cuenta continua estando operativa");
                    case 2:
                        break;
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
        checkPanel.add(cb0, BorderLayout.SOUTH);
        checkPanel.add(cb1, BorderLayout.SOUTH);
        checkPanel.add(cb2, BorderLayout.SOUTH);
        checkPanel.add(cb3, BorderLayout.SOUTH);

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
        gc.insets = new Insets(0, 0, 0, 150);
        if (edit_save) {
            contentPanel.add(save, gc);
        } else {
            contentPanel.add(editar, gc);
        }
        gc.insets = new Insets(0, 150, 0, 0);
        contentPanel.add(eliminar, gc);

        panel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setComponentZOrder(checkPanel, 1);
        return panel;
    }

}
