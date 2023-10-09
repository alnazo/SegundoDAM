package com.example.navegarwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Tecnologias extends AppCompatActivity {

    private final String URL_FILE = "https://docs.oracle.com/javase/8/docs/api/java/io/File.html";
    private final String URL_WRITER = "https://docs.oracle.com/javase/8/docs/api/java/io/Writer.html";
    private final String URL_ARRAYS = "https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html";
    private final String URL_SCANNER = "https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html";

    private String name;
    private String surname;

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologias);

        sp = findViewById(R.id.spinner);
        String[] operations = {"File", "Writer", "Arrays", "Scanner"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operations);
        sp.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            surname = bundle.getString("surname");
        }

    }

    public void irAPIweb(View view){
        Intent i = new Intent(this, WebBrowse.class);

        String seleccion = sp.getSelectedItem().toString();

        switch (seleccion) {
            case "File":
                i.putExtra("web_url", URL_FILE);
                break;
            case "Writer":
                i.putExtra("web_url", URL_WRITER);
                break;
            case "Arrays":
                i.putExtra("web_url", URL_ARRAYS);
                break;
            case "Scanner":
                i.putExtra("web_url", URL_SCANNER);
                break;
        }

        startActivity(i);
    }

    public void volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("name", name);
        i.putExtra("surname", surname);
        startActivity(i);
    }


}