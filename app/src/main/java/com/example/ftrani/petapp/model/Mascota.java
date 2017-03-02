package com.example.ftrani.petapp.model;

/**
 * Created by ftrani on 19/2/17.
 */

public class Mascota implements Comparable<Mascota>{


    private int id;
    private int foto;
    private String nombre;
    private String Raza;
    private int Likes;

    public Mascota(int foto, int likes, String nombre, String raza, int id) {
        this.foto = foto;
        Likes = likes;
        this.nombre = nombre;
        Raza = raza;
        this.id = id;
    }

    public Mascota(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(Mascota o) {
        if (Likes < o.Likes) {
            return -1;
        }
        if (Likes > o.Likes) {
            return 1;
        }
        return 0;
    }
}
