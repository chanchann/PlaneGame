package cn.chanchan.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.chanchan.util.Constant;
import cn.chanchan.util.GameUtil;

public class Plane extends GameObject
{
	private boolean live = true;
	private boolean left,right,up,down;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g)
	{
		if(live) 
		{
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
	}
	
	public Plane(String imgPath, double x, double y) 
	{
		super();
		this.img = GameUtil.getImage(imgPath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	public Plane() {}
	
	public void move()
	{
		if(left&&x>0)
		{
			x -= 10;
		}
		if(right&&x<Constant.GAME_WIDTH-img.getWidth(null))
		{
			x += 10;
		}
		if(up&&y>45)
		{
			y -= 10;
		}
		if(down&&y<Constant.GAME_HEIGHT-img.getHeight(null))
		{
			y += 10;
		}
	}
	public void addDirection(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				left = true;
				break;
			case KeyEvent.VK_RIGHT:
				right = true;
				break;
			case KeyEvent.VK_UP:
				up = true;
				break;
			case KeyEvent.VK_DOWN:
				down = true;
				break;
			default:
				break;
		}
	}
	public void minusDirection(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				break;
			default:
				break;
		}
	}
}
