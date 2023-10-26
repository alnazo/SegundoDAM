package contoller.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandlerListener implements KeyListener {

    public boolean leftPress, rightPress;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == 65 || code == 37) {
            leftPress = true;
        }
        if (code == 68 || code == 39) {
            rightPress = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == 65 || code == 37) {
            leftPress = false;
        }
        if (code == 68 || code == 39) {
            rightPress = false;
        }
    }
}
