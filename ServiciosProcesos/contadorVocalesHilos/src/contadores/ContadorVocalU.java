package contadores;

import Main.Main;

public class ContadorVocalU implements Runnable {

    String frase;
    int contador = 0;

    public ContadorVocalU(String frase){
        this.frase = frase;
    }

    @Override
    public void run() {
        for(int i = 0; i < frase.length(); i++){
            char letra = frase.toLowerCase().charAt(i);
            if (letra == 'u'){
                contador++;
                Main.contadorTotal++;
            }
        }
        System.out.println("Contador letra U: " + contador);
    }
}