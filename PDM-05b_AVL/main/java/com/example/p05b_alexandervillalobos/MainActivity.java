package com.example.p05b_alexandervillalobos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);

        String opciones1 [] = {"File"};
        String opciones2 [] = {"Tools"};
        String opciones3 [] = {"Help"};

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones1);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones2);
        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones3);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        String conversion1 [] = {"EUR-Euro", "USD-U.S. Dollar"};
        String conversion2 [] = {"USD-U.S. Dollar", "EUR-Euro"};

        ArrayAdapter adapterconv1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, conversion1);
        ArrayAdapter adapterconv2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, conversion2);

        spinner4.setAdapter(adapterconv1);
        spinner5.setAdapter(adapterconv2);
    }
}