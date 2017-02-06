package com.uninorte.evaltc2fvf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent MyIntent;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       spinner  = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ProyectArray, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void NavigateToPr1(View view) {
        int Opc=(int)spinner.getSelectedItemId();
        MyIntent=new Intent(this,Proyecto1.class);
        String NameProyect="";
       switch (Opc)
       {
           case 0:
                NameProyect="Evaluar Proyecto 1";
               break;
           case 1:
               NameProyect="Evaluar Proyecto 2";
               break;
           case 2:
               NameProyect="Evaluar Proyecto 3";
               break;
           case 3:
               NameProyect="Evaluar Proyecto 4";
               break;
       }

        MyIntent.putExtra("Title",NameProyect);
        startActivityForResult(MyIntent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int Opc = (int) spinner.getSelectedItemId();
            TextView T = null;
            data.getStringExtra("FinalGrade");
            String Response = "Proyecto ";
            switch (Opc) {
                case 0:
                    Response = Response + "1: " + data.getStringExtra("FinalGrade");
                    T = (TextView) findViewById(R.id.ShowGrade1);
                    break;
                case 1:
                    Response = Response + "2: " + data.getStringExtra("FinalGrade");
                    T = (TextView) findViewById(R.id.ShowGrade2);
                    break;
                case 2:
                    Response = Response + "3: " + data.getStringExtra("FinalGrade");
                    T = (TextView) findViewById(R.id.ShowGrade3);
                    break;
                case 3:
                    Response = Response + "4: " + data.getStringExtra("FinalGrade");
                    T = (TextView) findViewById(R.id.ShowGrade4);
                    break;
            }
            T.setText(Response);
        }
    }






}
