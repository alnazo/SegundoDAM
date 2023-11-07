package com.example.connectionddbb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;

    private EditText name_et, surname_et, tlf_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.nombreFrield);
        surname_et = findViewById(R.id.apellidoField);
        tlf_et = findViewById(R.id.tlfField);
    }

    public void insertar(View view) {
        String name = name_et.getText().toString();
        String surname = surname_et.getText().toString();
        String tlf = tlf_et.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty() && !tlf.isEmpty()) {
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST, "http://10.0.2.2/insertar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), "Contacto añadido correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("nombre", name);
                    parametros.put("apellido", surname);
                    parametros.put("telefono", tlf);

                    return parametros;
                }
            };
            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        } else {
            Toast.makeText(this, "No pueden estar los campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscar(View view) {
        List<String> namesAll = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        JsonArrayRequest jsonAll = new JsonArrayRequest(
                "http://10.0.2.2/buscar.php",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                ids.add(jsonObject.getInt("id"));
                                namesAll.add(jsonObject.getString("nombre"));
                            } catch (JSONException e) {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        mostrarDialogo(namesAll, ids);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonAll);
    }


    public void editar(View view) {
        String name = name_et.getText().toString();
        String surname = surname_et.getText().toString();
        String tlf = tlf_et.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty()) {
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST, "http://10.0.2.2/editar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), "Contacto editado", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("nombre", name);
                    parametros.put("apellido", surname);
                    parametros.put("telefono", tlf);

                    return parametros;
                }
            };
            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        } else{
            Toast.makeText(this, "No pueden estar los campos de nombre y apellidos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View view) {
        String name = name_et.getText().toString();
        String surname = surname_et.getText().toString();
        String tlf = tlf_et.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty() && !tlf.isEmpty()) {
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST, "http://10.0.2.2/eliminar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), "Contacto eliminado", Toast.LENGTH_SHORT).show();
                            limpiarFormulario();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }

            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("nombre", name_et.getText().toString());
                    parametros.put("apellido", surname_et.getText().toString());
                    parametros.put("telefono", tlf_et.getText().toString());

                    return parametros;
                }
            };
            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        } else {
            Toast.makeText(this, "No pueden estar los campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarFormulario() {
        name_et.setText("");
        surname_et.setText("");
        tlf_et.setText("");
    }

    private void mostrarDialogo(List<String> namesAll, List<Integer> ids) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione un contacto");

        String[] namesArray = namesAll.toArray(new String[0]);
        AtomicInteger selectedId = new AtomicInteger();

        builder.setSingleChoiceItems(namesArray, 0, (dialog, which) -> {
            selectedId.set(ids.get(which));
        });

        builder.setPositiveButton("Seleccionar", (dialog, which) -> {
            obtenerDatosContacto(selectedId.get());
            dialog.dismiss();
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> {
            dialog.dismiss();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void obtenerDatosContacto(int id) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                "http://10.0.2.2/buscar.php?id=" + id,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jsonObject = null;

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                jsonObject = response.getJSONObject(i);
                                name_et.setText(jsonObject.getString("nombre"));
                                surname_et.setText(jsonObject.getString("apellido"));
                                tlf_et.setText(jsonObject.getString("telefono"));
                            } catch (JSONException e) {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

}