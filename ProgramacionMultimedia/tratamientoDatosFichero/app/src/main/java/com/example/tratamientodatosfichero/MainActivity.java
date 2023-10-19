package com.example.tratamientodatosfichero;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String _DATA = "data.txt";

    private EditText et1;
    private EditText et2;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //context = context.getApplicationContext();

        et1 = findViewById(R.id.nombreFrield);
        et2 = findViewById(R.id.telefonoField);

    }


    public void save(View view){
        String name = et1.getText().toString();
        String tel = et2.getText().toString();
        Contacto con = new Contacto(name, tel);

        if (!name.equals("") && !tel.equals("")) {
            try{
                FileOutputStream fos = context.openFileOutput(_DATA, Context.MODE_PRIVATE);

                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(con);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Toast.makeText(this, "Contacto guardado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se pueden dejar campos vacios", Toast.LENGTH_SHORT).show();
        }

    }

    public void load(View view){

        String name = et1.getText().toString();
        String tel = et2.getText().toString();

        if (!name.equals("") && tel.equals("")) {
            try{

                FileInputStream fis = context.openFileInput(_DATA);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Contacto contact = null;

                List<Contacto> contactos = new ArrayList<>();
                contactos = (List<Contacto>)ois.readObject();

                for (Contacto contacto : contactos){
                    if (contacto.getNombre().equals(name)){
                        Log.d("contacto", contacto.toString());
                    } else {
                        Log.d("contacto", "No hay contacto relacionado");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        } else {
            Toast.makeText(this, "Si buscas un contacto busca por el nombre solo", Toast.LENGTH_SHORT).show();
        }

    }

}