package com.example.p12_alexandervillalobos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lstOpciones;
    private TextView lblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Titular[] datos = new Titular[]{
                new Titular("Título 1", "Subtítulo largo 1"),
                new Titular("Título 2", "Subtítulo largo 2"),
                new Titular("Título 3", "Subtítulo largo 3"),
                new Titular("Título 4", "Subtítulo largo 4"),
                //... Agrega más elementos según sea necesario
                new Titular("Título 15", "Subtítulo largo 15")
        };

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this, datos);

        lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lblMensaje = findViewById(R.id.lblMensaje);

        View header = getLayoutInflater().inflate(R.layout.list_header, null);
        lstOpciones.addHeaderView(header);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView t = view.findViewById(R.id.LblTitulo);
                String item = "[Short Click]" + t.getText().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
            }
        });

        lstOpciones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View v, int index, long arg3) {
                String str = ((Titular) lstOpciones.getItemAtPosition(index)).getSubtitulo();
                String item = "[Long Click]" + str;
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}