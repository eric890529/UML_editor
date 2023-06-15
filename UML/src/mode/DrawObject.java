package mode;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import GUI.MyCanvas;
import Object.BaseObject;
import Object.ClassObject;
import Object.UseCaseObject;

public abstract class DrawObject extends Mode{
	//JPanel canvas = MyCanvas.getCanvas();
	BaseObject obj;
	MyCanvas canvas;
	public DrawObject(MyCanvas canvas) {
		super(canvas);
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		for(BaseObject obj : canvas.objList) {
			obj.setSelected(false);
		}
		
		BaseObject obj = newObject();
		obj.setStartPoint(e.getX(), e.getY());
		obj.setEndPoint(e.getX()+obj.getWidth(), e.getY()+obj.getHeight());
		canvas.objList.add(obj);
		canvas.repaint();
	}
	
	
	 public abstract BaseObject newObject();

}
