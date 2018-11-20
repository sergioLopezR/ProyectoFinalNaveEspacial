package mx.edu.ittepic.proyectofinalnaveespacial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Alien {

    Bitmap icono;
    float x, y, desplazamiento;
    private boolean visible;
    CountDownTimer timer;

    public Alien(int recurso, float _x, float _y, final Lienzo2 l){
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

    public Alien(int recurso, float _x, float _y, final Lienzo l){
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

    public void hacerVisible(boolean v){
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp){
        float x2, y2;

        if (!visible){
            return false;
        }

        x2 = x+icono.getWidth();
        y2 = y+icono.getHeight();

        if(xp>=x && xp<=x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }
        return false;
    }

    public void moverY(float desplaza){
        this.desplazamiento = desplaza;
        timer.start();
    }

    public void getY(float y) {
        this.y = y;
    }
}
