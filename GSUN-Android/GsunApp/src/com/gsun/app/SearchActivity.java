package com.gsun.app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gsun.ntwrk.NetworkIF;
import com.gsun.objects.Entry;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

public class SearchActivity extends Activity {

	String[] NEEDS; // List for auto-suggestion
	
	Entry searchEntry; // Entry the user submitted for search
	
	final NetworkIF netwrkIf=new NetworkIF(); // NetworkIf object use to communicate with Gsun Web Service
	
	
	/* Initialize all the things related to the view on create state
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
				
		fillArray(); // Fill the array for suggestion list
				
		setContentView(R.layout.searching);
		
		// Config the adapter for auto suggestion list
		final AutoCompleteTextView needSearch=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewSearch);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.auto_listitem,NEEDS);
		needSearch.setAdapter(adapter);
		
		
		((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(needSearch, InputMethodManager.SHOW_FORCED);
		
		//  GPS location configuration
		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, new MyLocationListener());
		
		Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		final double longitude = location.getLongitude();
		final double latitude = location.getLatitude();
			
		// Button configuration
		final Button findButton=(Button)findViewById(R.id.findButton);
		findButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// creating and sending Entry object to server
				createEntry();
				
				// switching to serach result+suggestion viewing activity
				
				Intent myIntent = new Intent(v.getContext(), ResultActivity.class);
                startActivity(myIntent);
                
			}

			private void createEntry() {
				// TODO Auto-generated method stub
				String need=needSearch.getText().toString();
				final Spinner rangeSpinner=(Spinner)findViewById(R.id.rangeSpinner);
				String range=rangeSpinner.getSelectedItem().toString();
				
				searchEntry=new Entry(need, "", String.valueOf(longitude), String.valueOf(latitude));
			/*	
				Thread splashThread=new Thread(){

					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						ProgressDialog dialog=new ProgressDialog(SearchActivity.this);
						dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
						dialog.setMax(100);
						dialog.show();
						
						for(int i=0;i<20;i++){
							dialog.incrementProgressBy(5);
							
							try {
								Thread.sleep(88);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						dialog.dismiss();
					}
					
					
				};
				splashThread.start();
				*/
				
				netwrkIf.sendEntry(searchEntry, Integer.parseInt(range));
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
	}
	
	

	private void fillArray() {
		// TODO Auto-generated method stub
		
		// Following part will valid after connecting to Server
		netwrkIf.giveAllNeeds();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Entry> needList=netwrkIf.needList;
		
		NEEDS=new String[needList.size()];
		
		int i=0;
		for(Entry e:needList){
			
			NEEDS[i]=e.getNeed();
			
			i++;
		}
		
		// remove duplicates in NEED list
		List<String> list = Arrays.asList(NEEDS);
		Set<String> set = new HashSet<String>(list);
		
		NEEDS = new String[set.size()];
		set.toArray(NEEDS);
				
	}
	
	

}
