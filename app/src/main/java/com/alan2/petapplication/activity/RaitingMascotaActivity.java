package com.alan2.petapplication.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.alan2.petapplication.R;
import com.alan2.petapplication.adapter.MascotaAdaptador;
import com.alan2.petapplication.pojo.Mascota;
import com.alan2.petapplication.presentador.IRaitingMascotaActivityPresenter;
import com.alan2.petapplication.presentador.RaitingMascotaActivityPresenter;


import java.security.AccessController;
import java.util.ArrayList;

public class RaitingMascotaActivity extends AppCompatActivity implements IRaitingMascotaActivityView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaRaitingMascotas;
    private IRaitingMascotaActivityPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting_mascota);

        setToolbar();
        listaRaitingMascotas = (RecyclerView) findViewById(R.id.rvRaitingMascotas);
        //presenter = new RaitingMascotaActivityPresenter(this, getApplicationContext());


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaRaitingMascotas.setLayoutManager(llm);

        inicializarListaRaitingMascotas();
        inicializarAdapatador();

    }

    public MascotaAdaptador adaptador;
    public void inicializarAdapatador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaRaitingMascotas.setAdapter(adaptador);
    }

    public void inicializarListaRaitingMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.fdsd, "Scup",R.drawable.dog_bone_48,9,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.imagen_png_de_perro_golden_by_dana198_d4qjavl, "Toby",R.drawable.dog_bone_48,6,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.perro_2, "Gold",R.drawable.dog_bone_48,3,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.cabezera_perro, "Gibby",R.drawable.dog_bone_48,1,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.perrorosa, "Nicky",R.drawable.dog_bone_48,3,R.drawable.dog_bone_48color));
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.actionbarRaiting);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        getSupportActionBar().setTitle("Petagram");

        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.left_48black);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_raiting, menu);
        return true;
    }

    @Override
    public void generarLinearlayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaRaitingMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador  = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaRaitingMascotas.setAdapter(adaptador);
    }
}
