package mx.edu.ittepic.proyectofinalnaveespacial;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo2(this));
    }

    public void Inicio(){
        mediaPlayer = MediaPlayer.create(this, R.raw.principal);
        mediaPlayer.start();
    }

    public void pararInicio(){
        mediaPlayer.stop();
    }

    public void ganaste(){
        mediaPlayer = MediaPlayer.create(this, R.raw.ganador);
        mediaPlayer.start();
    }



}
