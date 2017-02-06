package com.uninorte.evaltc2fvf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


        if (Txt1.getText().toString().isEmpty() || Txt2.getText().toString().isEmpty() || Txt3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ningun campo de nota puede estar vacio", Toast.LENGTH_LONG).show();
            return;
        }
        Float N1=Float.parseFloat(Txt1.getText().toString());
        Float N2=Float.parseFloat(Txt2.getText().toString());
        Float N3=Float.parseFloat(Txt3.getText().toString());
        if (N1 > 5 || N2 > 5 || N3 > 5) {
            Toast.makeText(this, "Ningun nota puede ser mayor de 5", Toast.LENGTH_LONG).show();
            return;
        } else {
            HelperClass Grade = new HelperClass(N1, N2, N3);
            String Final = Grade.FinalGrade();
            MyIntent = getIntent();
            MyIntent.putExtra("FinalGrade", Final);
            setResult(RESULT_OK, MyIntent);
            finish();
        }


    }
}
