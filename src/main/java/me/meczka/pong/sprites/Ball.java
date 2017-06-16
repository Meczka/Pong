package me.meczka.pong.sprites;

import java.awt.*;
import java.util.Random;

/**
 * Created by Patryk on 14.06.2017.
 */
public class Ball extends Sprite {

    public static final int HORIZONTALY = 1, VEERTICALY = 2;

    public Ball(int x, int y, Image image, int width, int height) {
        super(x, y, image, width, height);
    }

    public void debug() {
        Random rand = new Random();
        double los = 0.1 + (rand.nextDouble() * (0.35 - 0.1));
        this.setVelX(los);

        this.setVelY(los);
    }

    public void bounce(int how) {
        if (how == HORIZONTALY) {
            this.setVelX(-this.getVelX());
        } else if (how == VEERTICALY) {
            double los = randomizeX();
            /*if(this.getVelY()<0)
            {
                this.setVelY(Math.abs(this.getVelY()-los));
            }
            else
            {*/
            boolean value =randomBoolan();
            if (this.getVelY() < 0) {
                if(value) {
                    this.setVelY(-this.getVelY() - los);
                }
                else
                {
                    this.setVelY(-this.getVelY() + los);
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
                    this.setVelX(this.getVelX() - los);
                }
                else
                {
                    this.setVelX(this.getVelX() + los);
                }

            } else {
                if(value) {
                    this.setVelX(this.getVelX() + los);
                }
                else
                {
                    this.setVelX(this.getVelX() - los);
                }
               // this.setVelX(this.getVelX() + los);
            }
        }
    }

    public double randomizeX() {
        Random rand = new Random();
        double los = 0.009 + rand.nextDouble() * (0.1 - 0.05);
        return los;
    }

    public boolean randomBoolan() {
        return Math.round(Math.random()) != 0;
    }
}
