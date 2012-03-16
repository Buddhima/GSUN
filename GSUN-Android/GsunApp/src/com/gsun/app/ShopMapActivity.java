package com.gsun.app;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//import org.w3c.dom.Document;

import org.kxml2.kdom.Document;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


public class ShopMapActivity extends MapActivity {


	public static URL url = null; 
	public static HttpURLConnection urlConnection= null;
	public static org.w3c.dom.Document doc = null; 
	
	/* (non-Javadoc)
	 * @see com.google.android.maps.MapActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.shopmap);
		
		TextView shopName=(TextView) findViewById(R.id.toShop);
		shopName.setText(ShopDataActivity.selectedShop.getShop_name());
		
		MapView map=(MapView) findViewById(R.id.shopMapview);
		map.setBuiltInZoomControls(true);
		MapController mapControl=map.getController();
		
		double shopLatitude=Double.parseDouble(ShopDataActivity.selectedShop.getLatitude());
		double shopLongitude=Double.parseDouble(ShopDataActivity.selectedShop.getLongitude());
		
		GeoPoint shopPoint=new GeoPoint((int)(shopLatitude*1E6), (int)(shopLongitude*1E6));
	//	mapControl.animateTo(shopPoint);
		mapControl.setZoom(10);
		map.invalidate();
		
	//	List<Overlay> mapOverlays=map.getOverlays();
				
		
		// For point to the shop
			
	//	OverlayItem overlayitem = new OverlayItem(shopPoint, ShopDataActivity.selectedShop.getShop_name(), ShopDataActivity.selectedShop.getDiscription());
	//	Drawable marker2=this.getResources().getDrawable(R.drawable.marker2);
	//	ShopBalloonOverlay itemmizedOverlay2=new ShopBalloonOverlay(marker2, map);
		
	//	itemmizedOverlay2.addOverlay(overlayitem);
		
	//	mapOverlays.add(itemmizedOverlay2);
		
		
		// For point to the user
		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
		Location myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		final double myLongitude = myLocation.getLongitude();
		final double myLatitude = myLocation.getLatitude();
		GeoPoint myPoint=new GeoPoint((int)(myLatitude*1E6), (int)(myLongitude*1E6));
		
//		OverlayItem overlayitem3 = new OverlayItem(myPoint, "You", "You are here");
//		Drawable marker3=this.getResources().getDrawable(R.drawable.marker);
//		ShopBalloonOverlay itemmizedOverlay3=new ShopBalloonOverlay(marker3, map);
		
//		itemmizedOverlay3.addOverlay(overlayitem3);
		
//		mapOverlays.add(itemmizedOverlay3);
		
		// new map to show path
		
		DrawPath(myPoint, shopPoint, Color.RED, map); 

		map.getController().animateTo(myPoint); 
		map.getController().setZoom(15); 
		
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void DrawPath(GeoPoint src,GeoPoint dest, int color, MapView mMapView01) 
	{ 
	// connect to map web service 
	StringBuilder urlString = new StringBuilder(); 
	urlString.append("http://maps.google.com/maps?f=d&hl=en"); 
	urlString.append("&saddr=");//from 
	urlString.append( Double.toString((double)src.getLatitudeE6()/1.0E6 )); 
	urlString.append(","); 
	urlString.append( Double.toString((double)src.getLongitudeE6()/1.0E6 )); 
	urlString.append("&daddr=");//to 
	urlString.append( Double.toString((double)dest.getLatitudeE6()/1.0E6 )); 
	urlString.append(","); 
	urlString.append( Double.toString((double)dest.getLongitudeE6()/1.0E6 )); 
	urlString.append("&ie=UTF8&0&om=0&output=kml"); 
	Log.d("xxx","URL="+urlString.toString()); 
	// get the kml (XML) doc. And parse it to get the coordinates(direction route). 
	//org.w3c.dom.Document doc = null; 
	//HttpURLConnection urlConnection= null; 
	//URL url = null; 
	try 
	{ 
	url = new URL(urlString.toString()); 
	
	urlConnection=(HttpURLConnection)url.openConnection(); 
	urlConnection.setRequestMethod("GET"); 
	urlConnection.setDoOutput(true); 
	urlConnection.setDoInput(true);
	/*
	urlConnection.connect(); 
*/
	new NWTask().execute();
	
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	/*
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
	DocumentBuilder db = dbf.newDocumentBuilder(); 
	doc = db.parse(urlConnection.getInputStream()); 
	*/

	if(doc.getElementsByTagName("GeometryCollection").getLength()>0) 
	{ 
	//String path = doc.getElementsByTagName("GeometryCollection").item(0).getFirstChild().getFirstChild().getNodeName(); 
	String path = doc.getElementsByTagName("GeometryCollection").item(0).getFirstChild().getFirstChild().getFirstChild().getNodeValue() ; 
	Log.d("xxx","path="+ path); 
	String [] pairs = path.split(" "); 
	String[] lngLat = pairs[0].split(","); // lngLat[0]=longitude lngLat[1]=latitude lngLat[2]=height 
	// src 
	GeoPoint startGP = new GeoPoint((int)(Double.parseDouble(lngLat[1])*1E6),(int)(Double.parseDouble(lngLat[0])*1E6)); 
	mMapView01.getOverlays().add(new PointsOverLay(startGP,startGP,1)); 
	GeoPoint gp1; 
	GeoPoint gp2 = startGP; 
	for(int i=1;i<pairs.length;i++) // the last one would be crash 
	{ 
	lngLat = pairs[i].split(","); 
	gp1 = gp2; 
	// watch out! For GeoPoint, first:latitude, second:longitude 
	gp2 = new GeoPoint((int)(Double.parseDouble(lngLat[1])*1E6),(int)(Double.parseDouble(lngLat[0])*1E6)); 
	mMapView01.getOverlays().add(new PointsOverLay(gp1,gp2,2,color)); 
	Log.d("xxx","pair:" + pairs[i]); 
	} 
	mMapView01.getOverlays().add(new PointsOverLay(dest,dest, 3)); // use the default color 
	} 
	} 
	catch (Exception e) 
	{ 
	e.printStackTrace(); 
	} 
	
	}

private class NWTask extends AsyncTask<Void, Void, Void>{

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try {
			//urlConnection=(HttpURLConnection)url.openConnection();
			//urlConnection.setRequestMethod("GET"); 
			//urlConnection.setDoOutput(true); 
			//urlConnection.setDoInput(true); 
			urlConnection.connect(); 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder db = dbf.newDocumentBuilder(); 
			doc = db.parse(urlConnection.getInputStream()); 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
		return null;
	}

}

}
