package com.example.navegacionentreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.num1);
        et2 = (EditText) findViewById(R.id.num2);

        spinner = (Spinner)findViewById(R.id.spinner);
        String[] operations = {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operations);
        spinner.setAdapter(adapter);

    }

    public void calcular(View view){
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);
        String seleccion = spinner.getSelectedItem().toString();

        String resultado = "0";

        if(seleccion.equals("sumar")){
            int suma = valor1_int + valor2_int;
            resultado = String.valueOf(suma);
        } else if(seleccion.equals("restar")){
            int resta = valor1_int - valor2_int;
            resultado = String.valueOf(resta);
        } else if(seleccion.equals("multiplicar")) {
            int multi = valor1_int * valor2_int;
            resultado = String.valueOf(multi);
        } else if(seleccion.equals("dividir")){
            if(valor2_int != 0){
                int div = valor1_int / valor2_int;
                resultado = String.valueOf(div);
            } else {
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
            }
        }

        Intent i = new Intent(this, Resultado.class);
        i.putExtra("result", resultado);
        startActivity(i);

    }



}