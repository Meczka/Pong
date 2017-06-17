package me.meczka.pong.main;

import me.meczka.pong.core.GameCore;
import me.meczka.pong.graphics.ScreenManager;
import me.meczka.pong.input.GameAction;
import me.meczka.pong.managers.InputManager;
import me.meczka.pong.managers.ResourceManager;
import me.meczka.pong.managers.ScoreManager;
import me.meczka.pong.sprites.Ball;
import me.meczka.pong.sprites.Sprite;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Patryk on 14.06.2017.
 */
public class Main extends GameCore{
    private ResourceManager resourceManager;
    private InputManager input;
    private ScoreManager score;
    public static void main(String[] args)
    {
        new Main().run();
    }
    private GameAction arrowLeft,arrowRight,a,d;
    private final double paletkaSPEED = 0.5 ;
    private final int LEFT=1,RIGHT=2,UP=3,DOWN=4;
    public void init()
    {
        super.init();
        input = new InputManager(screen.getFullScreenWindow());
        score = new ScoreManager();
        resourceManager = new ResourceManager(screen.getWidth(),screen.getHeight());
        resourceManager.loadImages();
        resourceManager.loadSprites();
        initInput();
    }
    public void initInput()
    {
        arrowLeft = new GameAction("arrowLeft");
        arrowRight = new GameAction("arrowRight");

        a = new GameAction("a");
        d = new GameAction("d");

        input.mapToKey(arrowLeft,KeyEvent.VK_LEFT);
        input.mapToKey(arrowRight,KeyEvent.VK_RIGHT);

        input.mapToKey(a,KeyEvent.VK_A);
        input.mapToKey(d,KeyEvent.VK_D);
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,1920,1200);
        Sprite paletka1 = resourceManager.getSprite(resourceManager.PALETKA1);
        Sprite paletka2 = resourceManager.getSprite(resourceManager.PALETKA2);
        Sprite ball = resourceManager.getSprite(resourceManager.BALL);
        g.drawImage(paletka1.getImage(),(int)paletka1.getX(),(int)paletka1.getY(),null);
        g.drawImage(paletka2.getImage(),(int)paletka2.getX(),(int)paletka2.getY(),null);
        g.drawImage(ball.getImage(),(int)ball.getX(),(int)ball.getY(),null);
    }
    public void update(long elapsedTime)
    {
        //paletka1(dolna)
        Sprite paletka1 = resourceManager.getSprite(resourceManager.PALETKA1);
        Sprite paletka2 = resourceManager.getSprite(resourceManager.PALETKA2);
        Sprite ball = resourceManager.getSprite(resourceManager.BALL);
        if(arrowRight.isPressed())
        {
            paletka1.setVelX(paletkaSPEED);
        }
        else if(arrowLeft.isPressed())
        {
            paletka1.setVelX(-paletkaSPEED);
        }
        else
        {
            paletka1.setVelX(0);
        }
        //paletka2(gorna)
        if(d.isPressed())
        {
            paletka2.setVelX(paletkaSPEED);
        }
        else if(a.isPressed())
        {
            paletka2.setVelX(-paletkaSPEED);
        }
        else
        {
            paletka2.setVelX(0);
        }
        if(ball.getVelX()==0||ball.getVelY()==0) {
            ((Ball)ball).debug();
        }

        //update velocity
        paletka1.setX((paletka1.getX()+paletka1.getVelX()*elapsedTime));
        paletka2.setX(paletka2.getX()+paletka2.getVelX()*elapsedTime);

        ball.setX(ball.getX()+ball.getVelX()*elapsedTime);
        ball.setY(ball.getY()+ball.getVelY()*elapsedTime);


        if(isCollision(ball,paletka1))
        {
            ball.setY(paletka1.getY()-paletka1.getHeight());
            ((Ball)ball).bounce(Ball.VEERTICALY);
        }
        else if(isCollision(ball,paletka2))
        {
            ball.setY(paletka2.getY()+paletka2.getHeight());
            ((Ball)ball).bounce(Ball.VEERTICALY);
        }
        if(isCollisionEdge(ball)!=0)
        {
            ((Ball)ball).bounce(Ball.HORIZONTALY);
        }

        //sprawdza czy paletka nie wyszla za krawedz
        int is = isCollisionEdge(paletka1);
        if(is!=0) {
            if (is == LEFT) {
                paletka1.setX(0);
            }
            else if(is==RIGHT)
            {
                paletka1.setX(screen.getWidth()-resourceManager.PALETKAWIDTH);
            }
        }
        is = isCollisionEdge(paletka2);
        if(is!=0) {
            if (is == LEFT) {
                paletka2.setX(0);
            }
            else if(is==RIGHT)
            {
                paletka2.setX(screen.getWidth()-resourceManager.PALETKAWIDTH);
            }
        }


        //sprawdza czy piłka nie wypadła za ekran
        is = isCollisionEdgeHorizontaly(ball);
        if(is!=0)
        {
            ball.setVelX(0);
            ball.setVelY(0);
            ball.setX(screen.getWidth()/2-resourceManager.BALLSIZE/2);
            ball.setY(screen.getHeight()/2-resourceManager.BALLSIZE/2);

            if(is==UP)
            {

            }
            else if(is==DOWN)
            {

            }
        }

    }
    public boolean isCollision(Sprite s1,Sprite s2)
    {
        double x1 ,y1,x2,y2;
        x1 = s1.getX();
        y1 = s1.getY();
        x2 = s2.getX();
        y2 = s2.getY();


        if(x1<x2+s2.getWidth()&&x1+s1.getWidth()>x2&&
                y1+s1.getHeight()>y2&&y1<y2+s2.getHeight())
        {
            return true;
        }
        return false;
    }
    public int isCollisionEdge(Sprite s1)
    {
        double x = s1.getX();
        if(x+s1.getWidth()>screen.getWidth())
        {
            return RIGHT;
        }
        else if(x<0)
        {
            return LEFT;
        }
        return 0;
    }
    public int isCollisionEdgeHorizontaly(Sprite ball)
    {
        if(ball.getY()>screen.getHeight())
        {
            return DOWN;
        }
        else if(ball.getY()<0)
        {
            return DOWN;
        }
        else
        {
            return 0;
        }
    }


}
