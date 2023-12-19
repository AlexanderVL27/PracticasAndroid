package com.example.p12_alexandervillalobos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorTitularesRecyclerView extends RecyclerView.Adapter<AdaptadorTitularesRecyclerView.TitularViewHolder> {

    private List<Titular> datos;

    public AdaptadorTitularesRecyclerView(List<Titular> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public TitularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_titular_recycler, parent, false);
        return new TitularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TitularViewHolder holder, int position) {
        Titular titular = datos.get(position);
        holder.lblTitulo.setText(titular.getTitulo());
        holder.lblSubTitulo.setText(titular.getSubtitulo());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    static class TitularViewHolder extends RecyclerView.ViewHolder {
        TextView lblTitulo;
        TextView lblSubTitulo;

        public TitularViewHolder(@NonNull View itemView) {
            super(itemView);
            lblTitulo = itemView.findViewById(R.id.LblTitulo);
            lblSubTitulo = itemView.findViewById(R.id.LblSubTitulo);
        }
    }
}
