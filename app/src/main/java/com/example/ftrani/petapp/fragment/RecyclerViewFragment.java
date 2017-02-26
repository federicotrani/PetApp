package com.example.ftrani.petapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import com.example.ftrani.petapp.R;
import com.example.ftrani.petapp.adapter.MascotaAdaptador;
import com.example.ftrani.petapp.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment{

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        iniciarListaMascotas();
        iniciarAdaptador();

        return v;
    }

    public void iniciarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);
    }

    public void iniciarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.ciervo,15,"BAMBI","CIERVO"));
        mascotas.add(new Mascota(R.drawable.gato,8,"RONRON","GATO"));
        mascotas.add(new Mascota(R.drawable.hamster,11,"TOBIAS","HASMTER"));
        mascotas.add(new Mascota(R.drawable.loro,8,"PERICO","LORO"));
        mascotas.add(new Mascota(R.drawable.perro2,22,"FLECHA","PERRO"));
        mascotas.add(new Mascota(R.drawable.pez,4,"FISH","PEZ"));
        mascotas.add(new Mascota(R.drawable.sapo,1,"VERRUGA","SAPO"));
        mascotas.add(new Mascota(R.drawable.tortuga,5,"MANUELITA","TORTUGA"));
    }
}
