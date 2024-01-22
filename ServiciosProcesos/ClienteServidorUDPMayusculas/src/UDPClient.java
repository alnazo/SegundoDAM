import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class UDPClient {
    private static final int TIMEOUT = 3000;
    private static final int MAX_TRIES = 5;
    private static final int PORT = 8889;

    public static void main(String[] args) {
        System.out.println("INICIANDO PROGRAMA CLIENTE...");

        DatagramSocket datagramSocket = null;
        Scanner sc = new Scanner(System.in);
        byte[] data;
        DatagramPacket sendPacket;
        DatagramPacket receivePacket;

        try {
            datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(TIMEOUT);

            int tries = 0;
            boolean receivedResponse = false;

            System.out.println("Introduzca su texto que se convertira en mayuscula, si introduces * se acabara el programa.");

            String sender = sc.nextLine();

            while(!sender.equals("*")){
                data = sender.getBytes();

                sendPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), PORT);
                receivePacket = new DatagramPacket(new byte[data.length], data.length);

                System.out.println("ENVIANDO AL SERVIDOR....");
                do {
                    datagramSocket.send(sendPacket);
                    try {
                        datagramSocket.receive(receivePacket);
                        if (!receivePacket.getAddress().equals(sendPacket.getAddress())) {
                            throw new IOException("Paquete recibido de origen desconocido.");
                        }
                        receivedResponse = true;
                    } catch (IOException e) {
                        tries += 1;
                        System.out.println("Tiempo agotado, quedan " + (MAX_TRIES - tries) + " intentos...");
                    }
                } while (!receivedResponse && (tries < MAX_TRIES));

                if (receivedResponse) {
                    System.out.println("EL SERVIDOR HA RESPONDIDO:");
                    System.out.println(new String(receivePacket.getData()));
                } else {
                    System.out.println("SIN RESPUESTA DEL SERVIDOR...");
                }

                sender = sc.nextLine();
            }

            data = sender.getBytes();

            sendPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), PORT);
            datagramSocket.send(sendPacket);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                System.out.println("CERRANDO CLIENTE...");
                datagramSocket.close();
            }
        }
    }
}
