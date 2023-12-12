package ejemplo1tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {

    public static void main(String[] args) throws IOException {
        int port = 6000;
        ServerSocket server = new ServerSocket(port);

        System.out.println("Esperando al cliente...");
        Socket client = server.accept();

        InputStream input = client.getInputStream();
        DataInputStream inputStream = new DataInputStream(input);

        String text;

        do {
            text = inputStream.readUTF();
            System.out.println("Recibiendo del CLIENTE \n \t" + text);

            DataOutputStream outputData = new DataOutputStream(client.getOutputStream());

            outputData.writeUTF(text.toUpperCase());
        } while (!text.equals("*"));

        input.close();
        inputStream.close();
        client.close();
        server.close();
    }


}
