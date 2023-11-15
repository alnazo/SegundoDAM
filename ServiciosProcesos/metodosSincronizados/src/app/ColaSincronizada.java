package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColaSincronizada {
    private final int MAX_ELEMENT;
    private int elementosProducidos = 0;
    private List<Integer> contenedor = Collections.synchronizedList(new ArrayList<>());

    public ColaSincronizada(int max){
        this.MAX_ELEMENT = max;
    }

    public void put(int valor) {
        synchronized (contenedor) {
            contenedor.add(valor);
            elementosProducidos++;
            System.out.println("Productor ha producido: " + valor);
            contenedor.notify();
        }

        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int get() {
        synchronized (contenedor) {
            while (contenedor.isEmpty()) {
                try {
                    contenedor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int valor = contenedor.remove(0);
            System.out.println("Consumidor ha consumido: " + valor);
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return valor;
        }
    }

    public boolean alcanzadoLimite() {
        return elementosProducidos >= MAX_ELEMENT;
    }

}
