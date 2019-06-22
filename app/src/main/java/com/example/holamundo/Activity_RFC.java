package com.example.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_RFC extends Activity {

    Button btn_calcularRFC;
    EditText ed_curp;
    TextView tv_rfc, tv_fechaNac, tv_lugarNac;

    int con =0;
    String Curp = "MaJa910420hdfrrl05";
    String ArrayLetras[] ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String ArrayNumeros[] = {"0","1","2","3","4","5","6","7","8","9"};
    String CurpSplit[];
    boolean curpVerdadera = false;
    String str_rfc="MAJA910420", str_fechanac="20/ABRIL/1991",str_luegarNac="CIUDAD DE MEXICO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_calcularRFC = (Button)findViewById(R.id.btn_calcularrfc);
        ed_curp = (EditText)findViewById(R.id.ed_curp);
        tv_rfc =(TextView)findViewById(R.id.tv_rfc);
        tv_fechaNac =(TextView)findViewById(R.id.tv_fecha);
        tv_lugarNac =(TextView)findViewById(R.id.tv_sexo);

        btn_calcularRFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_curp.getText().toString().isEmpty()|| ed_curp.getText().toString().matches("") || ed_curp.getText().toString().equals(""))
                {
                    Toast.makeText(Activity_RFC.this, "Ingresa CURP", Toast.LENGTH_SHORT).show();
                }
                else{
                    curpVerdadera = ValidarCurp(ed_curp.getText().toString());
                    if(curpVerdadera==true)
                    {
                        CrearDatos(Curp);
                    }
                }
            }
        });


    }
    public boolean ValidarCurp(String Curp){

        // primer bucle para separar las letras y numeros
        Curp = Curp.toUpperCase();
        String CurpSplit[] = new String[Curp.length()];
        int i=0;
        while(i<Curp.length()){
            CurpSplit[i] = Curp.substring(i,i+1);
            Log.e("letras y numeros", "letras y numeros: " + CurpSplit[i]);
            i++;
        }
        // segundo bucle para comparar letras y numeros
        i=0;
        while(i<Curp.length())
        {
            int posArrayLetras=0;
            while(posArrayLetras<ArrayLetras.length) {
                if(i==0  || i==1 || i==2 || i==3 || i == 10 || i == 11 || i==12 || i==13 ||i==14 || i==15) {
                    if (CurpSplit[i].equals(ArrayLetras[posArrayLetras])) {
                        Log.e("letra encontrada ", "letra encontrada:" + CurpSplit[i]);
                        con = con +1;
                    }
                }
                posArrayLetras++;
            }
            i++;
        }

        // tercer bucle para comaprar numeros
        i=0;
        while(i<Curp.length())
        {
            int p=0;
            while(p<ArrayNumeros.length) {
                if(i==4  || i==5 || i==6 || i==7 || i == 8 || i == 9 || i==16 || i==17 ) {
                    if (CurpSplit[i].equals(ArrayNumeros[p])) {
                        Log.e("letra encontrada ", "letra encontrada:" + CurpSplit[i]);
                        con = con +1;
                    }
                }
                p++;
            }
            i++;
        }
        Log.e("valor actual: ", "valor actual : " + con);
        if(con==18){
            Log.e("curp", "TU es curp oficial");
            return true;
        }
        else{
            Log.e("curp", "Curp no oficial");
            return false;
        }
    }

    public void CrearDatos(String Curp){
     // rfc , fecha de nacimiento ,  dia, mes , año  luegar de nacimiento,  sexo;
        tv_rfc.setText(str_rfc+"");
        tv_fechaNac.setText(str_fechanac+"");
        tv_lugarNac.setText(str_luegarNac+"");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Activity_RFC.this,Activity_Menu.class);
        startActivity(intent);
        finish();
    }
}
