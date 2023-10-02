package com.example.miprimeraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_num1);
        et2 = (EditText) findViewById(R.id.txt_num2);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

    }

    public void calcular (View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int res = 0;

        int select = radioGroup.getCheckedRadioButtonId();

        if (select == -1 ) {
            Toast.makeText(this, "Tiene que seleccionar una opcion", Toast.LENGTH_LONG).show();
        } else {
            View action = radioGroup.findViewById(select);
            int option = radioGroup.indexOfChild(action);

            switch (option) {
                case 0:
                    res = num1 + num2;
                    break;
                case 1:
                    res = num1 - num2;
                    break;
                case 2:
                    res = num1 * num2;
                    break;
                case 3:
                    res = num1 / num2;
                    break;
            }
        }
        String result = String.valueOf(res);

        tv1.setText(result);

    }

}