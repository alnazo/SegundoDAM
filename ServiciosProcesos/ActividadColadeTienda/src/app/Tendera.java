package app;

public class Tendera extends Thread{
    private String nombre;
    private Cliente cliente_atendido;
    private Long timeStamp;

    public Tendera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("La Tendera " + getNombre() + " COMIENZA A COBRAR LA COMPRA DEL CLIENTE " + cliente_atendido.getNombre() + " EN: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        for (int i = 0; i < cliente_atendido.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente_atendido.getCarroCompra()[i]);
            System.out.println("Cobrando el producto " + (i + 1) + " -> en: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg, por: " + getNombre());
        }
        System.out.println("La Tendera " + getNombre() + " HA TERMINADO DE COBRAR " + cliente_atendido.getNombre() + " EN: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("La Tendera " + this.nombre + " COMIENZA A COBRAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + " EN: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Cobrando el producto " + (i + 1) + " -> en: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }
        System.out.println("La Tendera " + this.nombre + " HA TERMINADO DE COBRAR " + cliente.getNombre() + " EN: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }

    public void atenderCliente(Cliente cliente, long timeStamp){
        this.cliente_atendido = cliente;
        this.timeStamp = timeStamp;
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
