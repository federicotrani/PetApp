package com.example.ftrani.petapp.pojo;

/**
 * Created by ftrani on 19/2/17.
 */

public class Mascota {
    private int foto;
    private String nombre;
    private String Raza;
    private int Likes;

    public Mascota(int foto, int likes, String nombre, String raza) {
        this.foto = foto;
        Likes = likes;
        this.nombre = nombre;
        Raza = raza;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }
}
