package mx.edu.ittepic.proyectofinalnaveespacial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {

    Nave nave, fin, nuevo, puntero, ganaste, ganador;
    Main2Activity main, sonidoPricipal;
    Alien al1, al2, al3, al4;
    Bala bala, punteroBala;
    Islas is1, is2, is3, is4;
    BalaAlien balaAlien, balaAlien2, balaAlien3, balaAlien4, punteroBalaAlien, punteroBalaAlien2, punteroBalaAlien3, punteroBalaAlien4;
    int punt = 0;
    String score, record;

    public Lienzo2(Context context) {
        super(context);

        nave = new Nave(R.drawable.nave, 700, 1500, this);
        fin = new Nave(R.drawable.fin, 500, 550, this);
        nuevo = new Nave(R.drawable.nuevo, 620, 1000, this);
        ganaste = new Nave(R.drawable.ganaste, 200, 700, this);
        ganador = new Nave(R.drawable.nave, 700, 1500, this);

        bala = new Bala(R.drawable.bala, 700, 1200, this, nave);

        al1 = new Alien(R.drawable.aliens, 100, 0, this);
        al2 = new Alien(R.drawable.aliens, 400, 0, this);
        al3 = new Alien(R.drawable.aliens, 800, 0, this);
        al4 = new Alien(R.drawable.aliens, 1200, 0, this);

        balaAlien = new BalaAlien(R.drawable.balaalien, 200, 50, this, al1);
        balaAlien2 = new BalaAlien(R.drawable.balaalien, 500, 50, this, al2);
        balaAlien3 = new BalaAlien(R.drawable.balaalien, 900, 50, this, al3);
        balaAlien4 = new BalaAlien(R.drawable.balaalien, 1300, 50, this, al4);

        is1 = new Islas(R.drawable.isla, 100, 100, this);
        is2 = new Islas(R.drawable.isla, 400, 100, this);
        is3 = new Islas(R.drawable.isla, 800, 100, this);
        is4 = new Islas(R.drawable.isla, 1200, 100, this);

        score = "SCORE  " + punt;
        record = "RÉCORD  5000";


        puntero = null;
        punteroBala = null;
        punteroBalaAlien = null;
        punteroBalaAlien2 = null;
        punteroBalaAlien3 = null;
        punteroBalaAlien4 = null;

        main = (Main2Activity) context;

        sonidoPricipal = (Main2Activity) context;
        sonidoPricipal.Inicio();


        is1.moverY(3);
        is2.moverY(7);
        is3.moverY(15);
        is4.moverY(10);

        al1.moverY(10);
        al2.moverY(20);
        al3.moverY(12);
        al4.moverY(25);

        balaAlien.moverY(30);
        balaAlien2.moverY(35);
        balaAlien3.moverY(40);
        balaAlien4.moverY(45);

        bala.moverY(40);


        fin.hacerVisible(false);
        nuevo.hacerVisible(false);
        ganaste.hacerVisible(false);
        ganador.hacerVisible(false);
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

        fin.pintar(c, p);
        nuevo.pintar(c, p);
        ganaste.pintar(c, p);
        ganador.pintar(c, p);

        bala.pintar(c, p);
        nave.pintar(c, p);

        p.setTextSize(70);
        p.setColor(Color.WHITE);
        c.drawText(score, 1050, 100, p);

        p.setTextSize(70);
        p.setColor(Color.WHITE);
        c.drawText(record, 100, 100, p);

        if (nave.colision(al1)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

        if (nave.colision(al2)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

        if (nave.colision(al3)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

        if (nave.colision(al4)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

        if (balaAlien.colision(nave)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

        if (balaAlien2.colision(nave)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

        if (balaAlien3.colision(nave)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

        if (balaAlien4.colision(nave)){
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            bala.timer.cancel();
            fin.hacerVisible(true);
            nuevo.hacerVisible(true);

            sonidoPricipal.pararInicio();
        }

    }

    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (nave.estaEnArea(xp, yp)) {
                    puntero = nave;
                    punteroBala = bala;
                    punteroBalaAlien = balaAlien;
                    punteroBalaAlien2 = balaAlien2;
                    punteroBalaAlien3 = balaAlien3;
                    punteroBalaAlien4 = balaAlien4;
                }

                if (nuevo.estaEnArea(xp, yp)){
                    Intent pantalla = new Intent(main, Main2Activity.class);
                    main.startActivity(pantalla);
                }

                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null || punteroBala!=null || punteroBalaAlien!=null) {
                    nave.moverX(xp);

                    //En casos en que colisione la nave con los aliens
                    if (puntero.colision(al1) && puntero == nave){
                        nave.hacerVisible(false);
                        al1.hacerVisible(false);
                        bala.hacerVisible(false);
                        balaAlien.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }

                    if (puntero.colision(al2) && puntero == nave){
                        nave.hacerVisible(false);
                        al2.hacerVisible(false);
                        bala.hacerVisible(false);
                        balaAlien2.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }
                    if (puntero.colision(al3) && puntero == nave){
                        nave.hacerVisible(false);
                        al3.hacerVisible(false);
                        bala.hacerVisible(false);
                        balaAlien3.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }
                    if (puntero.colision(al4) && puntero == nave){
                        nave.hacerVisible(false);
                        al4.hacerVisible(false);
                        bala.hacerVisible(false);
                        balaAlien4.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }


                    //En caso de que la bala de la nave colisione con los aliens
                    if (punteroBala.colision(al1) && punteroBala == bala){
                        bala.hacerVisible(false);
                        al1.hacerVisible(false);

                        bala = new Bala(R.drawable.bala, xp, yp, this, nave);
                        bala.hacerVisible(true);
                        bala.moverY(40);
                        punteroBala = bala;

                        al1 = new Alien(R.drawable.aliens, xp, -100, this);
                        al1.hacerVisible(true);
                        al1.moverY(10);

                        balaAlien = new BalaAlien(R.drawable.balaalien, xp+100, 0, this, al1);
                        balaAlien.moverY(35);
                        punteroBalaAlien = balaAlien;
                        punt= punt+100;
                        score = "SCORE  " + punt;
                    }

                    if (punteroBala.colision(al2) && punteroBala == bala){
                        bala.hacerVisible(false);
                        al2.hacerVisible(false);
                        bala = new Bala(R.drawable.bala, xp, yp, this, nave);
                        bala.hacerVisible(true);
                        bala.moverY(40);
                        punteroBala = bala;
                        al2 = new Alien(R.drawable.aliens, xp, -100, this);
                        al2.hacerVisible(true);
                        al2.moverY(20);

                        balaAlien2 = new BalaAlien(R.drawable.balaalien, xp+100, 0, this, al2);
                        balaAlien2.moverY(30);
                        punteroBalaAlien2 = balaAlien2;
                        punt= punt+100;
                        score = "SCORE  " + punt;
                    }

                    if (punteroBala.colision(al3) && punteroBala == bala){
                        bala.hacerVisible(false);
                        al3.hacerVisible(false);
                        bala = new Bala(R.drawable.bala, xp, yp, this, nave);
                        bala.hacerVisible(true);
                        bala.moverY(40);
                        punteroBala = bala;
                        al3 = new Alien(R.drawable.aliens, xp, -100, this);
                        al3.hacerVisible(true);
                        al3.moverY(15);

                        balaAlien3 = new BalaAlien(R.drawable.balaalien, xp+100, 0, this, al3);
                        balaAlien3.moverY(45);
                        punteroBalaAlien3 = balaAlien3;
                        punt= punt+100;
                        score = "SCORE   " + punt;
                    }

                    if (punteroBala.colision(al4) && punteroBala == bala){
                        bala.hacerVisible(false);
                        al4.hacerVisible(false);
                        bala = new Bala(R.drawable.bala, xp, yp, this, nave);
                        bala.hacerVisible(true);
                        bala.moverY(40);
                        punteroBala = bala;
                        al4 = new Alien(R.drawable.aliens, xp, -100, this);
                        al4.hacerVisible(true);
                        al4.moverY(12);

                        balaAlien4 = new BalaAlien(R.drawable.balaalien, xp+100, 0, this, al4);
                        balaAlien4.moverY(40);
                        punteroBalaAlien4 = balaAlien4;
                        punt= punt+100;
                        score = "SCORE  " + punt;
                    }

                    //En caso de que la bala del Aliens colisione con la nave
                    if (punteroBalaAlien.colision(nave) && punteroBalaAlien == balaAlien){
                        nave.hacerVisible(false);
                        bala.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }

                    if (punteroBalaAlien2.colision(nave) && punteroBalaAlien2 == balaAlien2){
                        nave.hacerVisible(false);
                        bala.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }

                    if (punteroBalaAlien3.colision(nave) && punteroBalaAlien3 == balaAlien3){
                        nave.hacerVisible(false);
                        bala.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }

                    if (punteroBalaAlien4.colision(nave) && punteroBalaAlien4 == balaAlien4){
                        nave.hacerVisible(false);
                        bala.hacerVisible(false);
                        fin.hacerVisible(true);
                        nuevo.hacerVisible(true);

                        sonidoPricipal.pararInicio();
                    }

                    if (punt == 5000){
                        ganaste.hacerVisible(true);
                        nuevo.hacerVisible(true);
                        ganador.hacerVisible(true);
                        nave.hacerVisible(false);
                        bala.hacerVisible(false);
                        al1.hacerVisible(false);
                        al2.hacerVisible(false);
                        al3.hacerVisible(false);
                        al4.hacerVisible(false);
                        balaAlien.hacerVisible(false);
                        balaAlien2.hacerVisible(false);
                        balaAlien3.hacerVisible(false);
                        balaAlien4.hacerVisible(false);
                        is1.hacerVisible(false);
                        is2.hacerVisible(false);
                        is3.hacerVisible(false);
                        is4.hacerVisible(false);

                        sonidoPricipal.pararInicio();
                        sonidoPricipal.ganaste();
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                punteroBala = null;
                punteroBalaAlien = null;
                punteroBalaAlien2 = null;
                punteroBalaAlien3 = null;
                punteroBalaAlien4 = null;
                break;
        }

        return true;
    }

}
