package com.example.ftrani.petapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.ftrani.petapp.adapter.MascotaAdaptador;
import com.example.ftrani.petapp.model.Mascota;
import com.example.ftrani.petapp.model.ConstructorMascotas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> listaMascotas;
    private RecyclerView rvMascotas;
    private ConstructorMascotas constructorMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        iniciarListaMascotas();
        iniciarAdaptador();
    }

    public void iniciarAdaptador(){

        //Asigno ordern inverso por likes de la lista de mascotas
        Comparator<Mascota> comparador = Collections.reverseOrder();
        Collections.sort(listaMascotas, comparador);

        ArrayList<Mascota> topFive = new ArrayList<Mascota>(listaMascotas.subList(0,4));

        //Solo mantengo los 5 primeros => Top 5
        MascotaAdaptador adaptador = new MascotaAdaptador(topFive, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void iniciarListaMascotas(){

        constructorMascotas = new ConstructorMascotas(getBaseContext());

        listaMascotas = constructorMascotas.obtenerFavoritos();


    }
}
