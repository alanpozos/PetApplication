package com.alan2.petapplication.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.alan2.petapplication.pojo.Mascota;

import java.security.PublicKey;
import java.util.ArrayList;

public class BaseDatos  extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                                        ")";

        String queryCrearTablaRaitingMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA + "(" +
                                                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + " INTEGER, " +
                                                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_TOTAL + " INTEGER, " +
                                                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + ") " +
                                                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                                                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaRaitingMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setIdMascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryRaiting = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_TOTAL + ") as raiting " +
                                    " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA +
                                    " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getIdMascota();

            Cursor registrosRaiting = db.rawQuery(queryRaiting, null);
            if (registrosRaiting.moveToNext()){
                mascotaActual.setRaitingTotal(registrosRaiting.getInt(0));
            } else {
                mascotaActual.setRaitingTotal(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();

//      VALIDACION PARA NO AGREGAR LAS MASCOTAS REPETIDAMENTE
        Cursor cursor = db.rawQuery("SELECT * FROM mascota WHERE nombre = 'Toby'", null);
        if (!cursor.moveToNext()){
            db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
            db.close();
        }
    }

    public void insertarRaitingMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAITING_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerRaitingMascota(Mascota mascota){
        int raiting = 0;
        String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_TOTAL + ")" +
                        " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + "=" + mascota.getIdMascota();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            raiting = registros.getInt(0);
        }

        db.close();
        return raiting;

    }
}
