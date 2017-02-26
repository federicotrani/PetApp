package com.example.ftrani.petapp.pojo;

/**
 * Created by ftrani on 25/2/17.
 */

public class Like {
    private int foto;
    private int likes;

    public Like(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
