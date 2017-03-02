package com.example.ftrani.petapp.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.ftrani.petapp.R;
import com.example.ftrani.petapp.db.BaseDatos;
import com.example.ftrani.petapp.db.ConstantesBaseDatos;
//import com.anncode.recyclerviewfragments.R;

import java.util.ArrayList;


public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return  db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerFavoritos() {
        BaseDatos db = new BaseDatos(context);

        return  db.obtenerTopFavoritos();
    }


    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "FELIX");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_RAZA, "Gato Angora");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.gato);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "FLASH");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_RAZA, "Hamster");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.hamster);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "SULTAN");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_RAZA, "Perro Fox Terrier");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "BAMBI");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_RAZA, "Ciervo Silvestre");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.ciervo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "LALO");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_RAZA, "Loro Barranquero");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.loro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "MILTON");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_RAZA, "Rana Toro");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.sapo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "REX");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_RAZA, "Tortuga Marina");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.tortuga);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
