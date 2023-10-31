public class Pon extends Thread {

    public void run() {
        try {
            while(true){
                System.out.println("PON");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Interrupcion del programa:");
            e.printStackTrace();
        }
    }
}
