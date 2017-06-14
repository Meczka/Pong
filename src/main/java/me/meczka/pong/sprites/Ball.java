package me.meczka.pong.sprites;

import java.awt.*;

/**
 * Created by Patryk on 14.06.2017.
 */
public class Ball extends Sprite{
    private int angle;
    public Ball(int x, int y, Image image)
    {
        super(x,y,image);
    }


    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
