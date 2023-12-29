import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPSecretoCliente {
    public static void main(String[] args) throws IOException, InterruptedException {
        String _HOST = "localhost";
        int _PORT = 2000;

        Scanner sc = new Scanner(System.in);

        Socket cliente = new Socket(_HOST, _PORT);

        System.out.println("Conectando con el servidor...");

        DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
        DataInputStream inputStream = new DataInputStream(cliente.getInputStream());

        int sender;
        int secret = inputStream.readInt();
        System.out.println("Adivine el numero que tiene pensado el servidor");
        while (true){
            sender = sc.nextInt();
            outputStream.writeInt(sender);

            System.out.println(inputStream.readUTF());
            System.out.println(inputStream.readUTF());

            if (secret == sender){
                break;
            }
        }

        outputStream.close();
        cliente.close();

    }


}
