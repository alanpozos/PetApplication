package com.alan2.petapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import java.util.ArrayList;

public class RaitingMascotaActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaRaitingMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting_mascota);

        setToolbar();

        listaRaitingMascotas = (RecyclerView) findViewById(R.id.rvRaitingMascotas);

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
            ab.setHomeAsUpIndicator(R.drawable.left_48);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_raiting, menu);
        return true;
    }
}
