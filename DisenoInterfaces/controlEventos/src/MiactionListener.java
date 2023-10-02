import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MiactionListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton but = (JButton) e.getSource();
        but.setText("Boton pulsado");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton but = (JButton) e.getSource();
        but.setText("Boton mantenido");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton but = (JButton) e.getSource();
        but.setText("Boton soltado");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton but = (JButton) e.getSource();
        but.setText("Boton hover");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton but = (JButton) e.getSource();
        but.setText("Boton sobrepasado");
    }
}
