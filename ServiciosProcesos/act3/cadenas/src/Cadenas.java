import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Cadenas {
    public static void main(String[] args) {
        String caracteres = "abcdefghijklmnopqrstuvwxyz";
        String[] cadenas = new String[10];
        for (int i = 0; i < 10; i++) {
            int longitud = (int)(Math.random() * 20) + 1;
            StringBuilder cadena = new StringBuilder();

            for (int j = 0; j < longitud; j++){
                int caracter = (int)(Math.random() * (caracteres.length() -1));

                cadena.append(caracteres.charAt(caracter));
            }
            cadenas[i] = cadena.toString();
        }
        System.out.println(Arrays.toString(cadenas));
    }
}
