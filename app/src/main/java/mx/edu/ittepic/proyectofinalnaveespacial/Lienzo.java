package mx.edu.ittepic.proyectofinalnaveespacial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    Nave nave, air, play, sega, puntero;
    MainActivity main;
    Alien al1, al2, al3, al4;
    Bala bala;
    Islas is1, is2, is3, is4;
    BalaAlien balaAlien, balaAlien2, balaAlien3, balaAlien4;
    String instrucion, instrucion2, score, record;

    public Lienzo(Context context) {
        super(context);

        air = new Nave(R.drawable.logo, 300, 500, this);
        play = new Nave(R.drawable.boton, 550, 900, this);
        sega = new Nave(R.drawable.sega, 50, 1500, this);
        main = (MainActivity) context;
        nave = new Nave(R.drawable.nave, 700, 1500, this);

        bala = new Bala(R.drawable.bala, 700, 1200, this, nave);

        al1 = new Alien(R.drawable.aliens, 100, 0, this);
        al2 = new Alien(R.drawable.aliens, 500, 0, this);
        al3 = new Alien(R.drawable.aliens, 800, 0, this);
        al4 = new Alien(R.drawable.aliens, 1200, 0, this);

        balaAlien = new BalaAlien(R.drawable.balaalien, 200, 50, this, al1);
        balaAlien2 = new BalaAlien(R.drawable.balaalien, 600, 50, this, al2);
        balaAlien3 = new BalaAlien(R.drawable.balaalien, 900, 50, this, al3);
        balaAlien4 = new BalaAlien(R.drawable.balaalien, 1300, 50, this, al4);

        is1 = new Islas(R.drawable.isla, 100, 100, this);
        is2 = new Islas(R.drawable.isla, 400, 100, this);
        is3 = new Islas(R.drawable.isla, 800, 100, this);
        is4 = new Islas(R.drawable.isla, 1200, 100, this);

        puntero = null;

        instrucion = "Instrucciones: Manten presionada la nave y en";
        instrucion2 = "constante movimiento hacia los lados";
        score = "SCORE  ";
        record = "RÉCORD  5000";

        is1.moverY(3);
        is2.moverY(7);
        is3.moverY(15);
        is4.moverY(10);

        al1.moverY(10);
        al2.moverY(20);
        al3.moverY(12);
        al4.moverY(25);

        balaAlien.moverY(30);
        balaAlien2.moverY(40);
        balaAlien3.moverY(32);
        balaAlien4.moverY(45);

        bala.moverY(40);


    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();

        c.drawColor(Color.parseColor("#0000FF"));

        al1.pintar(c, p);
        al2.pintar(c, p);
        al3.pintar(c, p);
        al4.pintar(c, p);

        balaAlien.pintar(c, p);
        balaAlien2.pintar(c, p);
        balaAlien3.pintar(c, p);
        balaAlien4.pintar(c, p);

        is1.pintar(c, p);
        is2.pintar(c, p);
        is3.pintar(c, p);
        is4.pintar(c, p);

        bala.pintar(c, p);
        nave.pintar(c, p);

        air.pintar(c, p);
        play.pintar(c, p);
        sega.pintar(c, p);

        p.setTextSize(70);
        p.setColor(Color.WHITE);
        c.drawText(score, 1050, 100, p);

        p.setTextSize(70);
        p.setColor(Color.WHITE);
        c.drawText(record, 100, 100, p);

        p.setTextSize(50);
        p.setColor(Color.WHITE);
        c.drawText(instrucion, 200, 1250, p);

        p.setTextSize(50);
        p.setColor(Color.WHITE);
        c.drawText(instrucion2, 530, 1350, p);


    }

    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (play.estaEnArea(xp, yp)){
                    Intent pantalla = new Intent(main, Main2Activity.class);
                    main.startActivity(pantalla);
                }

                if (nave.estaEnArea(xp, yp)){
                    puntero = nave;
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null){
                    nave.moverX(xp);
                }
                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }

        return true;
    }

}
