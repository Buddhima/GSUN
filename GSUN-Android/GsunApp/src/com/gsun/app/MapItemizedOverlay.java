package com.gsun.app;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MapItemizedOverlay extends ItemizedOverlay<OverlayItem>
{
	private ArrayList<OverlayItem> mapOverlays = new ArrayList<OverlayItem>();
	 
    private Context context;
    
    
	public MapItemizedOverlay(Drawable arg0) {
		super(boundCenterBottom(arg0));
		// TODO Auto-generated constructor stub
	}
	
	 public MapItemizedOverlay(Drawable defaultMarker, Context context) {
         this(defaultMarker);
         this.context = context;
    }
	 
	public void addOverlay(OverlayItem overlay) {
         mapOverlays.add(overlay);
          this.populate();
      } 

	@Override
	protected OverlayItem createItem(int arg0) {
		// TODO Auto-generated method stub
		return mapOverlays.get(arg0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mapOverlays.size();
	}
	
		
	

}
