package com.example.navegacionentreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("result");

        et1 = (TextView) findViewById(R.id.result);

        et1.setText(result);
    }

    public void volver(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}