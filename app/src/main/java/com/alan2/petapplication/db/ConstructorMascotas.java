package com.alan2.petapplication.db;

import android.content.ContentValues;
import android.content.Context;

import com.alan2.petapplication.R;
import com.alan2.petapplication.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int RAITING = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perrorosa, "Nicky",R.drawable.dog_bone_48,3,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.perro, "Shumy",R.drawable.dog_bone_48,4,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.cabezera_perro, "Gibby",R.drawable.dog_bone_48,1,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.fdsd, "Scup",R.drawable.dog_bone_48,9,R.drawable.dog_bone_48color));
        mascotas.add(new Mascota(R.drawable.imagen_png_de_perro_golden_by_dana198_d4qjavl, "Toby",R.drawable.dog_bone_48,6,R.drawable.dog_bone_48color));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarCincoMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Nicky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrorosa);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Shumy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Scup");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.cabezera_perro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Gibby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.fdsd);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Beans");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrorosa);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pelusa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Toby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.imagen_png_de_perro_golden_by_dana198_d4qjavl);

        db.insertarMascota(contentValues);
    }

    public void darRaitingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA, mascota.getIdMascota());
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTA_TOTAL, RAITING);
        db.insertarRaitingMascota(contentValues);
    }

    public int obtenerRaitingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRaitingMascota(mascota);
    }

}
