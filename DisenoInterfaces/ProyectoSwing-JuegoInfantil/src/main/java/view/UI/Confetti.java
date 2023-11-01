package view.UI;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Confetti {

    private int width, height;
    @Getter
    private ArrayList<ConfettiPiece> confettiPieces;
    @Getter
    private boolean isRunning;

    public Confetti(int width, int height) {
        this.width = width;
        this.height = height;
        confettiPieces = new ArrayList<>();
        initConfetti();
    }

    public void initConfetti() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            confettiPieces.add(new ConfettiPiece(x, y, color));
        }
    }

    public void startConfetti() {
        isRunning = true;

        Thread confettiThread = new Thread(() -> {
            while (isRunning) {
                moveConfetti();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        confettiThread.start();
    }

    private void moveConfetti() {
        for (ConfettiPiece confetti : confettiPieces) {
            confetti.x += (int) (Math.random() * 6) - 3;
            confetti.y += 2;
            if (confetti.y > height) {
                confetti.y = 0;
            }
        }
    }

    public void stopConfetti() {
        isRunning = false;
    }

    @Getter
    public static class ConfettiPiece {
        private int x;
        private int y;
        private Color color;
        private static final int SIZE = 10;

        public ConfettiPiece(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void draw(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fillRect(x, y, SIZE, SIZE);
        }
    }

}