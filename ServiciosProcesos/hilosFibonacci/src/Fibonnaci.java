public class Fibonnaci {

    public static void main(String[] args) {
        Thread hilo = new HiloFibonacci(10);
        hilo.start();
    }

}
