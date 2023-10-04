import java.util.Arrays;

public class Frecuencia {

    public void main(String[] args) {
        String[] listado = new String[10];
        int contA = 0;
        int contE = 0;
        int contI = 0;
        int contO = 0;
        int contU = 0;

        for (int i = 0; i < listado.length; i++) {
            for (String palabra : args) {
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
                    listado[i] = "A: " + contA + " - E: " + contE + " - I: " + contI + " - O: " + contO + " - U: " + contU;
                }
            }
        }
        System.out.println(Arrays.toString(listado));
    }

}
