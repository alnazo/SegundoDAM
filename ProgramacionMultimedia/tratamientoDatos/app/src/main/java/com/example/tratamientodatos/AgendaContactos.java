package com.example.tratamientodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgendaContactos extends AppCompatActivity {

    private EditText et1;

    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_contactos);

        et1 = (EditText) findViewById(R.id.contact_name);
        et2 = (EditText) findViewById(R.id.contact_info);

    }

    public void save(View view){
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();

        String name = et1.getText().toString();
        String info = et2.getText().toString();

        if (!name.equals("") && !info.equals("")) {
            obj_editor.putString("name", name);
            obj_editor.putString("info", info);
            obj_editor.commit();
            et1.setText("");
            et2.setText("");
        } else {
            Toast.makeText(this, "No se pueden dejar campos en blanco", Toast.LENGTH_SHORT).show();
        }
    }

    public void load(View view){
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        String buscar = et1.getText().toString();
        String name = preferences.getString("name", buscar);

        if (buscar.equals(name) && !buscar.equals("")) {
            et1.setText(preferences.getString("name", buscar));
            et2.setText(preferences.getString("info", buscar));
        } else {
            Toast.makeText(this, "No existe ese usuario", Toast.LENGTH_SHORT).show();

            et2.setText("");
        }
    }

    public void clear(View view){
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();

        String buscar = et1.getText().toString();
        String name = preferences.getString("name", buscar);

        if (buscar.equals(name) && !buscar.equals("")) {
            obj_editor.remove(name);
            obj_editor.apply();

            et1.setText("");
            et2.setText("");
            Toast.makeText(this, "Usuario borrado correctamente", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "No existe ese usuario", Toast.LENGTH_SHORT).show();

            et2.setText("");
        }

    }

    public void volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}