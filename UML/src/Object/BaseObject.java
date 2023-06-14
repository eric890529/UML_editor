package Object;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public abstract class  BaseObject extends Shape{
	String objName;

	Ports port = new Ports(this);
	
	BaseObject(){
		
		
	}
	
	public void paintPort(Graphics g) {
		port.setPortPosition();
		if(isSelected) {
			port.paintPort(g);
		}
	}
	
	public Ports getPort() {
		return port;
	}
	
	public boolean isInside(int x, int y){
        if(x >= this.x && x <= this.x + width){
            if(y >= this.y && y <= this.y + height)
                return true;
            else
                return false;
        }
        else{
            return false;
        }
    }
	
    public boolean isInside(int x, int y, int endX, int endY){
        int leftBoundary = Math.min(x, endX);
        int rightBoundary = Math.max(x, endX);
        int topBoundary = Math.min(y, endY);
        int bottomBoundary = Math.max(y, endY);
        if(leftBoundary <= this.x && rightBoundary >= this.x + width){
            if(topBoundary <= this.y && bottomBoundary >= this.y + height)
                return true;
            else
                return false;
        }
        else{
            return false;
        }
    }
	
	public static List<BaseObject> getInsideObjs(int x, int y, List<BaseObject> objs){
        List<BaseObject> selecteds = new ArrayList<BaseObject>();
        for (BaseObject obj: objs){
            if(obj.isInside(x, y))
                selecteds.add(obj);
        }
        return selecteds;
    }
	
	public static List<BaseObject> getInsideObjs(int x, int y, int endX, int endY, List<BaseObject> objs){
        // return a list of objs insides the rectangular area specified by user
        List<BaseObject> selecteds = new ArrayList<BaseObject>();
        for (BaseObject obj: objs){
            if(obj.isInside(x, y, endX, endY))
                selecteds.add(obj);
        }
        return selecteds;
    }
	
	public void setText(String name) {
		objName = name;
	}
	
}
