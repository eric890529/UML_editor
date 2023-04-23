package Object;

import java.awt.Color;
import java.awt.Graphics;

public class GeneralizeLine extends BaseLineObject{
	private double arrowAngle = 60;
    private double arrowLength = 20;
    public GeneralizeLine(){
    	super();
    }
    
	public GeneralizeLine(BaseObject startObj, BaseObject endObj, int x, int y, int x2, int y2) {
		super(startObj, endObj, x, y, x2, y2);
	}
	
	@Override
	public void drawHead(Graphics g) { 
		double vecLen = Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
	    double radiant = Math.toRadians(90 + arrowAngle);
	    double vecX = (double)(x2 - x) / vecLen;
	    double vecY = (double)(y2 - y) / vecLen;
	    int arrowX1 = x2 + (int)(arrowLength * (vecX*Math.cos(radiant) - vecY*Math.sin(radiant)));
	    int arrowY1 = y2 + (int)(arrowLength * (vecX*Math.sin(radiant) + vecY*Math.cos(radiant)));
	    int arrowX2 = x2 + (int)(arrowLength * (vecX*Math.cos(-radiant) - vecY*Math.sin(-radiant)));
	    int arrowY2 = y2 + (int)(arrowLength * (vecX*Math.sin(-radiant) + vecY*Math.cos(-radiant)));
	    int[] pointsX = {arrowX1, arrowX2, x2};
	    int[] pointsY = {arrowY1, arrowY2, y2};
	    g.setColor(Color.WHITE);
	    g.fillPolygon(pointsX, pointsY, 3);
	    g.setColor(Color.BLACK);
	    g.drawPolygon(pointsX, pointsY, 3);
	}
	@Override
	public void draw(Graphics g) {
		System.out.println("draw line");
		g.drawLine(x, y, x2, y2);
		drawHead(g);
	}
}
