public class App extends Thread {

    public App(String nombre){
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++){
            System.out.println(getName() + " - Repeticion = " + i);
        }
    }

    public static void main(String[] args) {
        App app1 = new App("Hola mundo, Hilo 1");
        App app2 = new App("Hola mundo, Hilo 2");
        App app3 = new App("Hola mundo, Hilo 3");
        App app4 = new App("Hola mundo, Hilo 4");
        App app5 = new App("Hola mundo, Hilo 5");

        System.out.println("Iniciando Hilos");

        app1.start();
        app2.start();
        app3.start();
        app4.start();
        app5.start();

    }
}
