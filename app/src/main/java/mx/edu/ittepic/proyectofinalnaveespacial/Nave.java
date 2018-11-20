package mx.edu.ittepic.proyectofinalnaveespacial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Nave {

    Bitmap icono;
    float x, y;
    private boolean visible;

    public Nave(int recurso, float _x, float _y, Lienzo2 l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public Nave(int recurso, float _x, float _y, Lienzo l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
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

    public void moverX(float xp){
        x = xp - icono.getHeight()/2;
    }

    public boolean colision(Alien objetoB){
        float x2 = x + icono.getWidth();
        float y2 = y + icono.getHeight();

        if (objetoB.estaEnArea(x2, y)){
            //revisando caso 1
            return  true;
        }

        if (objetoB.estaEnArea(x, y)){
            //revisando caso 2
            return  true;
        }

        if (objetoB.estaEnArea(x2, y2)) {
            //revisando caso 3
            return true;
        }

        if (objetoB.estaEnArea(x, y2)) {
            //revisando caso 4
            return true;
        }
        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
