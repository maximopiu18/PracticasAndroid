package com.example.holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Operaciones  {



    public static  String nombre="";
    public void Operaciones(){
        // este metodo es un contructor
    }

    public int suma(int valor1, int valor2){

        int resultado = valor1+valor2;
        return resultado;
    }

    public int resta(int valor1, int valor2){
        int resultado = valor1-valor2;
        return resultado;
    }
    public int multiplicacion(int valor1, int valor2){
        int resultado = valor1*valor2;
        return resultado;
    }
    public int division(int valor1, int valor2){
        int resultado = valor1/valor2;
        return resultado;
    }
    public int modulo(int valor1, int valor2){
        int resultado = valor1%valor2;
        return resultado;
    }

    public int ope(int v1,int v2, int opcion){
        int res =0;
        if(opcion==0) {
            res = v1+v2;
            nombre = "suma";
        }
        else if(opcion ==1){
            res = v1-v2;
            nombre = "resta";
        }
        else if(opcion ==2){
            nombre = "mul";
            res = v1*v2;
        }
        else if(opcion ==3){
            res = v1/v2;
            nombre = "div";
        }
        else if(opcion ==4){
            res = v1%v2;
            nombre = "mod";
        }
        return res;
    }

    public static void nombre(){
        Log.e("mi nombre", "mi nombre es alberto ");
    }
}
