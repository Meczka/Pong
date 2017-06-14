package me.meczka.pong.core;

import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;

import me.meczka.pong.graphics.ScreenManager;

public abstract  class GameCore {
	protected ScreenManager screen;
	private boolean isRunning;
	public void run()
	{		
		try
		{
			init();
			gameLoop();
		}finally
		{
			screen.restoreScreen();
			System.exit(1);
		}
	}
	public void init()
	{
		screen = new ScreenManager();
		DisplayMode dp =new DisplayMode(1920, 1200, DisplayMode.BIT_DEPTH_MULTI, DisplayMode.REFRESH_RATE_UNKNOWN);
		screen.setFullScreenWindow(dp);
		Window window = screen.getFullScreenWindow();
		window.setFont(new Font("Dialog",Font.PLAIN,24));
		
		isRunning = true;
	}
	public Image loadImage(String fileName)
	{
		return new ImageIcon(fileName).getImage();
	}
	public void gameLoop()
	{
		long startTime = System.currentTimeMillis();
		long currTime = startTime;
		while(isRunning)
		{
			long elapsedTime = System.currentTimeMillis() - currTime;
			currTime += elapsedTime;
			
			update(elapsedTime);
			
			Graphics2D g = screen.getGraphics();
			draw(g);
			g.dispose();
			screen.update();
			try{
				Thread.sleep(20);
			}catch(InterruptedException ex){}
		}
	}
	
	public void stop()
	{
		isRunning = false;
	}
	
	public synchronized void update(long elapsedTime){}
	public abstract void draw(Graphics2D g);
}
