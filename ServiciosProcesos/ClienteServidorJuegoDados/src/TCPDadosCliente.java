import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPDadosCliente {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int PORT = 5000;
        final String HOST = "localhost";
        int contador = 0;

        Socket cliente = new Socket(HOST, PORT);
        System.out.println("Conectando con el servidor...");

        DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
        DataInputStream inputStream = new DataInputStream(cliente.getInputStream());

        while (contador < 3) {
            System.out.println("--RONDA " + (contador+1) + "--");
            System.out.println("Tirando dados...");
            int dado1 = (int) (Math.random() * 6 + 1);
            int dado2 = (int) (Math.random() * 6 + 1);
            System.out.println("Han salido un " + dado1 + " y " + dado2);

            int dados = dado1 + dado2;
            System.out.println("Un total de: " + dados);
            outputStream.writeInt(dados);

            Thread.sleep(1500);

            System.out.println("Esperando respuesta del servidor...");

            System.out.println(inputStream.readUTF());

            Thread.sleep(1500);
            contador++;
        }
        System.out.println("--FIN DEL JUEGO--");
        System.out.println(inputStream.readUTF());
        System.out.println(inputStream.readUTF());

        outputStream.close();
        cliente.close();
    }
}
