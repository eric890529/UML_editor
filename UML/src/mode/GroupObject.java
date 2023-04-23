package mode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.MyCanvas;
import Object.Composition;

public class GroupObject implements ActionListener{
	MyCanvas canvas;
	public GroupObject(MyCanvas canvas){
		this.canvas = canvas;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Select.objListj size "+ Select.objList.size());
		Composition coms = new Composition(Select.objList);
		canvas.coms.add(coms);
	}

}
