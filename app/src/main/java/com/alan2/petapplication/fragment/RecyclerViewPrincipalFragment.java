package com.alan2.petapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan2.petapplication.R;
import com.alan2.petapplication.adapter.MascotaAdaptador;
import com.alan2.petapplication.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewPrincipalFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public RecyclerViewPrincipalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view_principal, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdapatador();
        return v;
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdapatador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perrorosa, "Nicky",R.drawable.dog_bone_48,3,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.perro, "Shumy",R.drawable.dog_bone_48,4,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.cabezera_perro, "Gibby",R.drawable.dog_bone_48,1,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Scup",R.drawable.dog_bone_48,9,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.imagen_png_de_perro_golden_by_dana198_d4qjavl, "Toby",R.drawable.dog_bone_48,6,R.drawable.dog_bone_48color));
    }
}
