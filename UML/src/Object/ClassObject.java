package Object;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
//畫圖
public class ClassObject extends BaseObject {
	
	public ClassObject() {
    	System.out.print("create \n");
    	width = 60;
    	height = 70;
    	setText("Object");
    }
	
	@Override
    public void draw(Graphics g) {
		g.setColor(Color.white);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        int lineY = height /3;
        g.drawLine(x, y + lineY, x + width, y + lineY);
        g.drawLine(x, y + lineY*2, x + width, y + lineY*2);
        paintPort(g);
        
        int txtWidth = g.getFontMetrics().stringWidth(objName);
        int space = (width - txtWidth)/2;
        g.drawString(objName, x + space, y + height / 4);
    }

	

}
