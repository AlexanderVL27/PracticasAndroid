package com.example.p12_alexandervillalobos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class AdaptadorTitulares extends ArrayAdapter<Titular> {

    Titular[] datos;

    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.listitem_con_imagen, datos);
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_con_imagen, null);

        ImageView imgIcono = item.findViewById(R.id.ImgIcono);
        imgIcono.setImageResource(R.drawable.ic_launcher);

        TextView lblTitulo = item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(datos[position].getTitulo());

        return item;
    }
}

