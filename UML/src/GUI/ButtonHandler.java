package GUI;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import mode.DrawAssociation;
import mode.DrawClass;
import mode.DrawComposition;
import mode.DrawGeneral;
import mode.DrawUseCase;
import mode.Mode;
import mode.Select;

public class ButtonHandler implements ActionListener{
    private MyCanvas canvas;
    private String btnName;
    public ButtonHandler(MyCanvas canvas, String name){
        this.canvas = canvas;
        btnName = name;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // change state of App if button is clicked
        for (MouseListener listener : canvas.getMouseListeners()) {
            canvas.removeMouseListener(listener);
            
        }
        for (MouseMotionListener listener : canvas.getMouseMotionListeners()) {
        	canvas.removeMouseMotionListener(listener);
        }
        
        Mode mode = setMode(btnName);
        canvas.addMouseListener(mode);
        canvas.addMouseMotionListener(mode); 
    }
    
    
    public Mode setMode(String m) {
    	switch(m) {
    	  case "SELECT":
    		return new Select(canvas);
    	  case "CLASS OBJECT":
    		return new DrawClass(canvas);
    	  case "USE CASE":
    		return new DrawUseCase(canvas);
    	  case "ASSOCIATION":
    		return new DrawAssociation(canvas);
    	  case "GENERAL":
      		return new DrawGeneral(canvas);
    	  case "COMPISITION":
    		return new DrawComposition(canvas);
    	} 		
    	return null;
    }
    
}