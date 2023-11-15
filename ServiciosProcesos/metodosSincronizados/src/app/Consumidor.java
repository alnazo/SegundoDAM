package app;

public class Consumidor extends Thread {

    private ColaSincronizada cola;

    public Consumidor(ColaSincronizada cola) {
        this.cola = cola;
    }

    public void run() {
        while (!cola.alcanzadoLimite()) {
            cola.get();
        }
    }

}
