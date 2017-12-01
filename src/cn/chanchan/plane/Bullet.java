package cn.chanchan.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.chanchan.util.Constant;

public class Bullet extends GameObject
{
	double degree;
	double speed=5;
	public Bullet()
	{
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 10;
		height = 10;
	}
	
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval((int)x, (int)y, (int)width, (int)height);
		g.setColor(c);
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(x<-20||x>Constant.GAME_WIDTH+10)
		{
			degree = Math.PI-degree;
		}
		if(y<0||y>Constant.GAME_HEIGHT+10)
		{
			degree = -degree;
		}
	}
}
