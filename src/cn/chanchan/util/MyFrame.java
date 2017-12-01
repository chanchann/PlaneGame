package cn.chanchan.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class MyFrame extends Frame
{ 
	public void launchFrame()
	{
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	Image ImageBuffer = null;
	Graphics GraImage = null;
	public void update(Graphics g)
	{//覆盖update方法，截取默认的调用过程  
		ImageBuffer = createImage(this.getWidth(), this.getHeight());//创建图形缓冲区  
		GraImage = ImageBuffer.getGraphics();//获取图形缓冲区的图形上下文  
		paint(GraImage);//用paint方法中编写的绘图过程对图形缓冲区绘图  
		GraImage.dispose();//释放图形上下文资源  
		g.drawImage(ImageBuffer, 0, 0, this);//将图形缓冲区绘制到屏幕上  
	}
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
