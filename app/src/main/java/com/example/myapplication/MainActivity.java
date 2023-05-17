package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    EditText t_from;
    TextView t_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter <String> myadapter = new <String> ArrayAdapter (this, android.R.layout.simple_list_item_1);

        myadapter.add ("mm");
        myadapter.add ("cm");
        myadapter.add ("m");
        myadapter.add ("km");

        spinner = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        spinner.setAdapter(myadapter);
        spinner2.setAdapter(myadapter);

        t_from = findViewById(R.id.vvodZnach);
        t_result = findViewById(R.id.Otvet);
    }

    public void raschet(View v)
    {
        String str = t_from.getText().toString();
        float value = Float.parseFloat(str);

        String s_from = (String) spinner.getSelectedItem();
        String s_to = (String) spinner2.getSelectedItem();

        float x = 0.0f;

        if (s_from.equals("mm"))
        {
            if(s_to.equals("mm")) x = value * 1.0f;
            if(s_to.equals("cm")) x = value * 0.1f;
            if(s_to.equals("m")) x = value * 0.001f;
            if(s_to.equals("km")) x = value * 0.000001f;
        }
        if (s_from.equals("cm"))
        {
            if(s_to.equals("mm")) x = value * 10.0f;
            if(s_to.equals("cm")) x = value * 1.0f;
            if(s_to.equals("m")) x = value * 0.01f;
            if(s_to.equals("km")) x = value * 0.00001f;
        }
        if (s_from.equals("m"))
        {
            if(s_to.equals("mm")) x = value * 100.0f;
            if(s_to.equals("cm")) x = value * 100.0f;
            if(s_to.equals("m")) x = value * 1.0f;
            if(s_to.equals("km")) x = value * 0.0001f;
        }
        if (s_from.equals("km"))
        {
            if(s_to.equals("mm")) x = value * 1000000.0f;
            if(s_to.equals("cm")) x = value * 100000.0f;
            if(s_to.equals("m")) x = value * 100.0f;
            if(s_to.equals("km")) x = value * 1.0f;
        }

        t_result.setText(String.valueOf(x));
    }
}