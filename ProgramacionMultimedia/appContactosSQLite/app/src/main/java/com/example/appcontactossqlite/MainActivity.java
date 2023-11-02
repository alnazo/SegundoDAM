package com.example.appcontactossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appcontactossqlite.basededatos.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    private EditText name_et, surname_et, tlf_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.nombreFrield);
        surname_et = findViewById(R.id.apellidoField);
        tlf_et = findViewById(R.id.tlfField);

    }

    public void guardar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "contactos", null, 1);
        SQLiteDatabase basededatos = admin.getWritableDatabase();

        String name = name_et.getText().toString();
        String surname = surname_et.getText().toString();
        String tlf = tlf_et.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty() && !tlf.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("nombre", name);
            registro.put("apellido", surname);
            registro.put("telefono", tlf);

            basededatos.insert("contactos", null, registro);
            basededatos.close();

            name_et.setText("");
            surname_et.setText("");
            tlf_et.setText("");

            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "contactos", null, 1);
        SQLiteDatabase basededatos = admin.getWritableDatabase();

        String name = name_et.getText().toString();
        String surname = surname_et.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty()){
            Cursor fila = basededatos.rawQuery("SELECT * FROM contactos WHERE nombre="+name+" AND apellido="+surname, null);

            if(fila.moveToFirst()){
                name_et.setText(fila.getString(0));
                surname_et.setText(fila.getString(1));
                tlf_et.setText(fila.getString(2));

                basededatos.close();
            } else {
                Toast.makeText(this, "No existe el contacto", Toast.LENGTH_SHORT).show();
                basededatos.close();
            }
        } else {
            Toast.makeText(this, "Debes indicar nombre y apellido", Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "contactos", null, 1);
        SQLiteDatabase basededatos = admin.getWritableDatabase();

        String name = name_et.getText().toString();
        String surname = surname_et.getText().toString();
        String tlf = tlf_et.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty() && !tlf.isEmpty()) {
            int cantidad = basededatos.delete("contactos", "nombre="+name+" AND apellido="+surname+" AND telefono="+tlf, null);
            basededatos.close();

            name_et.setText("");
            surname_et.setText("");
            tlf_et.setText("");

            if (cantidad == 1){
                Toast.makeText(this, "Datos borrados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No existe el contacto", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void editar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "contactos", null, 1);
        SQLiteDatabase basededatos = admin.getWritableDatabase();

        String name = name_et.getText().toString();
        String surname = surname_et.getText().toString();
        String tlf = tlf_et.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty() && !tlf.isEmpty()) {

            ContentValues registro = new ContentValues();

            registro.put("nombre", name);
            registro.put("apellido", surname);
            registro.put("telefono", tlf);

            int cantidad = basededatos.update("contactos", registro, "nombre="+name+" AND apellido="+surname+" AND telefono="+tlf, null);
            basededatos.close();

            if (cantidad == 1){
                Toast.makeText(this, "Datos editados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No existe el contacto", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}