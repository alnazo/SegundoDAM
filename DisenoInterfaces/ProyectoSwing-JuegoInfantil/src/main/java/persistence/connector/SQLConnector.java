package persistence.connector;

import lombok.Getter;
import main.App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnector {
    @Getter
    private Properties prop = new Properties();

    /**
     * Constructor que carga en {@link Properties} el archivo de parametros de la Base de Datos.
     */
    public SQLConnector() {
        try {
            prop.load(App.class.getResource("ddbb/config.properties").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creacion de conexion de la Base de Datos.
     *
     * @return {@link Connection}.
     * @throws ClassNotFoundException Excepción por falta de {@link Class}.
     * @throws SQLException           Excepción por algún tramite en la hora de conectar a la Base de Datos.
     */
    public Connection getSQLConnection() {

        try {

            return DriverManager.getConnection(getURL());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para formar la URL.
     *
     * @return {@link String}.
     */
    private String getURL() {
        //jdbc:sqlite:pathfile
        return new StringBuilder()
                .append(prop.getProperty(SQLConstants.URL_PREFIX))
                .append(App.class.getResource(prop.getProperty(SQLConstants.URL_PATH)).toString().substring(6))
                .toString();
    }


    /**
     * Comprobador mediante la obtención del nombre de la DDBB a la que se conecta para su verificación.
     *
     * @return {@link Boolean}.
     */
    public static boolean testConnect() throws SQLException, ClassNotFoundException {
        SQLConnector connector = new SQLConnector();
        Connection connection = connector.getSQLConnection();
        boolean respuesta = true;

        String cat = connection.getCatalog();

        if (cat == null) {
            respuesta = false;
        }

        connection.close();
        return respuesta;
    }

}
