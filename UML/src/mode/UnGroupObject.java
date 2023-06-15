package mode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.MyCanvas;
import Object.BaseObject;
import Object.Composition;

public class UnGroupObject implements ActionListener{
	MyCanvas canvas;
	public UnGroupObject(MyCanvas canvas){
		this.canvas = canvas;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Select.objListj size "+ Select.objList.size());
		if(canvas.coms.size()>0 ){
			Composition com = Composition.findUngroupComposition(Select.objList.get(0), canvas.coms);
			
			
			canvas.objList.addAll(com.getLeafsContents());
			
			
			canvas.coms.remove(com);
		}
	}
}
 