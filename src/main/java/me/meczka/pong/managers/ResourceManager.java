package me.meczka.pong.managers;

import me.meczka.pong.sprites.Ball;
import me.meczka.pong.sprites.Paletka;
import me.meczka.pong.sprites.Sprite;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Patryk on 14.06.2017.
 */
public class ResourceManager {
    private final String FILEPATH = "D:\\programImage";
    private Image ballimg,paletka;
    public final int BALLIMG=1,PALETKA=2;
    public final int BALL=1,PALETKA1=2,PALETKA2=3;

    //stałe wymiaty obrazkow
    public final int PALETKAHEIGHT=50,PALETKAWIDTH=150,BALLSIZE=25;

    private int screenwidth,screenheight;
    private Sprite ball,paletka1,paletka2;
    public ResourceManager(int screenwidth,int screenheight)
    {
        this.screenwidth=screenwidth;
        this.screenheight=screenheight;
    }
    public Image loadImage(String name)
    {
        return new ImageIcon(FILEPATH+"\\"+name).getImage();
    }
    public void loadImages()
    {
        ballimg=loadImage("ball.png");
        paletka=loadImage("paletka.png");
    }
    public Image getImage(int name)
    {
        switch (name)
        {
            case BALLIMG:
                return ballimg;
            case PALETKA:
                return paletka;
        }
        return null;
    }
    public void loadSprites()
    {
        ball = new Ball(screenwidth/2-BALLSIZE,screenheight/2-BALLSIZE,getImage(BALLIMG),BALLSIZE,BALLSIZE);
        System.out.println(screenheight);
        paletka1 = new Paletka(screenwidth/2-PALETKAWIDTH/2,screenheight-PALETKAHEIGHT,getImage(PALETKA),PALETKAWIDTH,PALETKAHEIGHT);
        paletka2 = new Paletka(screenwidth/2-PALETKAWIDTH/2,0,getImage(PALETKA),PALETKAWIDTH,PALETKAHEIGHT);
    }
    public Sprite getSprite(int name)
    {
        switch (name)
        {
            case BALL:
                return ball;
            case PALETKA1:
                return paletka1;
            case PALETKA2:
                return paletka2;
        }
        return null;
    }
}
