package mode;

import GUI.MyCanvas;
import Object.AssociationLine;
import Object.BaseLineObject;
import Object.BaseObject;
import Object.ComposeLine;

public class DrawComposition extends DrawLine {
	public DrawComposition(MyCanvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public  BaseLineObject newLine(BaseObject startObj, BaseObject endObj, int x, int y, int x2, int y2) {
		return new ComposeLine(startObj, endObj, x, y, x2, y2);
	}
}
