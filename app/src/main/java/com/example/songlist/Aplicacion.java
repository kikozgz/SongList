package com.example.songlist;

import android.app.Application;

import java.util.Vector;

public class Aplicacion extends Application {
    private Vector<Cancion> vectorCanciones;
    private AdaptadorCanciones adaptador;

    @Override
    public void onCreate() {
        super.onCreate();
        vectorCanciones = Cancion.ejemploCanciones();
        adaptador = new AdaptadorCanciones(this, vectorCanciones);
    }
    public AdaptadorCanciones getAdaptador() {
        return adaptador;
    }
    public Vector<Cancion> getVectorCanciones() {
        return vectorCanciones;
    }
}