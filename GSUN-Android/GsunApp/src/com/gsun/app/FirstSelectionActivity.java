package com.gsun.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstSelectionActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.firstselection);
		
		Button addButton=(Button) findViewById(R.id.buttonAddPlace);
				
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(), InsertPlaceActivity.class);
                startActivity(myIntent);
             }
		});
		
		
		Button searchButton=(Button) findViewById(R.id.buttonSearchPlace);
		
		searchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(), SearchActivity.class);
                startActivity(myIntent);
             }
		});
		
		Button guideButton=(Button) findViewById(R.id.buttonUserGuide);
		
		guideButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(), HelpActivity.class);
                startActivity(myIntent);
             }
		});
		
		
	}

}
