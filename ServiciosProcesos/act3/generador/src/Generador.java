import java.io.*;
import java.util.Arrays;

public class Generador {
    final static File pathCadenas = new File("C:\\Users\\Antonio\\Desktop\\Proyects\\ServiciosProcesos\\act3\\cadenas\\out\\production\\cadenas");
    final static File pathFrecuncia = new File("C:\\Users\\Antonio\\Desktop\\Proyects\\ServiciosProcesos\\act3\\frecuencia\\out\\production\\frecuencia");

    public static void main(String[] args){
        try {
            ProcessBuilder pbCadenas = new ProcessBuilder("java", "Cadenas");
            pbCadenas.directory(pathCadenas);
            Process pCadenas = pbCadenas.start();

            InputStream iCadenas = pCadenas.getInputStream();
            BufferedReader brCadenas = new BufferedReader(new InputStreamReader(iCadenas));

            String linea;
            String[] cadenas = new String[10];
            while ((linea = brCadenas.readLine()) != null) {
                String cad = linea.substring(1, linea.length() - 1);
                cadenas = cad.split(",");
            }

            //TODO
            ProcessBuilder pbFrecuencia = new ProcessBuilder("java", "Frecuencia", "'"+Arrays.toString(cadenas)+"'");
            pbFrecuencia.directory(pathFrecuncia);

            Process pFrecuencia = pbFrecuencia.start();

            InputStream iFrecuencia = pFrecuencia.getInputStream();
            BufferedReader brFrecuencia = new BufferedReader(new InputStreamReader(iFrecuencia));

            String frec;
            while ((frec = brFrecuencia.readLine()) != null) {
                System.out.println(frec);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
