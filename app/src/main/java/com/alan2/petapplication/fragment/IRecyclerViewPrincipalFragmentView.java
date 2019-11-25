package com.alan2.petapplication.fragment;

import com.alan2.petapplication.adapter.MascotaAdaptador;
import com.alan2.petapplication.pojo.Mascota;
import java.util.ArrayList;

public interface IRecyclerViewPrincipalFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
