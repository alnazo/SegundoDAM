package contadores;

import Main.Main;

public class ContadorVocalI implements Runnable {

    String frase;
    int contador = 0;

    public ContadorVocalI(String frase){
        this.frase = frase;
    }

    @Override
    public void run() {
        for(int i = 0; i < frase.length(); i++){
            char letra = frase.toLowerCase().charAt(i);
            if (letra == 'i'){
                contador++;
                Main.actualizarContador();
            }
        }
        System.out.println("Contador letra I: " + contador);
    }
}