package com.example.holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_Spinners extends Activity {

    // hacer lista de el año 1500 al 2020 ;
    Spinner spinner_sexo, spinner_anio;
    ArrayAdapter<String> adapter_sexo;
    String sexos[]={"Selecciona tipo de sexo", "Masculino", "Femenino"};
    String sexo ="";

    ArrayAdapter<Integer> adapteranios;
    Integer anios[];


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners);
        spinner_sexo  = (Spinner)findViewById(R.id.activity_spinners_spinner_sexo);
        spinner_anio  = (Spinner)findViewById(R.id.activity_spinners_fecha_nacimiento);
        adapter_sexo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sexos);
        spinner_sexo.setAdapter(adapter_sexo);

        spinner_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("posicion", "posicion" + position);
                Log.e( "item", "seleccionaste: " + sexos[position]);
                if(position!=0)
                {
                    sexo  = sexos[position];
                    Log.e( "sexo", "sexo: " + sexo);
                    Toast.makeText(Activity_Spinners.this,"el sexo es: " + sexo, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        crear_anios();


    }

    public void crear_anios() {
        //520;

        anios  = new Integer[121];
        int i =0;
        while(i<anios.length){
            anios[i] = 1900+i;
            i++;
        }
        adapteranios = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, anios);
        spinner_anio.setAdapter(adapteranios);
        spinner_anio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.e("anio", "anio seleccionado: " + anios[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
