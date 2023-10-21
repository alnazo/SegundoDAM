package main;

import view.BaseView;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class App {
    public static JFrame frame = new JFrame();
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Locale.setDefault(new Locale("es", "ES"));

            frame.setTitle("Inicio");
            frame.setSize(800,600);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(BaseView.content());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
