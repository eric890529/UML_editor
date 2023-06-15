package mode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import GUI.MyCanvas;
import Object.BaseLineObject;
import Object.BaseObject;
import Object.Composition;
import Object.selectArea;

public class Select extends Mode{
	BaseObject selecctedObj;//當下點到的物件
	static List<BaseObject> objList;//點到的位置，所有obj都回傳
	static List<BaseObject> selectedObjList;
	List<BaseObject> comObj;
	protected boolean isDraging = false;
	int lastX;
	int lastY;
	
	int objStartX;
	int objStartY;
	selectArea area ;
	
	public Select(MyCanvas canvas) {
		super(canvas);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		canvas.selectedObj.removeAll(canvas.selectedObj);
		
		for(BaseObject obj : canvas.objList) {
			obj.setSelected(false);
		}
		
		objList = BaseObject.getInsideObjs(e.getX(), e.getY(), canvas.objList);
		comObj = new ArrayList<BaseObject>();
		
		if(objList.size()>0) {
			selecctedObj = objList.get(objList.size()-1);//最後生成的
			//selecctedObj.getPort().setPortPosition();
			comObj = Composition.selectCompositionGivenObj(selecctedObj, true, canvas.coms);
			//selecctedObj.setSelected(true);
			//canvas.selectedObj.add(selecctedObj);
			for(BaseObject obj : comObj) {
				canvas.selectedObj.add(obj);
        	}
			
			for(BaseObject obj : comObj) {//確保group的物件都有被選到
				if(!objList.contains(obj)) {
					objList.add(obj);
				}
        	}
		}
		canvas.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println("pressed");
		canvas.selectedObj.removeAll(canvas.selectedObj);
		
		
		x = e.getX();
		y = e.getY();
		
		this.area = new selectArea(x,y);
		System.out.println("area111 "+ area);
		lastX = x;
		lastY = y;
		
		for(BaseObject obj : canvas.objList) {
			obj.setSelected(false);
		}
		
		objList = BaseObject.getInsideObjs(x, y, canvas.objList);
		comObj = new ArrayList<BaseObject>();

		//List<BaseObject> tempConObj = new ArrayList<BaseObject>();
		
		
		if(objList.size()>0) {
			selecctedObj = objList.get(objList.size()-1);//最後生成的
			//selecctedObj.setSelected(true);
			comObj = Composition.selectCompositionGivenObj(selecctedObj, true, canvas.coms);
			
			isDraging = true;
			for(BaseObject obj : comObj) {
				canvas.selectedObj.add(obj);
        	}
		}else {
			selecctedObj = null;
		}
		
		for(BaseObject obj : comObj) { //確保group的物件都有被選到
			if(!objList.contains(obj)) {
				objList.add(obj);
			}
    	}
		canvas.repaint();
	}
	
	@Override
    public void mouseReleased(MouseEvent e) {
		
		canvas.area = null;
		 
		System.out.println("released");
		endX = e.getX();
		endY = e.getY();
        if(isDraging) {
        	/*int translateX = endX - x;
            int translateY = endY - y;*/
        	if(objList.size()>0) {
        		for(BaseObject obj: canvas.selectedObj) {
        			obj.setStartPoint(obj.getStartX()  , obj.getStartY() );
        			obj.getPort().setPortPosition();
        		}
        		//selecctedObj = objList.get(objList.size()-1);
				//selecctedObj.setStartPoint(selecctedObj.getStartX() + translateX, selecctedObj.getStartY() + translateY);
				//selecctedObj.setPortPosition();
				for(BaseLineObject line: canvas.lineList){
                        line.updatePosition();
				}   
			}
		}else{
			objList = BaseObject.getInsideObjs(x, y, endX, endY, canvas.objList);
			List<BaseObject> tempConObj = new ArrayList<BaseObject>();
			for(BaseObject obj : objList) {
				obj.setSelected(true);
				
				comObj = Composition.selectCompositionGivenObj(obj, true, canvas.coms); //拉框選取物件的時候，不要選到group
				tempConObj.addAll(comObj);
				
				/*if(!canvas.selectedObj.contains(obj)) {
					canvas.selectedObj.add(obj);
				}*/
				
			}
			
			
			for(BaseObject obj : tempConObj) {//確保group的物件都有被選到
				if(!objList.contains(obj)) {
					objList.add(obj);
				}
        	}
			
		}
        

		System.out.println("canvas.selectedObj size"+ canvas.selectedObj.size());

		System.out.println("objList  size"+ objList.size());
		

		System.out.println("canvas.coms " + canvas.coms.size());
		isDraging = false;
		canvas.repaint();
    }
	
	
	@Override
    public void mouseDragged(MouseEvent e) {
        if(isDraging) {
        	int tempX = e.getX();
    		int tempY = e.getY();
    		int translateX = tempX - lastX;
            int translateY = tempY - lastY;
            for(BaseObject obj: canvas.selectedObj) {
    			obj.setStartPoint(obj.getStartX() + translateX, obj.getStartY() + translateY);
    			obj.getPort().setPortPosition();
    			
    		}
            
            for(BaseLineObject line: canvas.lineList){
                line.updatePosition();
            } 
            canvas.repaint();
    		lastX = tempX;
    		lastY = tempY;
        }else {
        	System.out.println("area222 "+ area);
        	area.setEndPoint(e.getX(), e.getY());
    		canvas.area = area;
    		canvas.repaint();
        }
    }  
	
}
