package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Composition extends BaseObject{
	private List<BaseObject> contents = new ArrayList<BaseObject>();
	
	@Override
	public void draw(Graphics g) {
		for(BaseObject obj : contents) {
			obj.draw(g);
		}
		paintArea(g);
	}
	
	public void paintArea(Graphics g) {
		if(isSelected) {
			g.setColor(Color.red);
	        g.drawRect(x, y, width, height);
		}
	}

	@Override
	public void setStartPoint(int x, int y) {
		// TODO Auto-generated method stub
		/*this.x = x;
		this.y = y;*/
		setComStartPoint(x,y);
		for(BaseObject obj : contents) {
			obj.setStartPoint(x, y);
		}
		//setComArea();
	}

	public Composition(List<BaseObject> objs){
        super();
        contents = objs;
        setComArea();
    }
	
	@Override
	public void setSelected(boolean bool){
		this.isSelected = bool;
		for(BaseObject obj : contents) {
			obj.isSelected = bool;
		}
    }
	
	public void setComArea() {
		int x=10000;
		int y=10000;
		int endX = -1;
		int endY = -1;
		
		for(BaseObject obj : contents) {
			System.out.println("start " + obj.getStartX() + " " + obj.getStartY());
			System.out.println("end " + (obj.getStartX() + obj.width) + " " + (obj.getStartY() + obj.height));
		}
		
		for(BaseObject obj : contents) {
			//找左上跟右下
			
			if(obj.getEndX()>endX) {
				endX = obj.getEndX() ;
			}
			
			if(obj.getEndY()>endY) {
				endY = obj.getEndY() ;
			}
			
			if(obj.getStartX()<x) {
				x = obj.getStartX();
			}
			
			if(obj.getStartY()<y) {
				y = obj.getStartY();
			}
		}
		this.setComStartPoint(x, y);
		this.setComEndPoint(endX, endY);
		width = this.getEndX() - this.getStartX() ;
		height = this.getEndY() -this.getStartY() ;
		System.out.println("com pos "+this.getStartX() + " " +this.getEndX());
		System.out.println("com pos "+this.getEndX() + " " +this.getEndY());
	}
	
	public void setComStartPoint(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
        this.y = y;
	}
	
	public void setComEndPoint(int x, int y) {
		// TODO Auto-generated method stub
		x2 = (x);
        y2 = (y);
	}
	
	
	public static Composition findUngroupComposition(BaseObject obj, List<Composition> coms){
		boolean findCom = false;
		Composition com = null;
		//System.out.println("coms size here "+coms.size());
        // if the given obj belongs to an only composition, set the isSelected value of this composition.
		List<BaseObject> comObject =  new ArrayList<BaseObject>();
		for(int i = coms.size()-1 ; i >= 0; i--) {
			List<BaseObject> contents = coms.get(i).getLeafsContents();
			System.out.println("contents "+contents);
            if(contents.contains(obj)){
            	com = coms.get(i);
            	break; 
            }
		}
        return com;
    }
	
	public static List<BaseObject> selectCompositionGivenObj(BaseObject obj, boolean bool, List<Composition> coms){
		boolean findCom = false;
		//System.out.println("coms size here " + coms.size());
        // if the given obj belongs to an only composition, set the isSelected value of this composition.
		List<BaseObject> comObject =  new ArrayList<BaseObject>();
		for(int i = coms.size()-1 ; i >= 0; i--) {
			List<BaseObject> contents = coms.get(i).getLeafsContents();
			//System.out.println("contents "+contents);
            if(contents.contains(obj)){
            	for(BaseObject obj1 : contents) {
            		obj1.setSelected(bool);
            		comObject.add(obj1);
            		findCom = true;
            	}
            	if(findCom)break;
            }
		}
		
		/*
        for (Composition com: coms){ 
            List<BaseObject> contents = com.getLeafsContents();
            if(contents.contains(obj)){
               // Selectable.setSelectables(contents, bool);
            	for(BaseObject obj1 : contents) {
            		obj1.setSelected(bool);
            		comObject.add(obj1);
            		findCom = true;
            	}
            	if(findCom)break;
            }
        }*/
		
        if(findCom) {
            return comObject;
        }else {
        	comObject.add(obj);
        	obj.setSelected(bool);
        	return comObject;
        }
    }

	public List<BaseObject> getLeafsContents() {
		// TODO Auto-generated method stub
		return contents;
	}


	
}
