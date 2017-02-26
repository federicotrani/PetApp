package com.example.ftrani.petapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ftrani.petapp.R;
import com.example.ftrani.petapp.adapter.LikeAdaptador;
import com.example.ftrani.petapp.pojo.Like;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Like> likes;
    private RecyclerView rvMiMascota;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        glm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMiMascota.setLayoutManager(glm);

        iniciarListaMascotas();
        iniciarAdaptador();

        return v;
    }

    public void iniciarAdaptador(){
        LikeAdaptador adaptador = new LikeAdaptador(likes);
        rvMiMascota.setAdapter(adaptador);
    }

    public void iniciarListaMascotas(){
        likes = new ArrayList<Like>();


        likes.add(new Like(R.drawable.perro2,8));
        likes.add(new Like(R.drawable.perro2,0));
        likes.add(new Like(R.drawable.perro2,5));
        likes.add(new Like(R.drawable.perro2,13));
        likes.add(new Like(R.drawable.perro2,1));
        likes.add(new Like(R.drawable.perro2,7));
        likes.add(new Like(R.drawable.perro2,3));
        likes.add(new Like(R.drawable.perro2,4));
        likes.add(new Like(R.drawable.perro2,0));
        likes.add(new Like(R.drawable.perro2,5));
        likes.add(new Like(R.drawable.perro2,16));
        likes.add(new Like(R.drawable.perro2,3));
        likes.add(new Like(R.drawable.perro2,1));


    }

}
