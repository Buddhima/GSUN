package com.gsun.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.ViewFlipper;


public class GsunAppActivity extends Activity {
	
	ViewFlipper page;
	float oldTouchValue;
	ExpandableListView expandableList;
	
	
    /** Called when the activity is first created. */
	@SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.main);
       // setContentView(R.layout.loggingform);
       // setContentView(R.layout.searching);
        
      //  setContentView(R.layout.results);
        setContentView(R.layout.shopdata);
        
        expandableList=(ExpandableListView)findViewById(R.id.expandableListView1);
        
        
        SimpleExpandableListAdapter expListAdapter=new SimpleExpandableListAdapter(
        		this, 
        		
        		createMainList(), 
        		R.layout.group_row, 
        		new String[] { "Group Item" }, 
        		new int[] { R.id.row_name }, 
        		
        		createSubLists(), 
        		R.layout.child_row, 
        		new String[] {"Sub Item_1"}, 
        		new int[] { R.id.grp_child1}
        		
        );
        
        
        expandableList.setAdapter(expListAdapter);
        
        expandableList.setIndicatorBounds(380, 390);
        
        
        page=(ViewFlipper)findViewById(R.id.viewFlipper1);
        
        
    }
    
   
    private List createMainList(){
    	
    	ArrayList mainList=new ArrayList();
    	    	
    	HashMap m1=new HashMap();m1.put("Group Item", "Details");
    	HashMap m2=new HashMap();m2.put("Group Item", "Contact");
    	
    	mainList.add(m1);mainList.add(m2);
    	
    	return (List)mainList;
    }
    
    private List createSubLists(){
    	
    	ArrayList submenuCollection=new ArrayList();
    	
    	ArrayList submenuDetail=new ArrayList();
    	//submenuDetail.add("Shop name");submenuDetail.add("Shop Type");submenuDetail.add("Shop Address");
    	HashMap m1=new HashMap();m1.put("Sub Item_1", "Shop name");
    	HashMap m2=new HashMap();m2.put("Sub Item_1", "Shop Type");
    	HashMap m3=new HashMap();m3.put("Sub Item_1", "Shop Address");
    	
    	submenuDetail.add(m1);submenuDetail.add(m2);submenuDetail.add(m3);
    	
    	submenuCollection.add(submenuDetail);
    	
    	
    	ArrayList submenuContact=new ArrayList();
    	//submenuContact.add("Telephone No:");    	submenuContact.add("Email");
    	HashMap m4=new HashMap();m4.put("Sub Item_1", "Telephone No:");
    	HashMap m5=new HashMap();m5.put("Sub Item_1", "Email");
    	
    	submenuContact.add(m4);submenuContact.add(m5);
    	
    	submenuCollection.add(submenuContact);
    	
    	return (List)submenuCollection;
    	
    }
    
    
    

@Override
public boolean onTouchEvent(MotionEvent event) {
	// TODO Auto-generated method stub
	//return guestureDetector.onTouchEvent(event);
	
	switch (event.getAction()) {
	case MotionEvent.ACTION_DOWN:
		oldTouchValue=event.getX();
		
		break;

	case MotionEvent.ACTION_UP:
		
		float currentX=event.getX();
		
		if(currentX>oldTouchValue){
			page.setInAnimation(AnimationHelper.inFromLeftAnimation());
			page.setOutAnimation(AnimationHelper.outToRightAnimation());
			page.showNext();
			
		}
		
		if(currentX<oldTouchValue){
			page.setInAnimation(AnimationHelper.inFromRightAnimation());
			page.setOutAnimation(AnimationHelper.outToLeftAnimation());
			page.showPrevious();}
		
		break;
	}
	return false;
}

    
}