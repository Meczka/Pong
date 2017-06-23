package me.meczka.pong.core;

/**
 * Created by Patryk on 23.06.2017.
 */
public class GameMathematics {
    public static double addSpeed(double vel,double speed)
    {
        double wynik = 0;
        if(vel<0)
        {
            wynik = vel-speed;
        }
        else if(vel>0)
        {
            wynik = vel+speed;
        }
        return wynik;
    }
}
