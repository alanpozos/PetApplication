package com.alan2.petapplication.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan2.petapplication.R;
import com.alan2.petapplication.adapter.MascotaAdaptador;
import com.alan2.petapplication.pojo.Mascota;
import com.alan2.petapplication.presentador.IRecyclerViewPrincipalFragmentPresenter;
import com.alan2.petapplication.presentador.RecyclerViewPrincipalFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewPrincipalFragment extends Fragment implements IRecyclerViewPrincipalFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewPrincipalFragmentPresenter presenter;


    public RecyclerViewPrincipalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view_principal, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewPrincipalFragmentPresenter(this, getContext());
        return v;
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perrorosa, "Nicky",R.drawable.dog_bone_48,3,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.perro, "Shumy",R.drawable.dog_bone_48,4,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.cabezera_perro, "Gibby",R.drawable.dog_bone_48,1,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Scup",R.drawable.dog_bone_48,9,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.imagen_png_de_perro_golden_by_dana198_d4qjavl, "Toby",R.drawable.dog_bone_48,6,R.drawable.dog_bone_48color));
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
