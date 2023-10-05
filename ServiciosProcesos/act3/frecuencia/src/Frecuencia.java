import java.util.Arrays;

public class Frecuencia {

    public static void main(String[] args) {
        String array = args[0];
        String cad = array.substring(1, array.length() - 1);
        String[] cadenas = cad.split(",");

        for (String palabra : cadenas) {
            String cadena = "";
            int contA = 0;
            int contE = 0;
            int contI = 0;
            int contO = 0;
            int contU = 0;

            for (int j = 0; j < palabra.length(); j++) {
                char letra = palabra.toLowerCase().charAt(j);
                switch (letra) {
                    case 'a':
                        contA++;
                        break;
                    case 'e':
                        contE++;
                        break;
                    case 'i':
                        contI++;
                        break;
                    case 'o':
                        contO++;
                        break;
                    case 'u':
                        contU++;
                        break;
                }
                 cadena = "A: " + contA + " - E: " + contE + " - I: " + contI + " - O: " + contO + " - U: " + contU;
            }

            System.out.println("Cadena: " + palabra);
            System.out.println(cadena);
            System.out.println("--------------------------");


        }
    }

}
