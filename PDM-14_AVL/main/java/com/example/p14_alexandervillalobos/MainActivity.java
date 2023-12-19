package com.example.p14_alexandervillalobos;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GridView grdOpciones;
    private TextView lblMensaje;
    private String[] datos = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grdOpciones = findViewById(R.id.GridOpciones);
        lblMensaje = findViewById(R.id.lblMensaje);

        for (int i = 1; i <= 50; i++)
            datos[i - 1] = "Dato " + i;

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);

        grdOpciones.setAdapter(adaptador);

        grdOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                lblMensaje.setText("Opción seleccionada: "
                        + parent.getItemAtPosition(position));
            }
        });
    }
}
