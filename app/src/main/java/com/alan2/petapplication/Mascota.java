package com.alan2.petapplication;

/**
 * Created by Alan2 on 23/06/2016.
 */
public class Mascota {

    private int foto;
    private int imgBtnRaiting;
    private String nombre;
    private int RaitingTotal;
    private int imgRaiting;

    public Mascota(int foto, String nombre, int imgBtnRaiting, int raiting, int imgRaiting) {
        this.foto = foto;
        this.nombre = nombre;
        this.imgBtnRaiting = imgBtnRaiting;
        this.imgRaiting = imgRaiting;
        this.RaitingTotal = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getImgBtnRaiting() {
        return imgBtnRaiting;
    }

    public void setImgBtnRaiting(int imgBtnRaiting) {
        this.imgBtnRaiting = imgBtnRaiting;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaitingTotal() {
        return RaitingTotal;
    }

    public void setRaitingTotal(int raitingTotal) {
        RaitingTotal = raitingTotal;
    }

    public int getImgRaiting() {
        return imgRaiting;
    }

    public void setImgRaiting(int imgRaiting) {
        this.imgRaiting = imgRaiting;
    }
}
