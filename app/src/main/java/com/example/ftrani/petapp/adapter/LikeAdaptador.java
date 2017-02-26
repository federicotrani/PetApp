package com.example.ftrani.petapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ftrani.petapp.R;
import com.example.ftrani.petapp.pojo.Like;

import java.util.ArrayList;

/**
 * Created by ftrani on 25/2/17.
 */

public class LikeAdaptador extends RecyclerView.Adapter<LikeAdaptador.LikeViewHolder> {

    ArrayList<Like> likes;

    public LikeAdaptador(ArrayList<Like> likes){
        this.likes = likes;
    }

    @Override
    public LikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_like, parent, false);
        return new LikeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LikeViewHolder holder, int position) {
        Like like = likes.get(position);

        holder.imgFoto.setImageResource(like.getFoto());
        holder.txtLikes.setText(String.valueOf(like.getLikes()));
    }

    @Override
    public int getItemCount() {
        return likes.size();
    }

    public static class LikeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView txtLikes;

        public LikeViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            txtLikes = (TextView) itemView.findViewById(R.id.txtLikes);
        }
    }
}
