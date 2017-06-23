package me.meczka.pong.managers;

/**
 * Created by Chilik on 17.06.2017.
 */
public class ScoreManager {
    public final int UP=1,DOWN=2;
    private int punkty1=0,punkty2=0;
    public void addMiss(int upOrDown)
    {
        if(upOrDown==UP)
        {
            punkty2++;
        }
        else if(upOrDown==DOWN)
        {
            punkty1++;
        }
    }
    public int getPunktyPaletka1()
    {
        return punkty1;
    }
    public int getPunktyPaletka2()
    {
        return punkty2;
    }
}
