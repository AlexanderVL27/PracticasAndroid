package com.example.p11_alexandervillalobos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner cmbOpciones;
    private TextView lblMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.valores_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmbOpciones = (Spinner) findViewById(R.id.CmbOpciones);
        cmbOpciones.setAdapter(adapter);

        lblMensaje = (TextView) findViewById(R.id.lblMensaje);

        cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                lblMensaje.setText("Seleccionado: " + parent.getItemAtPosition(position));
            }

            public void onNothingSelected(AdapterView<?> parent) {
                lblMensaje.setText("");
            }
        });
    }
}