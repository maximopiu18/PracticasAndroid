package com.example.holamundo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

public class Activity_Tacks extends Activity {
    MyAsyckTack tarea;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacks);
        tarea = new MyAsyckTack();
        tarea.execute("");
    }
    public class MyAsyckTack extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress = new ProgressDialog(Activity_Tacks.this);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setTitle("CARGANDO DATOS");
            progress.setMessage("ESPERA UN MOMENTO POR FAVOR NEGRO ");
            progress.setIcon(R.drawable.ic_launcher_background);
            progress.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if(progress.isShowing())
            {
                //progress.cancel();
                progress.dismiss();
/*                Intent intent = new Intent(Activity_Tacks.this, Activity_Menu.class);
                startActivity(intent);
                finish();*/
            }
        }
    }
}
