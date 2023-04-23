package GUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import mode.DrawLine;
import mode.DrawObject;
import mode.Mode;
import mode.Select;


public class ButtonPanel  implements ActionListener{
	JButton[] buttons = new JButton[6];
	JButton select = new JButton(new ImageIcon("src\\\\img\\\\cursor.png"));//"C:\\Users\\Eric\\eclipse-workspace\\UML\\src\\img\\select.png"
	JButton association = new JButton(new ImageIcon("src\\img\\association.png"));
	JButton general = new JButton(new ImageIcon("src\\img\\general.png"));
	JButton composition = new JButton(new ImageIcon("src\\img\\composition.png"));
	public JButton objectClass = new JButton(new ImageIcon("src\\img\\class.png"));
	JButton usecase = new JButton(new ImageIcon("src\\img\\usecase.png"));
	JPanel panel = new JPanel();
	MyCanvas canvas;

	public ButtonPanel(MyCanvas canvas){   
		buttons[0] = select;
		buttons[1] = association;
		buttons[2] = general;
		buttons[3] = composition;
		buttons[4] = objectClass;
		buttons[5] = usecase;
		
		this.canvas = canvas;
		
		panel.setLayout(null);
		
		for(int i = 0 ; i < buttons.length ; i++) {
			buttons[i].addActionListener(this);
		}
		
		select.setName("SELECT");
		association.setName("ASSOCIATION");
		general.setName("GENERAL");
		composition.setName("COMPISITION");
		objectClass.setName("CLASS OBJECT");
		usecase.setName("USE CASE");
	}
	
	public void setBtn() {
		panel.setBounds(0,0,75,525);    
	    panel.setBackground(Color.gray);
	    
		select.setBounds(0,0,75,75);  
		association.setBounds(0,75,75,75);
		general.setBounds(0,150,75,75);
		composition.setBounds(0,225,75,75);
		objectClass.setBounds(0,300,75,75);
		usecase.setBounds(0,375,75,75);
		
		panel.add(select); panel.add(association);  
		panel.add(general);  panel.add(composition);  panel.add(objectClass);  panel.add(usecase);
		
		for(int i = 0 ; i < buttons.length ; i++) {
			buttons[i].setBackground(Color.white);
			buttons[i].setFocusPainted(false);
		}
		
		//ImageIcon icon = new ImageIcon("src\\\\img\\\\select.png");
		int offset = 20;//select.getInsets().left;
		select.setIcon(resizeIcon("cursor", select.getWidth() - offset, select.getHeight() - offset ));
		association.setIcon(resizeIcon("association", select.getWidth() - offset, select.getHeight() - offset ));
		general.setIcon(resizeIcon("general", select.getWidth() - offset, select.getHeight() - offset ));
		composition.setIcon(resizeIcon("composition", select.getWidth() - offset, select.getHeight() - offset ));
		objectClass.setIcon(resizeIcon("class", select.getWidth() - offset, select.getHeight() - offset ));
		usecase.setIcon(resizeIcon("usecase", select.getWidth() - offset, select.getHeight() - offset ));
	}
	
	public JPanel getBtn() {
		return panel;
	}
	

	private static Icon resizeIcon(String str, int resizedWidth, int resizedHeight) {
	    Image img = new ImageIcon("src\\\\img\\\\" + str + ".png").getImage(); 
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index;
		for(index = 0 ; index < buttons.length ; index++) {
			if(e.getSource() == buttons[index]) {
				buttons[index].setBackground(Color.gray);
				canvas.setMode(buttons[index].getName());
				break;
			}
		}
		for(int i = 0 ; i < buttons.length ; i++) {
			if(i != index) {
				buttons[i].setBackground(Color.white);
			}
		}
		
	}
}
