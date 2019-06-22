package com.example.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Menu extends Activity {

    Button btn_calculadora, btn_rfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_calculadora = (Button)findViewById(R.id.btn_calculadora);
        btn_rfc = (Button)findViewById(R.id.btn_rfc);

        btn_calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this,Activity_Calculadora.class);
                startActivity(intent);
                finish();
            }
        });
        btn_rfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this,Activity_RFC.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
