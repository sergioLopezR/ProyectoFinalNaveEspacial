package mx.edu.ittepic.proyectofinalnaveespacial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Islas {

    Bitmap icono;
    float x, y, desplazamiento;
    private boolean visible;
    CountDownTimer timer;

    public Islas(int recurso, float _x, float _y, final Lienzo2 l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;

        timer = new CountDownTimer(1000, 30) {
            @Override
            public void onTick(long millisUntilFinished) {
                y+=desplazamiento;

                if (y>=l.getHeight()){
                    y = -100;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
    }

    public Islas(int recurso, float _x, float _y, final Lienzo l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;

        timer = new CountDownTimer(1000, 30) {
            @Override
            public void onTick(long millisUntilFinished) {
                y+=desplazamiento;

                if (y>=l.getHeight()){
                    y = -100;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
    }

    public void pintar(Canvas c, Paint p){
        if (visible) {
            c.drawBitmap(icono, x, y, p);
        }
    }


    public void moverY(float desplaza){
        this.desplazamiento = desplaza;
        timer.start();
    }

    public void hacerVisible(boolean v){
        visible = v;
    }
}
