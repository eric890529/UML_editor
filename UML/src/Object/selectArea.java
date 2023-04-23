package Object;

import java.awt.Color;
import java.awt.Graphics;

public class selectArea extends Shape{
	
	public selectArea() {
		super();
	}

	public selectArea(int x, int y){
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
        g.setColor(Color.blue);
        int px = Math.min(x,x2);
        int py = Math.min(y,y2);
        int pw=Math.abs(x-x2);
        int ph=Math.abs(y-y2);
        g.drawRect(px, py, pw, ph);
	}

}
