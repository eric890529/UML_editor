package mode;

import java.awt.event.MouseEvent;

import GUI.MyCanvas;
import Object.BaseObject;
import Object.ClassObject;
import Object.UseCaseObject;

public class DrawUseCase extends DrawObject{

	public DrawUseCase(MyCanvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public BaseObject newObject() {
		// TODO Auto-generated method stub
		return new UseCaseObject();
	}

}
