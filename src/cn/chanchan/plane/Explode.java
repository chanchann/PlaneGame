package cn.chanchan.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.chanchan.util.GameUtil;

public class Explode 
{
	double x,y;
	static Image[] imgs = new Image[23];
	int count;
	
	static
	{
		for(int i = 0;i<23;i++)
		{
			imgs[i] = GameUtil.getImage("images.explode/p"+(i+1)+".png");
			imgs[i].getWidth(null); //添加此代码解决加载问题
		}
	}
	public void draw(Graphics g)
	{
		if(count<23)
		{
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	public Explode() {}
	public Explode(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}
