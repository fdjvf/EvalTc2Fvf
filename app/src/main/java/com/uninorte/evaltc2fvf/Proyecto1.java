package com.uninorte.evaltc2fvf;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Proyecto1 extends AppCompatActivity {
    Intent MyIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto1);


        TextView Title=(TextView)findViewById(R.id.TitleProyect);
        MyIntent=getIntent();
        Title.setText(MyIntent.getStringExtra("Title"));
    }

    public void FinalGrade(View view) {
        EditText Txt1=((EditText)findViewById(R.id.FuncText));
        EditText Txt2=((EditText)findViewById(R.id.PresText));
        EditText Txt3=((EditText)findViewById(R.id.UsaText));

        Float N1=Float.parseFloat(Txt1.getText().toString());
        Float N2=Float.parseFloat(Txt2.getText().toString());
        Float N3=Float.parseFloat(Txt3.getText().toString());
        HelperClass Grade=new HelperClass(N1,N2,N3);
         String Final=Grade.FinalGrade();
        MyIntent=getIntent();
        MyIntent.putExtra("FinalGrade",Final);

        setResult(RESULT_OK,MyIntent);
        finish();

    }
}
