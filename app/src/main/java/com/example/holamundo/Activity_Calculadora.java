package com.example.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Calculadora extends Activity {

    Button btn1, btn2, btn3,btn4, btn5,btn6, btn7, btn8, btn9, btn0;
    Button btn_suma, btn_resta, btn_mul, btn_div, btn_borrar, btn_resultado;
    TextView tv_resultado;
    int a, b, resultado;
    int ope=0;
    boolean bandera=false;
    String cadenaA = "";
    String cadenaB ="";
    String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        btn1 = (Button)findViewById(R.id.btn_1);
        btn2 = (Button)findViewById(R.id.btn_2);
        btn3 = (Button)findViewById(R.id.btn_3);
        btn4 = (Button)findViewById(R.id.btn_4);
        btn5 = (Button)findViewById(R.id.btn_5);
        btn6 = (Button)findViewById(R.id.btn_6);
        btn7 = (Button)findViewById(R.id.btn_7);
        btn8 = (Button)findViewById(R.id.btn_8);
        btn9 = (Button)findViewById(R.id.btn_9);
        btn0 = (Button)findViewById(R.id.btn_0);
        btn_suma = (Button)findViewById(R.id.btn_mas);
        btn_resta = (Button)findViewById(R.id.btn_mns);
        btn_mul = (Button)findViewById(R.id.btn_mul);
        btn_div = (Button)findViewById(R.id.btn_division);
        btn_resta = (Button)findViewById(R.id.btn_borrar);
        btn_resultado = (Button)findViewById(R.id.btn_igual);
        btn_borrar = (Button)findViewById(R.id.btn_borrar);
        tv_resultado = (TextView)findViewById(R.id.texto_res);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor ="1";
                if(bandera ==false) {
                    cadenaA = cadenaA + valor;
                }
                else if(bandera ==true)
                {
                    cadenaB = cadenaB + valor;
                }
                tv_resultado.setText(cadenaA+operador+cadenaB+"");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor ="2";
                if(bandera ==false) {
                    cadenaA = cadenaA + valor;
                }
                else if(bandera ==true)
                {
                    cadenaB = cadenaB + valor;
                }
                tv_resultado.setText(cadenaA+operador+cadenaB+"");
            }
        });
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cadenaA.equals("")){

                }else {
                    if (bandera == false) {
                        bandera = true;
                    } else if (bandera == true) {
                        bandera = false;
                    }
                    ope = 1;
                    operador = "+";
                    tv_resultado.setText(cadenaA + operador + cadenaB + "");
                }
            }
        });
        btn_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cadenaA.equals("")|| cadenaB.equals("")) {

                }
                else
                {
                    if (ope == 1) {

                        if(cadenaB.equals("")){

                        }
                        else {
                            a = Integer.parseInt(cadenaA);
                            b = Integer.parseInt(cadenaB);
                            resultado = a + b;
                            tv_resultado.setText(resultado + "");
                            cadenaA = tv_resultado.getText().toString();
                            cadenaB = "";
                            bandera = false;
                        }
                    }
                }

            }
        });
        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_resultado.setText("");
                cadenaA ="";
                cadenaB="";
                operador ="";
                ope =0;
                bandera=false;
                a=0;
                b=0;
                if(a+b==0)
                {
                    tv_resultado.setText("");
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Activity_Calculadora.this, Activity_Menu.class);
        startActivity(intent);
        finish();
    }
}
