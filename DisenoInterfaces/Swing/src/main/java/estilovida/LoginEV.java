package estilovida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginEV extends JDialog {

    private JPanel loginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel userLoginField;
    private JPanel passLoginField;
    private JButton sendLoginButton;
    private JButton closeWindowButton;

    public LoginEV (Frame parent, boolean modal){
        super(parent, modal);
        setTitle("Login");
        setSize(500, 300);
        setContentPane(loginPanel);
        setResizable(false);
        closeWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

}
