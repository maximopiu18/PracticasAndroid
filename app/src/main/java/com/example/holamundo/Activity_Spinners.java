package com.example.holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Spinners extends Activity {

    // hacer lista de el año 1500 al 2020 ;
    Spinner spinner_sexo, spinner_anio;
    ArrayAdapter<String> adapter_sexo;
    String sexos[]={"Selecciona tipo de sexo", "Masculino", "Femenino"};
    String sexo ="";

    ArrayAdapter<Integer> adapteranios;
    Integer anios[];
    ArrayList<String> lista;
    ArrayAdapter<String>adapterNumeros;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners);
        spinner_sexo  = (Spinner)findViewById(R.id.activity_spinners_spinner_sexo);
        spinner_anio  = (Spinner)findViewById(R.id.activity_spinners_fecha_nacimiento);
        adapter_sexo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sexos);
        spinner_sexo.setAdapter(adapter_sexo);

        lista = new ArrayList<String>();
        llenarLista();

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


    public void llenarLista(){
        int i =0;
        while(i<100){
            lista.add(String.valueOf(i));
            i++;
        }
        adapterNumeros = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        spinner_sexo.setAdapter(adapterNumeros);
        spinner_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombre = String.valueOf(lista.get(position));
                Log.e("nombre: " , "nombre: " + nombre);
                if(position==0)
                {
                    int i =0;
                    while(i<101) {
                        if(lista.size()>1) {
                            lista.remove(i);
                        }
                        else
                        {
                            break;
                        }
                        i++;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
