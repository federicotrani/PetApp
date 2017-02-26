package com.example.ftrani.petapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.ftrani.petapp.adapter.MascotaAdaptador;
import com.example.ftrani.petapp.pojo.Mascota;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        iniciarListaMascotas();
        iniciarAdaptador();
    }

    public void iniciarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.loro,8,"PERICO","LORO"));
        mascotas.add(new Mascota(R.drawable.perro2,22,"FLECHA","PERRO"));
        mascotas.add(new Mascota(R.drawable.pez,4,"FISH","PEZ"));
        mascotas.add(new Mascota(R.drawable.sapo,1,"VERRUGA","SAPO"));
        mascotas.add(new Mascota(R.drawable.tortuga,5,"MANUELITA","TORTUGA"));
    }
}
