package me.meczka.pong.main;

import me.meczka.pong.core.GameCore;
import me.meczka.pong.graphics.ScreenManager;
import me.meczka.pong.managers.ResourceManager;

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
    public void init()
    {
        resourceManager = new ResourceManager(screen.getWidth(),screen.getHeight());
        resourceManager.loadImages();
        resourceManager.loadSprites();
    }

    public void draw(Graphics2D g)
    {

    }
}
