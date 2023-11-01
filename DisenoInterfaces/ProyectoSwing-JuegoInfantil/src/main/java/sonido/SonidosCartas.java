package sonido;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SonidosCartas {
    Clip clip;
    URL[] listSounds = new URL[4];

    public SonidosCartas() {
        listSounds[0] = this.getClass().getResource("vaca.wav");
        listSounds[1] = this.getClass().getResource("cerdo.wav");
        listSounds[2] = this.getClass().getResource("gallina.wav");
        listSounds[3] = this.getClass().getResource("oveja.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(listSounds[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Fichero no soportado");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.out.println("Error LineUnavaliable");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }

    public void play() {
        clip.start();
    }

}
