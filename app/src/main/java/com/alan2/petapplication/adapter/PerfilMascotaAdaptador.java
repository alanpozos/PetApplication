package com.alan2.petapplication.adapter;

import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alan2.petapplication.R;
import com.alan2.petapplication.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Alan2 on 01/07/2016.
 */
public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.PerfilViewHolder> {

    ArrayList<Mascota> perfilMascotas;
    Activity activity;

    public PerfilMascotaAdaptador(ArrayList<Mascota> perfilMascotas, Activity activity){
        this.perfilMascotas = perfilMascotas;
        this.activity = activity;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false );
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder perfilViewHolder, int position) {
        final Mascota perfilMascota = perfilMascotas.get(position);

        perfilViewHolder.imgMascota.setImageResource(perfilMascota.getFoto());
        perfilViewHolder.tvRaitingTotal.setText(Integer.toString(perfilMascota.getRaitingTotal()));
        perfilViewHolder.imgRaiting.setImageResource(perfilMascota.getImgRaiting());

    }

    @Override
    public int getItemCount() {
        return perfilMascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private TextView tvRaitingTotal;
        private ImageView imgRaiting;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            imgMascota      = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvRaitingTotal   = (TextView) itemView.findViewById(R.id.tvRaitingTotal);
            imgRaiting      = (ImageView) itemView.findViewById(R.id.imgRaitingTotal);
        }
    }
}
