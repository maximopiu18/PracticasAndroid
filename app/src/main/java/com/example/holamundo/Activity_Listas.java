package com.example.holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Activity_Listas extends Activity {

    ListView lista;
    ArrayAdapter<String> adapterPaises;
    String paises []={
            "Mexico",
            "Argentina",
            "España",
            "Colombia",
            "Ecuador",
            "Estados Unidos",
            "Canada",
            "Brasil",
            "Chile",
            "Peru",
            "Alemania",
            "Francia",
            "Wakanda",
            "Inglaterra"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        lista = (ListView)findViewById(R.id.activity_listas_lista);
        adapterPaises = new ArrayAdapter<String>(Activity_Listas.this, android.R.layout.simple_list_item_1,paises);
        lista.setAdapter(adapterPaises);
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
