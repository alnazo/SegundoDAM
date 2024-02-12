package clienteftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ClienteFTP {

    public static void main(String[] args) throws IOException {
        //Pedimos al usuario las credenciales para RedIris
        System.out.println("Introduzca las credenciales para acceder al FTP de RedIris.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario: ");
        String user = sc.nextLine();
        System.out.println("Introduce la contraseña: ");
        String pass = sc.nextLine();

        //Connexion
        FTPClient cliente = new FTPClient();
        String servFTP = "ftp.rediris.es"; // servidor FTP
        System.out.println("Conectar a: " + servFTP);
        cliente.connect(servFTP);
        // Obtener código de respuesta
        int respuesta = cliente.getReplyCode();

        System.out.println("Respuesta: " + respuesta) ;
        System.out.println("Texto Respuesta: " + cliente.getReplyString());

        //Realizamos login con los datos recolectados
        boolean loginCorrecto = cliente.login(user, pass);
        
        if (loginCorrecto) {
            //Mostramos la ruta actual tras la conexion y obtenemos los ficheros y directorios de la ruta
            System.out.println("Directorio Actual "+cliente.printWorkingDirectory());
            FTPFile[] files = cliente.listFiles();

            //Mostramos solo los ficheros en la ruta actual
            for(FTPFile file : files){
                if(file.isFile()) {
                    System.out.println("\t"+file.getName());
                }
            }

            //Seleccion de un fichero y su ruta de almacenamiento, y la realizacion de la descarga
            String archivoRedIris = "/mirror/archlinux/lastupdate";
            String archivoLocal = "archLinuxLastUpdate.txt";
            System.out.println("Descargando fichero: \"" + archivoRedIris + "\" al fichero: \"./" + archivoLocal + "\"");

            OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(archivoLocal)));

            boolean descarga = cliente.retrieveFile(archivoRedIris, outputStream);
            outputStream.close();

            if (descarga) {
                System.out.println("Archivo descargado correctamente.");
            } else {
                System.out.println("Error al descargar el archivo.");
            }
        }

        // Comprobar la respuesta
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            cliente.disconnect();
            System.out.println("Conexion rechazada: " + respuesta);
            System.exit(0);
        }

        // Desconectar del servidor FTP
        cliente.disconnect();
        System.out.println("Fin.");
    }
}
