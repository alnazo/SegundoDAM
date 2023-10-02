package persistance.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManagerCon {

    public static Connection getConnection(String bbdd) {

        Connection con = null;

        String url = "jdbc:mysql://localhost:3306/"+ bbdd;

        String user = "root";
        String pass = "Antonio";

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.printf("No se ha podido realizar la conexion");
            e.printStackTrace();
        }
        return con;
    }

    public static void closeCon(Connection con) throws SQLException {
        con.close();
    }

}
