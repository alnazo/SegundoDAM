package app;

public class Productor extends Thread {

    private ColaSincronizada cola;

    public Productor(ColaSincronizada cola) {
        this.cola = cola;
    }

    public void run() {
        int valor = 1;
        while (!cola.alcanzadoLimite()) {
            cola.put(valor);
            valor++;
        }
    }

}
