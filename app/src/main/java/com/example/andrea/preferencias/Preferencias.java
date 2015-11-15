package com.example.andrea.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Preferencias extends Activity {

    Button guardar, recuperar;
    EditText nombre, dni, fecha, sexo;
    static final String PREFERENCIAS = "preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        guardar = (Button) findViewById(R.id.bGuardar);
        recuperar = (Button) findViewById(R.id.bRecuperar);
        nombre = (EditText) findViewById(R.id.tv_nombre);
        dni = (EditText) findViewById(R.id.tv_dni);
        fecha = (EditText) findViewById(R.id.tv_date);
        sexo = (EditText) findViewById(R.id.tv_sexo);

        //dentro del boton guardar creo las preferencias
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creacion de preferencia
                SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCIAS, Activity.MODE_PRIVATE);

                //editor de preferencias
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //guardamos nuevos valores
                editor.putString("nombre",nombre.getText().toString());
                editor.putString("dni", dni.getText().toString());
                editor.putString("fecha", fecha.getText().toString());
                //datepicker

                editor.putString("sexo",sexo.getText().toString());

                //guardamos los cambios
                editor.commit();
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Preferencias.this, RecuperacionDatos.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferencias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
