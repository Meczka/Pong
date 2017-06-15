package me.meczka.pong.main;

import me.meczka.pong.core.GameCore;
import me.meczka.pong.graphics.ScreenManager;
import me.meczka.pong.input.GameAction;
import me.meczka.pong.managers.ResourceManager;
import me.meczka.pong.sprites.Sprite;

import java.awt.*;

/**
 * Created by Patryk on 14.06.2017.
 */
public class Main extends GameCore{
    private ResourceManager resourceManager;
    public static void main(String[] args)
    {
        new Main().run();
    }
    private GameAction arrowLeft,arrowRight,a,d;
    public void init()
    {
        super.init();
        resourceManager = new ResourceManager(screen.getWidth(),screen.getHeight());
        resourceManager.loadImages();
        resourceManager.loadSprites();
    }
    public void initInput()
    {

    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,1920,1200);
        Sprite paletka1 = resourceManager.getSprite(resourceManager.PALETKA1);
        g.drawImage(paletka1.getImage(),paletka1.getX(),paletka1.getY(),null);
    }
}
