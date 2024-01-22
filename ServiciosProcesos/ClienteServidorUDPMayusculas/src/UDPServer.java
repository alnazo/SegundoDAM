import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

public class UDPServer {
    private static final int ECHO_MAX = 255;
    private static final int PORT = 8889;
 
    public static void main(String[] args) {
        System.out.println("INICIANDO SERVIDOR...");

        byte[] sendData;
        String text;
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket(PORT);
            
            DatagramPacket receivePacket = new DatagramPacket(new byte[ECHO_MAX], ECHO_MAX);
            DatagramPacket sendPacket;

            do {
                datagramSocket.receive(receivePacket);

                text = getStringFromBytes(receivePacket.getData(), receivePacket.getLength());

                System.out.println("CLIENTE: " + text);

                sendData = text.toUpperCase().getBytes();

                sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getSocketAddress());
                datagramSocket.send(sendPacket);
            } while (!text.equals("*"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                System.out.println("CERRANDO SERVIDOR...");
                datagramSocket.close();
            }
        }
    }

    private static String getStringFromBytes(byte[] array, int length) {
        int lengthData = -1;

        for (int i = length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                lengthData = i;
                break;
            }
        }

        if (lengthData == -1){
            return "";
        } else {
            byte[] sanitizedData = new byte[lengthData + 1];
            System.arraycopy(array, 0, sanitizedData, 0, lengthData + 1);

            return new String(sanitizedData);
        }

    }
}

