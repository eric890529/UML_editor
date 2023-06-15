package Object;

import java.awt.Graphics;

public class Ports {
	int leftPortX,leftPortY;
	int bottomPortX,bottomPortY;
	int rightPortX, rightPortY;
	int topPortX, topPortY;
	protected int portWidth = 6;
	
	int objX;
	int objY;
	int objWidth;
	int objHeight;
	BaseObject object;
	
	Ports(BaseObject obj){
		object = obj;
	}
	
	public void paintPort(Graphics g) {
		g.fillRect(leftPortX,  leftPortY, portWidth, portWidth);
		g.fillRect(bottomPortX, bottomPortY, portWidth, portWidth);
		g.fillRect(rightPortX, rightPortY, portWidth, portWidth);
		g.fillRect(topPortX, topPortY, portWidth, portWidth);
	}
	
	public void setPortPosition() {
		objX = object.x;
		objY = object.y;
		objWidth = object.width;
		objHeight = object.height;
		//System.out.println(objX+" "+ objY);
		
		leftPortX = objX - portWidth;
		leftPortY = objY + objHeight / 2 - portWidth / 2 ;
		bottomPortX = objX + objWidth / 2 - portWidth / 2;
		bottomPortY = objY + objHeight;
		rightPortX = objX + objWidth;
		rightPortY = objY + objHeight / 2 - portWidth / 2;
		topPortX = objX + objWidth / 2 - portWidth / 2; 
		topPortY = objY - portWidth;
	}
	
	public int [] getLeftPort() {
		return new int[] {leftPortX + portWidth, leftPortY + portWidth/2};
	}
	
	public int [] getRightPort() {
		return new int[] {rightPortX , rightPortY + portWidth/2};
	}
	
	public int [] getBottomPort() {
		return new int[] {bottomPortX + portWidth/2, bottomPortY};
	}
	
	public int [] getTopPort() {
		return new int[] {topPortX + portWidth/2, topPortY + portWidth};
	}
}
