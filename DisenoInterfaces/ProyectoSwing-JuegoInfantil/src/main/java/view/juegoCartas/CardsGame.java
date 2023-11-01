package view.juegoCartas;

import contoller.juegoCartas.ChekCartas;
import contoller.juegoCartas.Positions;
import contoller.juegoCartas.objetos.ButtonExit;
import contoller.juegoCartas.objetos.CartasSelector;
import sonido.SonidosCartas;
import view.BaseView;
import view.UI.Confetti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsGame extends JPanel implements Runnable, MouseListener {

    public static Thread cardGame;
    SonidosCartas sonidosCartas = new SonidosCartas();

    int width, height, seconds;
    BufferedImage screen;
    Graphics2D g2;
    ButtonExit exitButton;
    List<CartasSelector> cartas = new ArrayList<>();
    static Confetti confetti;


    public CardsGame() {
        setupGame();

        confetti = new Confetti(width, height);

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        addMouseListener(this);
    }

    public void setupGame() {
        setFullScreen();

        screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D) screen.getGraphics();
    }

    public void setFullScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        gd.setFullScreenWindow(BaseView.cardGame);

        width = BaseView.cardGame.getWidth();
        height = BaseView.cardGame.getHeight();

    }

    public void init() {
        cardGame = new Thread(this);

        exitButton = new ButtonExit(this);
        generarCartas();


        cardGame.start();
    }

    @Override
    public void run() {
        double drawInteval = 1000000000 / 60;
        double delta = 0;
        double lastTime = System.nanoTime();
        double currentTime;
        double timer = 0;

        while (cardGame != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInteval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();

                paintComponent();
                drawToScreen();

                delta--;
            }

            if (timer >= 1000000000) {
                seconds++;

                timer = 0;
            }
        }
    }

    public void update() {

    }

    public void paintComponent() {

        try {
            g2.drawImage(ImageIO.read(CardsGame.class.getResource("granja.png")), 0, 0, width, height, null);
        } catch (IOException ignored) {
        }

        exitButton.draw(g2);

        for (CartasSelector carta : cartas) {
            carta.draw(g2);
        }


    }

    public void drawToScreen() {

        Graphics g = getGraphics();

        g.drawImage(screen, 0, 0, width, height, this);

        if (confetti != null && confetti.isRunning()) {
            List<Confetti.ConfettiPiece> confettiPieces = confetti.getConfettiPieces();
            for (Confetti.ConfettiPiece confettiPiece : confettiPieces) {
                g.setColor(confettiPiece.getColor());
                g.fillRect(confettiPiece.getX(), confettiPiece.getY(), 20, 20);
            }
        }

        g.dispose();

    }

    private void generarCartas() {
        try {
            for (int i = 0; i < 8; i++) {
                CartasSelector carta = new CartasSelector(this);
                switch (i) {
                    case 0:
                    case 1:
                        carta.setAnimal("vaca");
                        carta.setSonidoAnimal(0);
                        carta.setImg(ImageIO.read(CardsGame.class.getResource("vaca.png")));
                        break;
                    case 2:
                    case 3:
                        carta.setAnimal("cerdo");
                        carta.setSonidoAnimal(1);
                        carta.setImg(ImageIO.read(CardsGame.class.getResource("cerdo.png")));
                        break;
                    case 4:
                    case 5:
                        carta.setAnimal("pollo");
                        carta.setSonidoAnimal(2);
                        carta.setImg(ImageIO.read(CardsGame.class.getResource("pollo.png")));
                        break;
                    case 6:
                    case 7:
                        carta.setAnimal("oveja");
                        carta.setSonidoAnimal(3);
                        carta.setImg(ImageIO.read(CardsGame.class.getResource("oveja.png")));
                        break;
                }
                cartas.add(carta);
            }
        } catch (IOException e) {
        }
        int xCardPosition = this.width / 9;
        int yCardPosition = this.height / 4;

        int firstColCard = xCardPosition;
        int secondColCard = xCardPosition * 3;
        int thirdColCard = xCardPosition * 5;
        int fourColCard = xCardPosition * 7;
        int topCard = yCardPosition / 2;
        int bottonCard = yCardPosition * 2;

        /* Sacado por ChatGPT (ya muchos dolores de cabeza)*/
        List<Positions> posiciones = new ArrayList<>();
        posiciones.add(new Positions(firstColCard, topCard));
        posiciones.add(new Positions(firstColCard, bottonCard));
        posiciones.add(new Positions(secondColCard, topCard));
        posiciones.add(new Positions(secondColCard, bottonCard));
        posiciones.add(new Positions(thirdColCard, topCard));
        posiciones.add(new Positions(thirdColCard, bottonCard));
        posiciones.add(new Positions(fourColCard, topCard));
        posiciones.add(new Positions(fourColCard, bottonCard));

        Collections.shuffle(cartas);

        if (cartas.size() == posiciones.size()) {
            for (int i = 0; i < cartas.size(); i++) {
                CartasSelector carta = cartas.get(i);
                Positions posicion = posiciones.get(i);
                carta.setXY(posicion.getX(), posicion.getY());
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (exitButtonAreaClicked(mouseX, mouseY)) {
            int i = JOptionPane.showConfirmDialog(this, "Seguro que quiere salir", "Salir", JOptionPane.YES_NO_OPTION);

            switch (i) {
                case 0:
                    cardGame = null;
                    BaseView.cardGame.dispose();
                    break;
                case 1:
                    break;
            }
        }

        for (CartasSelector carta : cartas) {
            if (!carta.flip && cartaAreaClicked(carta, mouseX, mouseY)) {
                carta.flip = true;
                carta.soundEffect(sonidosCartas);
                ChekCartas.check(carta, cartas);
            }
        }
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

    private boolean exitButtonAreaClicked(int mouseX, int mouseY) {
        return exitButton.getArea(mouseX, mouseY);
    }

    private boolean cartaAreaClicked(CartasSelector carta, int mouseX, int mouseY) {
        return carta.getArea(mouseX, mouseY);
    }

    public static void endGame() {
        confetti.initConfetti();
        confetti.startConfetti();
        Timer timer = new Timer(5000, e -> {
            JOptionPane.showMessageDialog(BaseView.cardGame, "Fin del juego", "Cerrar", JOptionPane.PLAIN_MESSAGE);
            cardGame = null;
            BaseView.cardGame.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }
}
