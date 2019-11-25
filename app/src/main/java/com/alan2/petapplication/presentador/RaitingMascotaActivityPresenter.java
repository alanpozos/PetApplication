package com.alan2.petapplication.presentador;

import android.content.Context;

import com.alan2.petapplication.activity.IRaitingMascotaActivityView;
import com.alan2.petapplication.db.ConstructorMascotas;
import com.alan2.petapplication.pojo.Mascota;

import java.lang.reflect.Array;

import java.util.ArrayList;

public class RaitingMascotaActivityPresenter implements IRaitingMascotaActivityPresenter {

    private IRaitingMascotaActivityView iRaitingMascotaActivityView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RaitingMascotaActivityPresenter(IRaitingMascotaActivityView iRaitingMascotaActivityView, Context context) {
        this.iRaitingMascotaActivityView = iRaitingMascotaActivityView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRaitingMascotaActivityView.inicializarAdaptadorRV(iRaitingMascotaActivityView.crearAdaptador(mascotas));
        iRaitingMascotaActivityView.generarLinearlayoutVertical();
    }
}
