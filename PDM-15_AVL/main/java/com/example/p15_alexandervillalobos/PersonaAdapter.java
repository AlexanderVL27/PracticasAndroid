package com.example.p15_alexandervillalobos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class PersonaAdapter extends ArrayAdapter<Persona> {

    private Context context;
    private ArrayList<Persona> personas;

    public PersonaAdapter(Context context, ArrayList<Persona> personas) {
        super(context, 0, personas);
        this.context = context;
        this.personas = personas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView nombreTextView = view.findViewById(R.id.nombreTextView);
        TextView edadTextView = view.findViewById(R.id.edadTextView);

        Persona persona = personas.get(position);

        // Aquí debes cargar la imagen desde tu recurso o servidor
        // Por ahora, estamos usando una imagen predeterminada
        imageView.setImageResource(R.drawable.ic_launcher);

        // Establece el nombre en el TextView
        nombreTextView.setText("Nombre: " + persona.getNombre());

        // Establece la edad en el TextView
        edadTextView.setText("Edad: " + persona.getEdad());

        return view;
    }
}
