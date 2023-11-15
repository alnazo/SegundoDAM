package app;

public class App {

    public static void main(String[] args) {
        ColaSincronizada cola = new ColaSincronizada(7);

        Productor productor = new Productor(cola);
        Consumidor consumidor = new Consumidor(cola);

        productor.start();
        consumidor.start();

        while (!cola.alcanzadoLimite()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productor.interrupt();
        consumidor.interrupt();

    }

}
