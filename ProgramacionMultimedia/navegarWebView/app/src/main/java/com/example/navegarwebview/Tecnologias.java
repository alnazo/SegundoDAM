package com.example.navegarwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class Tecnologias extends AppCompatActivity {

    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologias);

        sp = findViewById(R.id.spinner);

    }

    public void irAPIweb(View view){
        Intent i = new Intent(this, WebBrowse.class);
        


        startActivity(i);
    }

    public void volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}