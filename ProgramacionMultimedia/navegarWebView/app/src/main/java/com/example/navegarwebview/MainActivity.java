package com.example.navegarwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.nombreField);
        et2 = findViewById(R.id.apellidoField);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String surname = bundle.getString("surname");
            et1.setText(name);
            et2.setText(surname);
        }

    }

    public void navegar(View view) {
        Intent i = new Intent(this, Tecnologias.class);

        String name = et1.getText().toString();
        String surname = et2.getText().toString();

        if (name.equals("") || surname.equals("")){
            Toast.makeText(this, "Debe introducir un nombre y un apellido", Toast.LENGTH_SHORT).show();
        } else {
            i.putExtra("name", name);
            i.putExtra("surname", surname);

            startActivity(i);
        }

    }

}