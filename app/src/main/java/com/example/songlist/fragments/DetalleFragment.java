package com.example.songlist.fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.songlist.Aplicacion;
import com.example.songlist.Cancion;
import com.example.songlist.R;

import java.io.IOException;

public class DetalleFragment extends Fragment implements View.OnTouchListener, MediaPlayer.OnPreparedListener,
        MediaController.MediaPlayerControl {
    public static String ARG_ID_CANCION = "id_cancion";
    MediaPlayer mediaPlayer;
    MediaController mediaController;

    @Override public View onCreateView(LayoutInflater inflador, ViewGroup contenedor, Bundle savedInstanceState) {
        View vista = inflador.inflate(R.layout.fragment_detalle, contenedor, false);
        Bundle args = getArguments();
        if (args != null) {
            int position = args.getInt(ARG_ID_CANCION);
            ponInfoCancion(position, vista);
        } else {
            ponInfoCancion(0, vista);
        }
        return vista;
    }
    private void ponInfoCancion(int id, View vista) {
        Cancion cancion = ((Aplicacion) getActivity().getApplication()).getVectorCanciones().elementAt(id);
        ((TextView) vista.findViewById(R.id.titulo)).setText(cancion.titulo);
        ((TextView) vista.findViewById(R.id.autor)).setText(cancion.autor);
        ((ImageView) vista.findViewById(R.id.portada))
                .setImageResource(cancion.recursoImagen);
        vista.setOnTouchListener(this);
        if (mediaPlayer != null){
            mediaPlayer.release();
        }
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaController = new MediaController(getActivity());
        Uri audio = Uri.parse(cancion.urlAudio);
        try {
            mediaPlayer.setDataSource(getActivity(), audio);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            Log.e("SongList", "ERROR: No se puede reproducir "+audio,e);
        }
    }
    public void ponInfoCancion(int id) {
        ponInfoCancion(id, getView());
    }
    @Override public void onPrepared(MediaPlayer mediaPlayer) {
        Log.d("SongList", "Entramos en onPrepared de MediaPlayer");
        mediaPlayer.start();
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(getView().findViewById(
                R.id.fragment_detalle));
        mediaController.setEnabled(true);
        mediaController.show();
    }
    @Override public boolean onTouch(View vista, MotionEvent evento) {
        mediaController.show();
        return false;
    }
    @Override public void onStop() {
        mediaController.hide();
        try {
            mediaPlayer.stop();
            mediaPlayer.release();
        } catch (Exception e) {
            Log.d("SongList", "Error en mediaPlayer.stop()");
        }
        super.onStop();
    }

    @Override public boolean canPause() { return true; }
    @Override public boolean canSeekBackward() { return true; }
    @Override public boolean canSeekForward() { return true;  }
    @Override public int getBufferPercentage() { return 0; }
    @Override public int getCurrentPosition() {
        try {
            return mediaPlayer.getCurrentPosition();
        } catch (Exception e) {
            return 0;
        }
    }
    @Override public int getDuration() { return mediaPlayer.getDuration(); }
    @Override public boolean isPlaying() { return mediaPlayer.isPlaying(); }
    @Override public void pause() { mediaPlayer.pause(); }
    @Override public void seekTo(int pos) { mediaPlayer.seekTo(pos); }
    @Override public void start() { mediaPlayer.start(); }
    @Override public int getAudioSessionId() { return 0; }
}