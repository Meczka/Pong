package me.meczka.pong.sprites;

import me.meczka.pong.core.GameMathematics;

import java.awt.*;
import java.util.Random;

/**
 * Created by Patryk on 14.06.2017.
 */
public class Ball extends Sprite {

    public static final int PALETKA = 1, SCIANA = 2;

    private final double SPEED = 0.4;
    public Ball(int x, int y, Image image, int width, int height) {
        super(x, y, image, width, height);
    }

    public void debug() {
        Random rand = new Random();
        double los = 0.1 + (rand.nextDouble() * (0.30 - 0.1));


        boolean wynik = rand.nextBoolean();
        if(wynik)
        {
            this.setVelX(SPEED+los);
            this.setVelY(SPEED-los);
        }
        else
        {
            this.setVelX(SPEED-los);
            this.setVelY(SPEED+los);
        }


    }

    public void bounce(int how) {
       Random rand  = new Random();
       boolean wynik  = rand.nextBoolean();
       double los = 0.025 + rand.nextDouble() * (0.1 - 0.025);
       if (how ==SCIANA)
       {
           //Odbijanie
           setVelX(-getVelX());
       }
       else if(how==PALETKA)
       {
           if(wynik)
           {
               //odejmujemy  velX dodajemy velY
               setVelX(GameMathematics.addSpeed(getVelX(),-los));
               setVelY(GameMathematics.addSpeed(getVelY(),los));
           }
           else
           {
               //dodajemy velX odejmujemy velY
               setVelX(GameMathematics.addSpeed(getVelX(),los));
               setVelY(GameMathematics.addSpeed(getVelY(),-los));
           }
           setVelY(-getVelY());
       }

    }

/*
 if (how == HORIZONTALY) {
            this.setVelX(-this.getVelX());
        } else if (how == VEERTICALY) {
            double los = randomizeX();
            /*if(this.getVelY()<0)
            {
                this.setVelY(Math.abs(this.getVelY()-los));
            }
            else
            {
boolean value =randomBoolan();
            if(Math.abs(getVelX())>0.4)
    {
        value=true;
    }
            if (this.getVelY() < 0) {
        if(value) {
            this.setVelY(-(this.getVelY() - los));
        }
        else
        {
            this.setVelY(-(this.getVelY() + los));
        }
    } else {
        if(value) {
            this.setVelY(-this.getVelY() + los);
        }
        else
        {
            this.setVelY(-this.getVelY() - los);
        }
    }
            if (this.getVelX() < 0) {
        if(value) {
            this.setVelX(this.getVelX() + los);
        }
        else
        {
            this.setVelX(this.getVelX() - los);
        }
    } else {
        if(value) {
            this.setVelX(this.getVelX() - los);
        }
        else
        {
            this.setVelX(this.getVelX() + los);
        }

        // this.setVelX(this.getVelX() + los);
    }
            if(Math.abs(getVelX())>0.4)
    {
        double roznica = Math.abs(getVelX())-0.3;
        if(getVelX()<0) {
            this.setVelX(-0.3);
        }
        else {
            this.setVelX(0.3);
        }
        if(getVelY()<0) {
            // this.setVelY(getVelY()-roznica);
        }
        else{
            //this.setVelY(getYVel()+roznica);
        }
    }
            System.out.println(getVelX());
}
 */
}
