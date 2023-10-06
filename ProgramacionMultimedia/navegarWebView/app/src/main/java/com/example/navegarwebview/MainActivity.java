package com.example.navegarwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.nombreField);
        et2 = findViewById(R.id.apellidoField);
    }

    public void navegar(View view) {
        Intent i = new Intent(this, Tecnologias.class);
        startActivity(i);
    }

}