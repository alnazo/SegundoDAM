import java.util.Scanner;

public class Frecuencia {

    public static void main(String[] args) {

        System.out.println("Introduzca una palabra para contabilizar sus vocales.");
        String palabra = new Scanner(System.in).nextLine();

        int contA = 0;
        int contE = 0;
        int contI = 0;
        int contO = 0;
        int contU = 0;

        for (int i = 0; i < palabra.length(); i++){
            char letra = palabra.toLowerCase().charAt(i);
            switch (letra){
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

        }

        System.out.println(contA + " " + contE + " " + contI + " " + contO + " " + contU);

    }

}
