package Object;

import java.awt.Color;
import java.awt.Graphics;

public class ComposeLine extends BaseLineObject{
	private double arrowAngle = 60;
    private double arrowLength = 20;
    
    public ComposeLine(){
    	super();
    }
    
	public ComposeLine(BaseObject startObj, BaseObject endObj, int x, int y, int x2, int y2) {
		super(startObj, endObj, x, y, x2, y2);
	}

	@Override
	public void draw(Graphics g) {
		System.out.println("draw line");
		// TODO Auto-generated method stub
		g.drawLine(x, y, x2, y2);
		drawHead(g);
	}
	
	public void drawHead(Graphics g)
    {
		//旋轉向量
		double vecLen = Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
        double radiant = Math.toRadians(90 + arrowAngle);
        double vecX = (double)(x2 - x) / vecLen;
        double vecY = (double)(y2 - y) / vecLen;
        int arrowX1 = x2 + (int)(arrowLength * (vecX*Math.cos(radiant) - vecY*Math.sin(radiant)));
        int arrowY1 = y2 + (int)(arrowLength * (vecX*Math.sin(radiant) + vecY*Math.cos(radiant)));
        int arrowX2=  x2 + (int)(arrowLength * (vecX*Math.cos(-radiant) - vecY*Math.sin(-radiant)));
        int arrowY2 = y2 + (int)(arrowLength * (vecX*Math.sin(-radiant) + vecY*Math.cos(-radiant)));
        int arrowX3 = x2 + 2 * ((arrowX1 + arrowX2) / 2 - x2);
        int arrowY3 = y2 + 2 * ((arrowY1 + arrowY2) / 2 - y2);
        int[] pointsX = {arrowX1, arrowX3, arrowX2, x2};
        int[] pointsY = {arrowY1, arrowY3, arrowY2, y2};
        g.setColor(Color.WHITE);
        g.fillPolygon(pointsX, pointsY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(pointsX, pointsY, 4);
    }
}
