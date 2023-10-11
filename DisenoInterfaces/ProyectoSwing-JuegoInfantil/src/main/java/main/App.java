package main;

import persistence.connector.SQLConnector;
import view.BaseView;

import java.awt.*;
import java.sql.SQLException;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println(SQLConnector.testConnect());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
        EventQueue.invokeLater( () -> {
                Locale.setDefault(new Locale("es", "ES"));
                new BaseView();
        });
        */
    }
}
