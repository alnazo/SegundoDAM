public class PinPon {

    public static void main(String[] args) {
        Thread pin = new Pin();
        Thread pon = new Pon();

        pin.start();
        pon.start();
    }

}
