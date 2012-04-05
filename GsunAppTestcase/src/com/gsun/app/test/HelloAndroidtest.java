package com.gsun.app.test;

import android.test.ActivityInstrumentationTestCase2;
import android.text.style.ClickableSpan;
import android.widget.AutoCompleteTextView;

import com.gsun.app.SearchActivity;
import com.jayway.android.robotium.solo.Solo;

public class HelloAndroidtest extends
		ActivityInstrumentationTestCase2<SearchActivity> {

	SearchActivity mActivity;
	AutoCompleteTextView mView;
	Solo solo;
	
	public HelloAndroidtest() {
		super("com.gsun.app.SearchActivity", SearchActivity.class);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		mActivity = this.getActivity();
		mView = (AutoCompleteTextView)mActivity.findViewById(com.gsun.app.R.id.autoCompleteTextViewSearch);
		solo=new Solo(getInstrumentation(), getActivity());
		
	}

	/**
	 * To Test Pre-Conditions 
	 */
	public void testPreconditions(){
		
		assertNotNull(mView);
	}
	
	/**
	 * To Test correctness
	 */
	public void testText() {
		assertEquals("", mView.getText().toString());
	}
	
	/**
	 * To test demo running of app
	 * @throws InterruptedException
	 */
	public void testSolo1() throws InterruptedException{
		// searchview
		solo.enterText(0, "Bun");
		Thread.sleep(400);
		solo.clickOnButton("Find");
		Thread.sleep(4000);
		
		// result list
		solo.clickInList(0);
		
		// details of a shop
		solo.clickInList(0);
		solo.clickOnText("Contact");
		
		solo.clickOnText("Map");
		
		Thread.sleep(4000);
		solo.goBack();solo.goBack();solo.goBack();solo.goBack();
		
		
	}
	
	/**
	 * To run a demo
	 * @throws InterruptedException
	 */
	public void testSolo2() throws InterruptedException{
		// searchview
		solo.enterText(0, "Bread");
		Thread.sleep(400);
		solo.clickOnButton("Find");
		Thread.sleep(4000);
		
		// result list
		solo.clickInList(0);
		
		
		// details of a shop
		solo.clickInList(0);
		solo.clickOnText("Contact");
		
				
		Thread.sleep(2000);
		
		solo.goBack();solo.goBack();solo.goBack();
		
	}
	
}
