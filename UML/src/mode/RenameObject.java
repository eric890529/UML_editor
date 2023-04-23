package mode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.MyCanvas;
import Object.BaseObject;

public class RenameObject implements ActionListener{
	MyCanvas canvas;
	private JFrame workingFrame;
	
	public RenameObject(MyCanvas canvas){
		this.canvas = canvas;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String input = JOptionPane.showInputDialog(workingFrame, "Rename");
        if(input!=null){
        	for(BaseObject obj : Select.objList) {
        		obj.setText(input);
        	}
            canvas.repaint();
        }	
	}

}
