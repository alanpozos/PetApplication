package com.alan2.petapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan2.petapplication.R;
import com.alan2.petapplication.adapter.MascotaAdaptador;
import com.alan2.petapplication.adapter.PerfilMascotaAdaptador;
import com.alan2.petapplication.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    public PerfilMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdapatador();
        return v;
    }

    public PerfilMascotaAdaptador adaptador;
    public void inicializarAdapatador(){
        adaptador = new PerfilMascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,3,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,4,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,1,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,9,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,6,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,3,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,4,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,1,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,9,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Shumy",R.drawable.dog_bone_48,6,R.drawable.dog_bone_48color));
    }

}
