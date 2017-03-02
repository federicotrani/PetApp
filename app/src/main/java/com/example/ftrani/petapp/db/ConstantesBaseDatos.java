package com.example.ftrani.petapp.db;


public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS          = "mascota";
    public static final String TABLE_PETS_ID        = "id_mascota";
    public static final String TABLE_PETS_NOMBRE    = "nombre";
    public static final String TABLE_PETS_RAZA  = "raza";
    public static final String TABLE_PETS_FOTO      = "foto";

    public static final String TABLE_LIKES_PET = "mascota_likes";
    public static final String TABLE_LIKES_PET_ID = "id_like";
    public static final String TABLE_LIKES_PET_ID_PET = "id_mascota_like";
    public static final String TABLE_LIKES_PET_NUMERO_LIKES = "numero_likes";
}
