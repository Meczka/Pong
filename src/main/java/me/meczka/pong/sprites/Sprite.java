package me.meczka.pong.sprites;

import java.awt.*;

/**
 * Created by Patryk on 14.06.2017.
 */
public abstract class Sprite {
    private double x,y,velX,velY;
    private int width,height;
    private Image image;
    public Sprite(double x,double y,Image image,int width,int height)
    {
        this.x=x;
        this.y=y;
        this.image=image;
        this.width=width;
        this.height=height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
