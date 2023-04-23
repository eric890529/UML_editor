package Object;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Composition extends BaseObject{
	private List<BaseObject> contents = new ArrayList<BaseObject>();
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public Composition(List<BaseObject> objs){
        super();
        contents = objs;
    }
	
	
	public static Composition findUngroupComposition(BaseObject obj, List<Composition> coms){
		boolean findCom = false;
		Composition com = null;
		System.out.println("coms size here "+coms.size());
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
		System.out.println("coms size here " + coms.size());
        // if the given obj belongs to an only composition, set the isSelected value of this composition.
		List<BaseObject> comObject =  new ArrayList<BaseObject>();
		for(int i = coms.size()-1 ; i >= 0; i--) {
			List<BaseObject> contents = coms.get(i).getLeafsContents();
			System.out.println("contents "+contents);
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
