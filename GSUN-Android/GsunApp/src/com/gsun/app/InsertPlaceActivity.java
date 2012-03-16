package com.gsun.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class InsertPlaceActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.inputplace);
		
		WebView inputplace=(WebView) findViewById(R.id.insertPlaceWeb);
		inputplace.getSettings().setJavaScriptEnabled(true);
		
	    inputplace.loadUrl("http://10.0.2.2/gsun/open_user.php");
		
	}

}
