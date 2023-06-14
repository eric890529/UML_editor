package Object;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BaseLineObject extends Shape {
	protected BaseObject start, end;
	
	String startP, endP;
	
	boolean startPort;
	boolean endPort;
	
	int[] startTopPort ;
	int[] startLeftPort ;
	int[] startRightPort ;
	int[] startBottomPort ;
	
	int[] endTopPort ;
	int[] endLeftPort ;
	int[] endRightPort ;
	int[] endBottomPort ;

	public abstract void drawHead(Graphics g);

	int range = 20;

	BaseLineObject() {
		super();
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}

	BaseLineObject(BaseObject startObj, BaseObject endObj, int x, int y,  int x2, int y2) {
		super();
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		start = startObj;
		end = endObj;
		setPosition();
	}

	public void setPosition() {
		startPort = true;
		endPort = true;
		
		if (start != null && end != null) {
			startTopPort = start.getPort().getTopPort();
			startLeftPort = start.getPort().getLeftPort();
			startRightPort = start.getPort().getRightPort();
			startBottomPort = start.getPort().getBottomPort();

			endTopPort = end.getPort().getTopPort();
			endLeftPort = end.getPort().getLeftPort();
			endRightPort = end.getPort().getRightPort();
			endBottomPort = end.getPort().getBottomPort();
 
			
			if(isInsideRange(x ,y ,startTopPort)){
				setStartPoint(startTopPort[0], startTopPort[1]);
				startP = "TopPort";
			}
			else if(isInsideRange(x ,y ,startLeftPort)) {
				setStartPoint(startLeftPort[0], startLeftPort[1]);
				startP = "LeftPort";
			}
			else if(isInsideRange(x ,y ,startRightPort)) {
				setStartPoint(startRightPort[0], startRightPort[1]);	
				startP = "RightPort";
			}
			else if(isInsideRange(x ,y ,startBottomPort)) {
				setStartPoint(startBottomPort[0], startBottomPort[1]);
				startP = "BottomPort";
			}else {
				startPort = false;
			}
			
			if(isInsideRange(x2 ,y2 ,endTopPort)){
				setEndPoint(endTopPort[0], endTopPort[1]);
				endP = "TopPort";
			}
			else if(isInsideRange(x2 ,y2 ,endLeftPort)) {
				setEndPoint(endLeftPort[0], endLeftPort[1]);
				endP = "LeftPort";
			}
			else if(isInsideRange(x2 ,y2 ,endRightPort)) {
				setEndPoint(endRightPort[0], endRightPort[1]);	
				endP = "RightPort";
			}
			else if(isInsideRange(x2 ,y2 ,endBottomPort)) {
				setEndPoint(endBottomPort[0], endBottomPort[1]);
				endP = "BottomPort";
			}else {
				endPort = false;
			}
		}
	}
	
	public void updatePosition() {
		startTopPort = start.getPort().getTopPort();
		startLeftPort = start.getPort().getLeftPort();
		startRightPort = start.getPort().getRightPort();
		startBottomPort = start.getPort().getBottomPort();

		endTopPort = end.getPort().getTopPort();
		endLeftPort = end.getPort().getLeftPort();
		endRightPort = end.getPort().getRightPort();
		endBottomPort = end.getPort().getBottomPort();
		
		switch(startP) {
		case "TopPort":
			setStartPoint(startTopPort[0], startTopPort[1]);
			break;
		case "LeftPort":
			setStartPoint(startLeftPort[0], startLeftPort[1]);
			break;
		case "RightPort":
			setStartPoint(startRightPort[0], startRightPort[1]);
			break;
		case "BottomPort":
			setStartPoint(startBottomPort[0], startBottomPort[1]);
			break;
		default : 
		    System.out.println("false");
		}
		
		switch(endP) {
		case "TopPort":
			setEndPoint(endTopPort[0], endTopPort[1]);
			break;
		case "LeftPort":
			setEndPoint(endLeftPort[0], endLeftPort[1]);
			break;
		case "RightPort":
			setEndPoint(endRightPort[0], endRightPort[1]);	
			break;
		case "BottomPort":
			setEndPoint(endBottomPort[0], endBottomPort[1]);
			break;
		default : 
		    System.out.println("false");
		}
	}
	
	public boolean isFindedPort() {
		if(startPort && endPort) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isInsideRange(int x, int y, int []port) {
		double distance =  Math.sqrt(Math.pow( x - port[0] , 2) + Math.pow( y - port[1] , 2));
		System.out.println(distance);
		if( distance < range) {
			return true;
		}else {
			return false;
		}
	}
}
