package mode;

import java.awt.Graphics;

import GUI.MyCanvas;
import Object.AssociationLine;
import Object.BaseLineObject;
import Object.BaseObject;

public class DrawAssociation extends DrawLine {

	public DrawAssociation(MyCanvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public  BaseLineObject newLine(BaseObject startObj, BaseObject endObj, int x, int y, int x2, int y2) {
		return new AssociationLine(startObj, endObj, x, y, x2, y2);
	}
}
 