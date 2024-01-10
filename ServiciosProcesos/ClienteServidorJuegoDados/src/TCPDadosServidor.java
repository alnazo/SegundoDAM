import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDadosServidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int RONDAS = 3;
        final int PORT = 5000;
        int contador = 0;
        int rondasCliente = 0;
        int rondasServidor = 0;

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Esperando al cliente...");
        Socket cliente = server.accept();

        InputStream input = cliente.getInputStream();
        DataInputStream inputStream = new DataInputStream(input);

        int numerocliente;
        DataOutputStream output = new DataOutputStream(cliente.getOutputStream());

        System.out.println("Inicio de rondas");
        while (contador < RONDAS) {
            System.out.println("--RONDA " + (contador+1) + "--");
            numerocliente = inputStream.readInt();
            System.out.println("El cliente ha sacado: " + numerocliente);

            Thread.sleep(1500);

            System.out.println("Tirando dados...");
            int dado1 = (int) (Math.random() * 6 + 1);
            int dado2 = (int) (Math.random() * 6 + 1);
            System.out.println("Han salido un " + dado1 + " y " + dado2);
            int dados = dado1 + dado2;
            System.out.println("Un total de: " + dados);

            Thread.sleep(1500);

            if (numerocliente > dados){
                rondasCliente++;
                output.writeUTF("El servidor ha sacado: " + dados + ", has ganado la ronda");
            } else if (numerocliente < dados){
                rondasServidor++;
                output.writeUTF("El servidor ha sacado: " + dados + ", el servidor ha ganado la ronda");
            } else {
                output.writeUTF("Hubo un empate, no se suma ronda ganada a nadie");
            }
            Thread.sleep(1500);

            contador++;
        }

        output.writeUTF("El servidor ha ganado: " + rondasServidor + " rondas, has ganado: " + rondasCliente + " rondas");

        if (rondasServidor > rondasCliente){
            output.writeUTF("Gana el servidor");
        } else {
            output.writeUTF("Has ganado!");
        }

        inputStream.close();
        input.close();
        server.close();


    }
}
