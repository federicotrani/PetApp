package com.example.ftrani.petapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ftrani.petapp.model.Mascota;

import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "(" +
                ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_RAZA + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PET + "(" +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + "(" + ConstantesBaseDatos.TABLE_PETS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_PET);
        onCreate(db);
    }



    public ArrayList<Mascota> obtenerTopFavoritos() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaza(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaza(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS,null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PET, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+")" +
                        " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}