package com.example.p15_alexandervillalobos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etEdad;
    private RadioGroup rgSexo, rgGradosAcademicos;
    private RadioButton rbHombre, rbMujer, rbBachillerato, rbLicenciatura, rbMaestria, rbDoctorado;
    private CheckBox cbNacionalidad;
    private Button btnAgregar, btnEstadisticas;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        rgSexo = findViewById(R.id.rgSexo);
        rbHombre = findViewById(R.id.rbHombre);
        rbMujer = findViewById(R.id.rbMujer);
        rgGradosAcademicos = findViewById(R.id.rgGradosAcademicos);
        rbBachillerato = findViewById(R.id.rbBachillerato);
        rbLicenciatura = findViewById(R.id.rbLicenciatura);
        rbMaestria = findViewById(R.id.rbMaestria);
        rbDoctorado = findViewById(R.id.rbDoctorado);
        cbNacionalidad = findViewById(R.id.cbNacionalidad);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnEstadisticas = findViewById(R.id.btnEstadisticas);
        listView = findViewById(R.id.listView);

        // Crea un adaptador personalizado
        PersonaAdapter adapter = new PersonaAdapter(this, listaPersonas);

        // Establece el adaptador en el ListView
        listView.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener valores de los campos
                String nombre = etNombre.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                boolean nacionalidad = cbNacionalidad.isChecked();
                String sexo = (rgSexo.getCheckedRadioButtonId() == R.id.rbHombre) ? "Hombre" : "Mujer";
                String gradoAcademico = obtenerGradoAcademico();

                // Crear una nueva persona y agregarla a la lista
                Persona persona = new Persona(nombre, edad, sexo, nacionalidad, gradoAcademico);
                listaPersonas.add(persona);

                // Limpiar los campos
                etNombre.setText("");
                etEdad.setText("");
                rgSexo.clearCheck();
                cbNacionalidad.setChecked(false);
                rgGradosAcademicos.clearCheck();

                // Notificar al adaptador sobre el cambio en los datos
                adapter.notifyDataSetChanged();
            }
        });

        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar una nueva actividad para mostrar las estadísticas
                Intent intent = new Intent(MainActivity.this, EstadisticasActivity.class);
                intent.putParcelableArrayListExtra("listaPersonas", listaPersonas);
                startActivity(intent);
            }
        });
    }

    private String obtenerGradoAcademico() {
        if (rbBachillerato.isChecked()) {
            return "Bachillerato";
        } else if (rbLicenciatura.isChecked()) {
            return "Licenciatura";
        } else if (rbMaestria.isChecked()) {
            return "Maestría";
        } else if (rbDoctorado.isChecked()) {
            return "Doctorado";
        } else {
            return "";
        }
    }
}
