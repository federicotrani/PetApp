package com.example.ftrani.petapp.vista.fragment;

import com.example.ftrani.petapp.adapter.MascotaAdaptador;
import com.example.ftrani.petapp.model.Mascota;

import java.util.ArrayList;


public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
