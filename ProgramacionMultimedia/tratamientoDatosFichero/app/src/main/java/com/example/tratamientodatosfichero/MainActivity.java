package com.example.tratamientodatosfichero;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String _DATA = "data.txt";

    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.nombreFrield);
        et2 = findViewById(R.id.telefonoField);
    }


    public void save(View view){
        String name = et1.getText().toString();
        String tel = et2.getText().toString();
        Contacto con = new Contacto(name, tel);

        if (!name.equals("") && !tel.equals("")) {
            try {
                OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(_DATA, Activity.MODE_APPEND));
                osw.write(con + "\n");
                osw.flush();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            et1.setText("");
            et2.setText("");
            Toast.makeText(this, "Contacto guardado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se pueden dejar campos vacios", Toast.LENGTH_SHORT).show();
        }

    }

    public void load(View view){
        String[] archivos = fileList();
        String name = et1.getText().toString();
        String tel = et2.getText().toString();

        if(archivoExiste(archivos, _DATA)){
            if (!name.equals("") && tel.equals("")) {
                try{
                    InputStreamReader isr = new InputStreamReader(openFileInput(_DATA));
                    BufferedReader br = new BufferedReader(isr);

                    List<Contacto> contactos = new ArrayList<>();
                    String linea = br.readLine();
                    while (linea != null){
                        String[] con = linea.split(",");
                        String nombre = con[0];
                        String telefono = con[1];
                        contactos.add(new Contacto(nombre, telefono));
                        linea = br.readLine();
                    }
                    br.close();
                    isr.close();
                    for (Contacto contacto : contactos){
                        if (contacto.getNombre().equals(name)){
                            et1.setText(contacto.getNombre());
                            et2.setText(contacto.getTelefono());
                            break;
                        } else {
                            Toast.makeText(this, "No hay contacto relacionado", Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else {
                Toast.makeText(this, "Si buscas un contacto busca por el nombre solo", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Error de lectura del fichelo local", Toast.LENGTH_SHORT).show();
        }

    }


    private boolean archivoExiste(String[] archivos, String nombreArchivo){
        for(int i = 0; i < archivos.length; i++){
            if(nombreArchivo.equals(archivos[i])){
                return true;
            }
        }
        return false;
    }
}