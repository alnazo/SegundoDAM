public class Pin extends Thread {

    public void run() {
        try {
            while(true){
                System.out.println("PIN");
                Thread.sleep(900);
            }
        } catch (InterruptedException e){
            System.out.println("Interrupcion del programa:");
            e.printStackTrace();
        }
    }
}
