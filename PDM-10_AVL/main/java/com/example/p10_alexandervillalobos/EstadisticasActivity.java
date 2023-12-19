package com.example.p10_alexandervillalobos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class EstadisticasActivity extends AppCompatActivity {

    private TextView tvNumeroIndividuos, tvPromedioEdad, tvJoven, tvViejo, tvPorProfesion;
    private ArrayList<Persona> listaPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        tvNumeroIndividuos = findViewById(R.id.tvNumeroIndividuos);
        tvPromedioEdad = findViewById(R.id.tvPromedioEdad);
        tvJoven = findViewById(R.id.tvJoven);
        tvViejo = findViewById(R.id.tvViejo);
        tvPorProfesion = findViewById(R.id.tvPorProfesion);

        listaPersonas = getIntent().getParcelableArrayListExtra("listaPersonas");

        // Calcular estadísticas
        calcularEstadisticas();
    }

    private void calcularEstadisticas() {
        // Número de individuos
        int numIndividuos = listaPersonas.size();
        tvNumeroIndividuos.setText("Número de Individuos: " + numIndividuos);

        // Calcular promedio de edad
        int totalEdad = 0;
        for (Persona persona : listaPersonas) {
            totalEdad += persona.getEdad();
        }
        int promedioEdad = totalEdad / numIndividuos;
        tvPromedioEdad.setText("Promedio de Edad: " + promedioEdad);

        // Encontrar al más joven y al más viejo
        Persona personaMasJoven = Collections.min(listaPersonas, (p1, p2) -> p1.getEdad() - p2.getEdad());
        Persona personaMasVieja = Collections.max(listaPersonas, (p1, p2) -> p1.getEdad() - p2.getEdad());

        tvJoven.setText("Más Joven: " + personaMasJoven.getNombre() + " (Edad: " + personaMasJoven.getEdad() + ")");
        tvViejo.setText("Más Viejo: " + personaMasVieja.getNombre() + " (Edad: " + personaMasVieja.getEdad() + ")");

        // Calcular por profesión
        int contadorBachillerato = 0, contadorLicenciatura = 0, contadorMaestria = 0, contadorDoctorado = 0;

        for (Persona persona : listaPersonas) {
            switch (persona.getGradoAcademico()) {
                case "Bachillerato":
                    contadorBachillerato++;
                    break;
                case "Licenciatura":
                    contadorLicenciatura++;
                    break;
                case "Maestría":
                    contadorMaestria++;
                    break;
                case "Doctorado":
                    contadorDoctorado++;
                    break;
            }
        }

        tvPorProfesion.setText("Por Profesión:\n" +
                "Bachillerato: " + contadorBachillerato + "\n" +
                "Licenciatura: " + contadorLicenciatura + "\n" +
                "Maestría: " + contadorMaestria + "\n" +
                "Doctorado: " + contadorDoctorado);
    }
}