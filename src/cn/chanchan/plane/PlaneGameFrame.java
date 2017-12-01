package cn.chanchan.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.chanchan.plane.Plane.KeyMonitor;
import cn.chanchan.util.GameUtil;
import cn.chanchan.util.MyFrame;

public class PlaneGameFrame extends MyFrame
{
	Image bg = GameUtil.getImage("images/bg01.jpg");
	Plane p = new Plane("images/plane01.png",200,300);
	ArrayList bulletList = new ArrayList();//泛型暂未学，暂时不加，学了强烈建议加上
	Date startTime;
	Date endTime;
	Explode boom;
	
	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		for(int i=0;i<bulletList.size();i++)
		{
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//检测与飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng)
			{
				p.setLive(false);//飞机死掉
				if(boom == null) 
				{
					endTime = new Date(); 
					boom = new Explode(p.x,p.y);
				}
				boom.draw(g);
				
				break;
			}
		}
		
		if(!p.isLive())
		{
			int period = (int)((endTime.getTime() - startTime.getTime())/1000);
			printInfo(g,"Time:"+period,30,50,130,Color.white);
			switch(period/10)
			{
				case 0:case 1:
					printInfo(g,"LV1",60,200,300,Color.white);
					break;
				case 2:
					printInfo(g,"LV2",60,200,300,Color.white);
					break;
				case 3:
					printInfo(g,"LV3",60,200,300,Color.white);
					break;
				default:
					printInfo(g,"NB",60,200,300,Color.white);
					break;
			}
		}
		
		//printInfo(g,"Score:100",10,50,100,Color.white);
	}
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color)
	{
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}

	public static void main(String[] args)
	{
		new PlaneGameFrame().launchFrame();
	}
	public void launchFrame()
	{
		super.launchFrame();
		//增加键盘监听
		addKeyListener(new KeyMonitor());
		//生成一堆子弹
		for(int i=0;i<50;i++)
		{
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}
	class KeyMonitor extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent e) 
		{
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) 
		{
			p.minusDirection(e);
		}
		
	}
}
