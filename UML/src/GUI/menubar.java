package GUI;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mode.GroupObject;
import mode.RenameObject;
import mode.Select;
import mode.UnGroupObject;

public class menubar {
    JMenu file, edit;  
    JMenuBar mb = new JMenuBar();
    JMenuItem item1, item2, item3;
    MyCanvas canvas;
    
    menubar(MyCanvas canvas){
	    this.canvas = canvas;
	    
	    file = new JMenu("File");  
	    
	    edit = new JMenu("Edit");
	    item1 = new JMenuItem("Rename");
	    item2 = new JMenuItem("Group");
	    item3 = new JMenuItem("Ungroup");
	    edit.add(item1);
	    edit.add(item2);
	    edit.add(item3);
	    
	    item1.addActionListener(new RenameObject(this.canvas));
	    
	    item2.addActionListener(new GroupObject(this.canvas));

	    item3.addActionListener(new UnGroupObject(this.canvas));
	    
	    mb.add(file); 
	    mb.add(edit);   
   }
    public JMenuBar getMenuBar() {
    	return mb;
    }
}
