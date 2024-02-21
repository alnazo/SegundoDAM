import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class DescifradoSimetrico {

    public static void main(String[] args) {
        byte[] mensajeInterceptado = {
                (byte) 0xEC, (byte) 0xC4, (byte) 0xD5, (byte) 0x89,
                (byte) 0x02, (byte) 0xE3, (byte) 0xD5, (byte) 0xCC,
                (byte) 0x5E, (byte) 0xC6, (byte) 0xAF, (byte) 0x6C,
                (byte) 0x61, (byte) 0x8B, (byte) 0xC2, (byte) 0xA5
        };

        for (int i = 0; i < 10000; i++) {
            String password = String.format("%04d", i);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

                byte[] key = Arrays.copyOf(messageDigest.digest(password.getBytes(StandardCharsets.UTF_8)), 24);
                SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

                Cipher cifrado = Cipher.getInstance("AES");
                cifrado.init(Cipher.DECRYPT_MODE, secretKey);

                byte[] mensajeDesencriptado = cifrado.doFinal(mensajeInterceptado);
                String mensajeFinal = new String(mensajeDesencriptado);

                if (mensajeFinal.matches("[a-zA-Z0-9\\p{Punct} ]+")){ //Eliminacion de lineas con caracteres irreconocibles
                    System.out.println("Prueba con clave " + password + " - resultado: " + mensajeFinal);
                }
            } catch (Exception e) {
                // Si la clave no es valida, se captura la excepcion y se pasa a la siguiente iteracion.
            }
        }
    }

}
