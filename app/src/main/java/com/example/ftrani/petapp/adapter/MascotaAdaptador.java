package com.example.ftrani.petapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ftrani.petapp.model.ConstructorMascotas;
import com.example.ftrani.petapp.model.Mascota;
import com.example.ftrani.petapp.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.txtNombre.setText(mascota.getNombre());
        mascotaViewHolder.txtRaza.setText(mascota.getRaza());
        mascotaViewHolder.txtLikes.setText(String.valueOf(mascota.getLikes())+" Likes");

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorMascotas constructorMascotas= new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.txtLikes.setText(constructorMascotas.obtenerLikesContacto(mascota) + " Likes");


            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView txtNombre;
        private TextView txtLikes;
        private TextView txtRaza;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtLikes = (TextView) itemView.findViewById(R.id.txtLikes);
            txtRaza = (TextView) itemView.findViewById(R.id.txtRaza);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
        }


    }


}
