package cn.chanchan.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject 
{
	Image img;
	double x,y;
	double width,height;
	public Rectangle getRect()
	{
		Rectangle r = new Rectangle((int)x,(int)y,(int)width,(int)height);
		return r;
	}
	public GameObject(Image img, double x, double y, double width, double height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public GameObject(){}
	
}
