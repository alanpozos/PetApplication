package com.alan2.petapplication.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alan2.petapplication.pojo.Mascota;
import com.alan2.petapplication.R;

import java.util.ArrayList;

/**
 * Created by Alan2 on 23/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolderholder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolderholder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolderholder.imgBtnRaiting.setImageResource(mascota.getImgBtnRaiting());
        mascotaViewHolderholder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolderholder.tvRaitingTotal.setText(Integer.toString(mascota.getRaitingTotal()));
        mascotaViewHolderholder.imgRaiting.setImageResource(mascota.getImgRaiting());

        mascotaViewHolderholder.imgBtnRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Raiteado: " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private ImageButton imgBtnRaiting;
        private TextView tvNombre;
        private TextView tvRaitingTotal;
        private ImageView imgRaiting;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota      = (ImageView) itemView.findViewById(R.id.imgMascota);
            imgBtnRaiting   = (ImageButton) itemView.findViewById(R.id.imgBtnRaiting);
            tvNombre        = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRaitingTotal   = (TextView) itemView.findViewById(R.id.tvRaitingTotal);
            imgRaiting      = (ImageView) itemView.findViewById(R.id.imgRaitingTotal);
        }
    }


}
