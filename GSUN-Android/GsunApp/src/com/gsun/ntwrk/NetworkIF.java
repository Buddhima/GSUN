package com.gsun.ntwrk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;



import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gsun.app.SearchActivity;
import com.gsun.objects.Entry;
import com.gsun.objects.Shop;


public class NetworkIF {
	
	final String NAMESPACE = "http://networkIf";
	final String URL = "http://10.0.2.2:8080/GsunWS/services/AndroidDataHandler?wsdl"; // has to change
	
	public List<Entry> needList=null;
	
	public static List<Shop> resultList=null;
	public static List<Shop> suggestionList=null;
	
	int range;
	
	
	/**
	 * give out Entry
	 * gets result list and suggestion list
	 * @param entry
	 * @param range
	 */
	public void sendEntry(Entry entry,int range){
		
		this.range=range;
		
		new wsTask2().execute(entry);
		new wsTask3().execute(entry);
		
	}
	
	/**
	 * Return a list of needs in the DB
	 * @return
	 */
	public void giveAllNeeds(){
		
		new wsTask1().execute();
		
		
		//return needList;
	} 
	
	
	private class wsTask1 extends AsyncTask<Void, Void, Void>{

	//	ProgressDialog autosuggestProgress=new ProgressDialog(SearchActivity.this);
		
		@Override
		protected Void doInBackground(Void... params) {
			
			String METHOD = "giveAllNeeds";
			String SOAPACTION = NAMESPACE+METHOD;
			//ArrayList<Entry> needList = null;
			
			SoapObject request = new SoapObject(NAMESPACE, METHOD);
			//request.addProperty("stmnt", methodInput);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
	        envelope.dotNet = true;
	        
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        
	        
	        try{
	        	androidHttpTransport.call(SOAPACTION, envelope);
	        	
	        	Object response=(Object)envelope.getResponse();
	        	
	        	Type type = new TypeToken<List<Entry>>(){}.getType();
	        	
	        //	String help=response.toString();
	        	
	        	needList=new Gson().fromJson(response.toString(), type);
	        	
	        	/*HashSet<Entry> hs = new HashSet<Entry>();
	        	hs.addAll(needList);
	        	needList.clear();
	        	needList.addAll(hs);*/
	        	
	        	System.out.println();
	        
	        }catch (Exception e) {
				// TODO: handle exception
	        	System.out.println( e.toString());
			}     
			
			
			
			return null;
			
						
		}

		/* (non-Javadoc)
		 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
		 */
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			//autosuggestProgress.dismiss();
		}

		/* (non-Javadoc)
		 * @see android.os.AsyncTask#onPreExecute()
		 */
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			//autosuggestProgress.setMessage("Feeding Auto Suggestions ... ");
			//autosuggestProgress.show();
		}

		        	
    }
	
	private class wsTask2 extends AsyncTask<Entry, Void, Void>{
		
// String giveResultList(String entryString, int range)
		
		@Override
		protected Void doInBackground(Entry... entry) {
			
			String METHOD = "giveResultList";
			String SOAPACTION = NAMESPACE+METHOD;
			
			
			SoapObject request = new SoapObject(NAMESPACE, METHOD);
			//request.addProperty("stmnt", methodInput);
			
			String entryString=new Gson().toJson(entry[0]) ;
			
			request.addProperty("entryString", entryString);
			request.addProperty("range", range);
			
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
	        envelope.dotNet = true;
	        
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        
	        
	        try{
	        	androidHttpTransport.call(SOAPACTION, envelope);
	        	
	        	Object response=(Object)envelope.getResponse();
	        	
	        	Type type = new TypeToken<List<Shop>>(){}.getType();
	       	       	        	
	        	resultList=new Gson().fromJson(response.toString(), type);
	        	
	        	HashSet<Shop> hs = new HashSet<Shop>();
	        	hs.addAll(resultList);
	        	resultList.clear();
	        	resultList.addAll(hs);
	        	
	        	System.out.println();
	        
	        }catch (Exception e) {
				// TODO: handle exception
	        	System.out.println( e.toString());
			}     
			
				
			return null;
			
						
		}

		        	
    }
	
	private class wsTask3 extends AsyncTask<Entry, Void, Void>{
		
		// String giveSuggestionList(String entryString, int range)
				
				@Override
				protected Void doInBackground(Entry... entry) {
					
					String METHOD = "giveSuggestionList";
					String SOAPACTION = NAMESPACE+METHOD;
					
					
					SoapObject request = new SoapObject(NAMESPACE, METHOD);
					//request.addProperty("stmnt", methodInput);
					
					String entryString=new Gson().toJson(entry[0]) ;
					
					request.addProperty("entryString", entryString);
					request.addProperty("range", range);
					
					SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
					
			        envelope.dotNet = true;
			        
			        envelope.setOutputSoapObject(request);
			        
			        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			        
			        
			        
			        try{
			        	androidHttpTransport.call(SOAPACTION, envelope);
			        	
			        	Object response=(Object)envelope.getResponse();
			        	
			        	Type type = new TypeToken<List<Shop>>(){}.getType();
			       	       	        	
			        	suggestionList=new Gson().fromJson(response.toString(), type);
			        	
			        	for(int i=0;i<suggestionList.size();i++){
			        		if(suggestionList.get(i).getShop_name().equalsIgnoreCase(suggestionList.get(i+1).getShop_name())&&
			        				suggestionList.get(i).getLatitude().equalsIgnoreCase(suggestionList.get(i+1).getLatitude())){
			        			suggestionList.remove(i+1);
			        			
			        		}
			        		
			        		
			        	}
			        	
			        	System.out.println();
			        
			        }catch (Exception e) {
						// TODO: handle exception
			        	System.out.println( e.toString());
					}     
					
						
					return null;
					
								
				}

				        	
		    }

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	
			
	

}
