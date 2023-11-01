package contoller.juegoCartas;

import contoller.juegoCartas.objetos.CartasSelector;
import view.juegoCartas.CardsGame;

import java.util.List;

public class ChekCartas {

    static CartasSelector last;

    public static void check(CartasSelector actual, List<CartasSelector> list) {
        int flip = countFlip(list);

        if (flip == 8) {
            CardsGame.endGame();
        } else if (flip % 2 != 0) {
            last = actual;
        } else {
            if (flip != 1 && !actual.getAnimal().equals(last.getAnimal())) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                actual.flip = false;
                last.flip = false;
            }
        }

    }

    private static int countFlip(List<CartasSelector> list) {
        int flip = 0;
        for (CartasSelector carta : list) {
            if (carta.flip) {
                flip++;
            }
        }
        return flip;
    }

}
