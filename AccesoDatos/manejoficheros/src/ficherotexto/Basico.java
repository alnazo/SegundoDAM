package ficherotexto;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Basico {

    static String path = ".\\src\\ficherotexto\\fichero.txt";
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        File file = new File(path);

        try {
            FileWriter f = null;
            if (file.exists()) {

                FileReader fr = new FileReader(file);
                System.out.println("Contenido actual del fichero:");
                int caracter=fr.read();
                while(caracter!=-1){
                    System.out.print((char)caracter);
                    caracter=fr.read();
                }

                System.out.println("----------");
                System.out.println("Si quiere empezar de nuevo el archivo introduzca un 1, en caso contrario pulse intro");
                boolean start = sc.nextLine().equals("1");
                f = start ? new FileWriter(file) : new FileWriter(file, true);

                System.out.println(start ? "Se ha creado de nuevo el fichero" : "Se va a añadir datos a continuacion");

                System.out.println("----------");
            } else {
                f = new FileWriter(path);
            }

            System.out.println("Introduzca texto para ir añadiendo linea a linea, cuando quiera acabar introduzca solo #");
            while (true) {
                String input = sc.nextLine();
                if(input.equals("#")) break;

                f.append(input + "\n");

                f.flush();
            }

            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
