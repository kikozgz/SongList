package com.example.songlist;

import java.util.Vector;

public class Cancion {

    //Atributos principales del objeto Cancion
    public String titulo;
    public String autor;
    public int recursoImagen;
    public String urlAudio;
    public String genero;       // Género musical
    public Boolean novedad;     // Es una novedad
    public Boolean escuchado;   // escuchado por el usuario

    //Strings constantes que definen los géneros
    public final static String G_TODOS = "Todos los géneros";
    public final static String G_ROCK = "Rock, R&R y Metal ";
    public final static String G_CLASICO = "Música clásica";
    public final static String G_INDIE = "Genero indie";

    //Array que contiene todos los géneros
    public final static String[] G_ARRAY = new String[] {G_TODOS, G_ROCK,
            G_CLASICO, G_INDIE };

    //Constructor para crear un objeto canción con sus atributos
    public Cancion(String titulo, String autor, int recursoImagen,
                 String urlAudio, String genero, Boolean novedad, Boolean escuchado) {
        this.titulo = titulo; this.autor = autor;
        this.recursoImagen = recursoImagen; this.urlAudio = urlAudio;
        this.genero = genero; this.novedad = novedad; this.escuchado = escuchado;
    }

    //Vector con canciones de ejemplo
    public static Vector<Cancion> ejemploCanciones() {
        final String SERVIDOR =
                "https://audionautix.com/Music//";
        Vector<Cancion> Canciones = new Vector<Cancion>();

        Canciones.add(new Cancion("Falling Sky", "Jason",
                R.drawable.falling, SERVIDOR+"FallingSky.mp3",
                Cancion.G_INDIE, false, false));

        Canciones.add(new Cancion("Atlantis", "Jason",
                R.drawable.atlantis, SERVIDOR+"Atlantis.mp3",
                Cancion.G_INDIE, false, false));

        Canciones.add(new Cancion("Dark Mistery", "Allan",
                R.drawable.darkmistery, SERVIDOR+"DarkMystery.mp3",
                Cancion.G_ROCK, false, false));

        Canciones.add(new Cancion("Happy Ukelele", "Jerry",
                R.drawable.happyukelele, SERVIDOR+"HappyUkulele.mp3",
                Cancion.G_CLASICO, false, false));

        Canciones.add(new Cancion("Wait in Tijuana", "Jason",
                R.drawable.waitintijuana, SERVIDOR+"WaitInTijuana%20.mp3",
                Cancion.G_INDIE, false, false));

        Canciones.add(new Cancion("Dark Mistery", "Allan",
                R.drawable.darkmistery, SERVIDOR+"DarkMystery.mp3",
                Cancion.G_ROCK, false, false));

        return Canciones;
    }


}
