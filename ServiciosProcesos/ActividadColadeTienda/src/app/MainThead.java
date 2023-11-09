package app;

public class MainThead {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Manuel", new int[] { 3, 5, 1, 1 });
        Cliente cliente2 = new Cliente("Chari", new int[] { 5, 5, 3, 2, 1 });
        Tendera Tendera1 = new Tendera("Jose");
        Tendera Tendera2 = new Tendera("Maria");

        long initialTime = System.currentTimeMillis();
        Tendera1.atenderCliente(cliente1, initialTime);
        Tendera2.atenderCliente(cliente2, initialTime);

        Tendera1.start();
        Tendera2.start();
    }
}
