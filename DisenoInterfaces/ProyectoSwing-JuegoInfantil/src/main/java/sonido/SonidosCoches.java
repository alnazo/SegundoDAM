package sonido;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SonidosCoches {

    Clip clip;
    URL[] listSounds = new URL[4];

    public SonidosCoches(){
        listSounds[0] = this.getClass().getResource("KnightRider.wav");
        listSounds[1] = this.getClass().getResource("claxon.wav");
        listSounds[2] = this.getClass().getResource("acceleration.wav");
        listSounds[3] = this.getClass().getResource("choque.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(listSounds[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Fichero no soportado");
            e.printStackTrace();
        } catch (LineUnavailableException e){
            System.out.println("Error LineUnavaliable");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }

}
