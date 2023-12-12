package ejemplo1tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPejemplo1Cliente {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int port = 6000;

        Scanner sc = new Scanner(System.in);

        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket client = new Socket(host, port);

        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

        System.out.println("Introduzca su texto que se convertira en mayuscula, si introduces * se acabara el programa.");

        String sender = sc.nextLine();
        System.out.println();

        while(!sender.equals("*")){
            System.out.println("ENVIANDO AL SERVIDOR....");
            outputStream.writeUTF(sender);
            System.out.println();

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            System.out.print("Recibiendo del SERVIDOR: \n\t" + inputStream.readUTF());
            System.out.println();

            sender = sc.nextLine();
            System.out.println();
        }

        outputStream.close();
        client.close();

    }

}
