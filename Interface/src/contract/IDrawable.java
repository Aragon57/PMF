package contract;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface IDrawable {
	
	public  void paint(Graphics g);
	public void refresh();
	public int getI();
	public int getX();
	public void setI(int i);
	public void setX(int x);
}