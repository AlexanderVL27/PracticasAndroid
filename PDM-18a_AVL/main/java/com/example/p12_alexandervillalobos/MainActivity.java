package com.example.p12_alexandervillalobos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdaptadorTitularesRecyclerView adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Titular> datos = new ArrayList<>();
        datos.add(new Titular("Título 1", "Subtítulo largo 1"));
        datos.add(new Titular("Título 2", "Subtítulo largo 2"));
        datos.add(new Titular("Título 3", "Subtítulo largo 1"));
        datos.add(new Titular("Título 4", "Subtítulo largo 2"));
        datos.add(new Titular("Título 5", "Subtítulo largo 1"));
        datos.add(new Titular("Título 6", "Subtítulo largo 2"));
        datos.add(new Titular("Título 7", "Subtítulo largo 1"));
        datos.add(new Titular("Título 8", "Subtítulo largo 2"));
        datos.add(new Titular("Título 9", "Subtítulo largo 1"));
        datos.add(new Titular("Título 10", "Subtítulo largo 2"));
        datos.add(new Titular("Título 11", "Subtítulo largo 1"));
        datos.add(new Titular("Título 12", "Subtítulo largo 2"));

        adaptador = new AdaptadorTitularesRecyclerView(datos);
        recyclerView.setAdapter(adaptador);
    }
}
