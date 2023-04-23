package Object;
import java.awt.Color;
import java.awt.Graphics;

public class UseCaseObject extends BaseObject{
	
	
	public UseCaseObject() {
    	System.out.print("create usecase\n");
    	width = 80;
    	height = 60;
    	setText("UseCase");
    }

	@Override
    public void draw(Graphics g) {
		g.setColor(Color.white);
        g.fillOval(x, y, width, height);
        g.setColor(Color.black);
        g.drawOval(x, y, width, height);
        paintPort(g);
        
        int txtWidth = g.getFontMetrics().stringWidth(objName);
        int space = (width - txtWidth)/2;
        g.drawString(objName, x + space, y + height / 2);
    }
}
