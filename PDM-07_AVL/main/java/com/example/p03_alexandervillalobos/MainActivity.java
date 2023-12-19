package com.example.p03_alexandervillalobos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnBotonSimple = (Button) findViewById(R.id.BtnBotonSimple);
        TextView lblMensaje = findViewById(R.id.lblMensaje);
        ToggleButton btnToggle = findViewById(R.id.BtnToggle);


        btnBotonSimple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                lblMensaje.setText("Botón Simple pulsado!");
            }
        });
        btnToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ToggleButton x = (ToggleButton) arg0;
                if (x.isChecked()) {
                    lblMensaje.setText("Botón Toggle: ON");
                } else {
                    lblMensaje.setText("Botón Toggle: OFF");
                }
            }
        });
    }
}