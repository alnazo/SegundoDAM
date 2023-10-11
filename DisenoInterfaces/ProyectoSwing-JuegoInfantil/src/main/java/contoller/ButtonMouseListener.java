package contoller;

import view.BaseView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonMouseListener implements MouseListener {

    private final JPanel panel;
    private final String title;

    public ButtonMouseListener(JPanel panel, String title) {
        this.panel = panel;
        this.title = title;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        BaseView.frame.setTitle(title);
        BaseView.frame.setContentPane(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
