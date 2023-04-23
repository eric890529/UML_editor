package mode;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import GUI.MyCanvas;
import Object.BaseLineObject;
import Object.BaseObject;
import Object.ClassObject;

public  class DrawClass extends DrawObject{

	public DrawClass(MyCanvas canvas) {
		super(canvas);
	}
	
	@Override
	public BaseObject newObject() {
		// TODO Auto-generated method stub
		return new ClassObject();
	}
	
}
