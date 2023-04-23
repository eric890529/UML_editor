package mode;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import GUI.MyCanvas;
import Object.AssociationLine;
import Object.BaseLineObject;
import Object.BaseObject;

public abstract class DrawLine extends Mode{
	BaseLineObject line;
	BaseObject startObj, endObj;
	boolean isDraged = false;
	
	List<BaseObject> objList;
	public DrawLine(MyCanvas canvas) {
		super(canvas);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		objList = BaseObject.getInsideObjs(e.getX(), e.getY(), canvas.objList);
		
		for(BaseObject obj : canvas.objList) {
			obj.setSelected(false);
		}
		
		x = e.getX();
		y = e.getY();
		/*
		line = new AssociationLine();
		canvas.lineList.add(line);
		line.setStartPoint(e.getX(), e.getY());
		isDraged = true;
		*/
		objList = BaseObject.getInsideObjs(e.getX(), e.getY(), canvas.objList);
		
		if(objList.size()>0) {
			isDraged = true;
			startObj = objList.get(objList.size()-1);
		}
		

		canvas.repaint();
	}
	
	@Override
    public void mouseReleased(MouseEvent e) {
		endX = e.getX();
        endY = e.getY();
        if(isDraged) {
        	objList = BaseObject.getInsideObjs(endX, endY, canvas.objList);
    		
    		if(objList.size()>0) {
    			endObj = objList.get(objList.size()-1);
    			if(startObj != endObj) {
    				endX = e.getX();
    				endY = e.getY();
    				line = newLine(startObj, endObj, x, y, endX, endY);
    				if(line.isFindedPort()) { //之後要確定是否依已經有line
    					canvas.lineList.add(line);	
    				}else {
    					System.out.println("delete line");
    					line = null;
    				}
    			}
    		}
        }
		
		isDraged = false;
		canvas.repaint();
    }
	
	/*
	@Override
    public void mouseDragged(MouseEvent e) {
		System.out.println(line.getStartX());
		line.setEndPoint(e.getX(), e.getY());
		
		canvas.repaint();
    }
	*/

	 protected abstract BaseLineObject newLine(BaseObject startObj, BaseObject endObj, int x, int y, int x2, int y2);
}
