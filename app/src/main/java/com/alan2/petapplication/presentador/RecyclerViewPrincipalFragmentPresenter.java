package com.alan2.petapplication.presentador;

import android.content.Context;
import com.alan2.petapplication.db.ConstructorMascotas;
import com.alan2.petapplication.fragment.IRecyclerViewPrincipalFragmentView;
import com.alan2.petapplication.pojo.Mascota;
import java.util.ArrayList;

public class RecyclerViewPrincipalFragmentPresenter implements IRecyclerViewPrincipalFragmentPresenter {

    private IRecyclerViewPrincipalFragmentView iRecyclerViewPrincipalFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewPrincipalFragmentPresenter(IRecyclerViewPrincipalFragmentView iRecyclerViewPrincipalFragmentView, Context context) {
        this.iRecyclerViewPrincipalFragmentView = iRecyclerViewPrincipalFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewPrincipalFragmentView.inicializarAdaptadorRV(iRecyclerViewPrincipalFragmentView.crearAdaptador(mascotas));
        iRecyclerViewPrincipalFragmentView.generarLinearLayoutVertical();
    }
}
