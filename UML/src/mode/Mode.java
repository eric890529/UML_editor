package mode;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.MyCanvas;

public abstract class Mode extends MouseAdapter{
	MyCanvas canvas;
	int x, y;
	int endX, endY;
	
	Mode(MyCanvas canvas){
		this.canvas = canvas;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public void mouseDragged(MouseEvent e) {
		
    }
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
}
