import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSecretoServidor {

    public static void main(String[] args) throws IOException {
        int _PORT = 2000;
        ServerSocket server = new ServerSocket(_PORT);

        int numeroSecreto = (int) (Math.random() * 100);
        System.out.println("El numero secreto es: " + numeroSecreto);
        int intentos = 0;

        Socket cliente = server.accept();

        InputStream input = cliente.getInputStream();
        DataInputStream inputStream = new DataInputStream(input);

        int numeroCliente;
        DataOutputStream output = new DataOutputStream(cliente.getOutputStream());
        output.writeInt(numeroSecreto);
        do {
            numeroCliente = inputStream.readInt();
            System.out.println("Recibiendo del CLIENTE el numero: " + numeroCliente);

            if (numeroCliente < numeroSecreto){
                output.writeUTF("Su numero: " + numeroCliente + " es menor que el numero secreto");
                intentos++;
            } else if(numeroCliente > numeroSecreto) {
                output.writeUTF("Su numero: " + numeroCliente + " es mayor que el numero secreto");
                intentos++;
            }

            if (numeroCliente != numeroSecreto){
                output.writeUTF("Vuelve a intentarlo...");
            }
        } while (numeroCliente != numeroSecreto);

        output.writeUTF("Has realizado: " + intentos + " intentos");
        output.writeUTF("Has acertado, gracias por jugar");
        inputStream.close();
        input.close();
        server.close();

    }

}
