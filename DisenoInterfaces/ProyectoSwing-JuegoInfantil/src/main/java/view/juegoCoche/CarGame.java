package view.juegoCoche;

import contoller.events.CarHandlerListener;
import contoller.juegoCoche.CocheContrario;
import contoller.juegoCoche.CocheJugador;
import contoller.juegoCoche.CollisionCheck;
import contoller.juegoCoche.UI;
import sonido.SonidosCoches;
import view.BaseView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class CarGame extends JPanel implements Runnable {
    public Thread gameCar;

    public int puntuacion, seconds;
    public boolean endGame, cocheactivo;
    public CollisionCheck collisionCheck = new CollisionCheck(this);
    public CocheContrario c1 = new CocheContrario(this, "secondCar.png", 120, 220, 360);
    public CocheContrario c2 = new CocheContrario(this, "thirdCar.png", 120, 220, 520);
    public SonidosCoches sonidos = new SonidosCoches();
    public SonidosCoches efctos = new SonidosCoches();

    int width = 1000, height = 800;
    CarHandlerListener chl = new CarHandlerListener();
    CocheJugador player = new CocheJugador(this, chl);
    UI interfaz = new UI(this);

    public CarGame() {
        addKeyListener(chl);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
    }

    public void init() {
        gameCar = new Thread(this);

        JOptionPane.showMessageDialog(
                this,
                "Pulsa \"A\" ó \"Flecha izquierda\" para moverte hacia la izquierda." +
                        "\n" +
                        "Pulsa \"D\" ó \"Flecha derecha\" para moverte hacia la derecha.",
                "Como jugar",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(CarGame.class.getResource("car.png"))
        );

        gameCar.start();
    }

    @Override
    public void run() {
        playMusic(0);

        endGame = false;

        seconds = 0;
        puntuacion = 0;

        double drawInteval = 1000000000/60;
        double delta = 0;
        double lastTime = System.nanoTime();
        double currentTime;
        double timer = 0;

        while (gameCar != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInteval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();

                delta--;
            }

            if (timer >= 1000000000){

                c1.setSegs(seconds);
                c2.setSegs(seconds);
                initCars();

                seconds++;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();

        c1.update();
        c2.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        ImageIcon imageIcon = new ImageIcon(CarGame.class.getResource("street.gif"));
        g2.drawImage(imageIcon.getImage(), 0, 0, width, height, this);

        player.draw(g2);
        c1.draw(g2);
        c2.draw(g2);
        interfaz.draw(g2);

        g2.dispose();
    }

    private void initCars(){
        if (!c1.active && !c2.active) {
            int random = (int) (Math.random() * (10 - 8)) + 1; // 1 || 2

            if (random == 1) {
                c1.active = true;
            }
            if (random == 2) {
                c2.active = true;
            }
            playSE(1);
        }
    }

    public void endGame(){
        int i = JOptionPane.showConfirmDialog(this, "Quieres volver a empezar", "Fin del juego", JOptionPane.YES_NO_OPTION);
        endGame = true;

        switch (i){
            case 0:
                resetGame();
                run();
                break;
            case 1:
                gameCar = null;
                JOptionPane.showMessageDialog(this, "Tu puntuacion ha sido de: " + puntuacion);
                BaseView.carGame.dispose();
                break;
        }
    }


    public void resetGame(){
        c1.setDefaultValues();
        c2.setDefaultValues();

        chl.rightPress = false;
        chl.leftPress = false;
    }

    public void playMusic(int i){
        sonidos.setFile(i);
        sonidos.play();
        sonidos.loop();
    }
    public void stopMusic(){
        sonidos.stop();
    }
    public void playSE(int i){
        efctos.setFile(i);
        efctos.play();
    }

}
