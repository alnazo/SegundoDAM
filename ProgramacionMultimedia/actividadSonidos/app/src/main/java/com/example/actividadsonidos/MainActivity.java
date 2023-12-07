package com.example.actividadsonidos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;
    SoundPool sp;
    int sonidoDeReproduccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.button_sound);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonidoDeReproduccion = sp.load(this, R.raw.la_hee, 1);
    }

    public void AudioSoundPool(View view){
        sp.play(sonidoDeReproduccion, 1, 1, 1, 0, 1);
    }

}