package GUI;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Object.BaseLineObject;
import Object.BaseObject;
import Object.ClassObject;
import Object.Composition;
import Object.UseCaseObject;
import Object.selectArea;
import mode.DrawAssociation;
import mode.DrawClass;
import mode.DrawComposition;
import mode.DrawGeneral;
import mode.DrawLine;
import mode.DrawObject;
import mode.DrawUseCase;
import mode.Mode;
import mode.Select;

public class MyCanvas extends JPanel{
	//public static JPanel panel = new JPanel();
	public static Mode mode ;
	//BaseObject obj;
	public List<BaseObject> objList = new ArrayList<BaseObject>();
	public List<BaseLineObject> lineList = new ArrayList<BaseLineObject>();
	public static List<Composition> coms = new ArrayList<Composition>();
	public List<BaseObject> selectedObj = new ArrayList<BaseObject>();
	public selectArea area = new selectArea();
	int width;
	int height;
	 
    MyCanvas (int width, int height) {
    	/*panel.setBounds(75,0,625,525); 
    	panel.setBackground(Color.white);
    	panel.setLayout(null);*/
    	
    	this.width = width;
    	this.height = height;
    	setBounds(75,0,width,height); 
    	setBackground(Color.white);
    	setLayout(null);
    }
    
    public JPanel getCanvas() {
    	return this;
    }
    
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(area!=null) {

			area.draw(g);
		}
		
		for(BaseObject obj : objList) {
			obj.draw(g);
		}
		
		for(BaseLineObject line : lineList) {
			line.draw(g);
		}
		
		
    }
    
}
