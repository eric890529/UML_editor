package GUI;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

    public class UI {
    	static JMenu file, edit; 
        public static void main(String[] args) {
        	JFrame window = new JFrame("Panel Example");    
        	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	window.setSize(800, 600);
        	window.setLayout(null);  
        	
        	
        	//Canvas
        	MyCanvas canvas = new MyCanvas(window.getSize().width, window.getSize().height);
        	window.add(canvas);
        	 	
        	//Btn panel
        	ButtonPanel btn = new ButtonPanel(canvas, window);
        	//btn.setBtn();
        	window.add(btn.getBtn());
        	
        	//menu
        	menubar menu = new menubar(canvas);
        	window.setJMenuBar(menu.getMenuBar());
        	 
        	//f.setContentPane(obj);
        	window.setVisible(true);
        	
        	
        }
        
        
    }