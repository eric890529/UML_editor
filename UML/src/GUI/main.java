package GUI;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

    public class main {
    	static JMenu file, edit; 
        public static void main(String[] args) {
        	JFrame f= new JFrame("Panel Example");    
        	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
        	
        	
        	//Canvas
        	MyCanvas canvas = new MyCanvas();
        	f.add(canvas);
        	
        	
        	
        	//Btn panel
        	ButtonPanel btn = new ButtonPanel(canvas);
        	btn.setBtn();
        	f.add(btn.getBtn());
    	    
        	//menu
        	menubar menu = new menubar(canvas);
        	f.setJMenuBar(menu.getMenuBar());
        	
        	//f.setContentPane(obj);
        	
        	
            f.setSize(700, 525);
            f.setLayout(null);  
            f.setVisible(true);
        }
        
    }