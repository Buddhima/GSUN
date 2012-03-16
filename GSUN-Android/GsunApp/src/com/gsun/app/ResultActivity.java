package com.gsun.app;

import com.gsun.ntwrk.NetworkIF;
import com.gsun.objects.Shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class ResultActivity extends Activity{

	ViewFlipper page;
	float oldTouchValue;
	
	ListView resultListView;
	ListView suggestionListView;
	
	String[] resultListArray;
	String[] suggestionListArray;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.results);
		
		page=(ViewFlipper)findViewById(R.id.viewFlipper1);
		
		resultListView=(ListView)findViewById(R.id.listView1);
		suggestionListView=(ListView)findViewById(R.id.listView2);
		
		createArrays();
		
		resultListView.setAdapter(new ArrayAdapter<String>(this, R.layout.result_list_item, resultListArray));
		suggestionListView.setAdapter(new ArrayAdapter<String>(this, R.layout.result_list_item, suggestionListArray));
		
		resultListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
			        int position, long id) {
			   			
				showMore(NetworkIF.resultList.get(position),view);
								
			    }
			
		});
		
		
		suggestionListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
			        int position, long id) {
			    
				showMore(NetworkIF.suggestionList.get(position),view);
				
			    }
			
		});
		
	}
	
	
	private void createArrays() {
		// TODO Auto-generated method stub
		resultListArray=new String[NetworkIF.resultList.size()];
		
		int i=0;
		for(Shop s:NetworkIF.resultList){
			resultListArray[i]=s.getShop_name();
			i++;
		}
		
		suggestionListArray=new String[NetworkIF.suggestionList.size()];
		
		int j=0;
		for(Shop s:NetworkIF.suggestionList){
			suggestionListArray[j]=s.getShop_name();
			j++;
		}
		
		
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
			
			if(currentX>oldTouchValue+500.0){
				page.setInAnimation(AnimationHelper.inFromLeftAnimation());
				page.setOutAnimation(AnimationHelper.outToRightAnimation());
				page.showNext();
				
			}
			
			if(currentX<oldTouchValue+500.0){
				page.setInAnimation(AnimationHelper.inFromRightAnimation());
				page.setOutAnimation(AnimationHelper.outToLeftAnimation());
				page.showPrevious();}
			
			break;
		}
		return false;
	}
	
	private void showMore(Shop shop,View view){
		ShopDataActivity.selectedShop=shop;
		
		Intent myIntent = new Intent(view.getContext(), ShopDataActivity.class);
        startActivity(myIntent);
		
		
	}
	

}
