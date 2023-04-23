package Object;

import java.awt.Graphics;

public abstract class Shape {
	protected int portWidth = 6;
	protected int x, y, x2, y2;
	protected int width, height;
	int depth;
	
	protected boolean isSelected;
	
    public Shape(){
        isSelected = false;
    }

	public abstract void draw(Graphics g);
	
	public void setSelected(boolean bool){
        isSelected = bool;
    }
	
	public int getStartX() {
		// TODO Auto-generated method stub
		return x;
	}

	
	public int getStartY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public int getEndX() {
		// TODO Auto-generated method stub
		return x2;
	}

	public int getEndY() {
		// TODO Auto-generated method stub
		return y2;
	}
	
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}
	
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public void setStartPoint(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
        this.y = y;
	}
	
	public void setEndPoint(int x, int y) {
		// TODO Auto-generated method stub
		x2 = (x);
        y2 = (y);
	}
	
	
	

}
