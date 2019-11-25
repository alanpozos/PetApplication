package com.alan2.petapplication.activity;

import com.alan2.petapplication.adapter.MascotaAdaptador;
import com.alan2.petapplication.pojo.Mascota;

import java.util.ArrayList;

public interface IRaitingMascotaActivityView {

    public void generarLinearlayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
