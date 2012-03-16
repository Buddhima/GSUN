package logic;

import java.util.ArrayList;
import java.util.List;

import objects.Entry;
import objects.Shop;
import dbms.PlacesDbHandler;
import dbms.TempDbHandler;


public class ExternalRequestHandler {

	/**
	 * 
	 */
	

	/**
	 * adding temp shops to db
	 * @param shop
	 * @return
	 * @throws Exception
	 */
	public boolean addToTempDbPlaces(Shop shop) throws Exception{
		TempDbHandler tempdbh=new TempDbHandler();
		return tempdbh.insertShop(shop);
		
		
	}
	
	/**
	 * getting a list of temp. shops
	 * @return
	 * @throws Exception
	 */
	public List<Shop> getAllTempShops() throws Exception{
		TempDbHandler tempdbh=new TempDbHandler();
		return tempdbh.getShopsList();
	}
	
	/**
	 * adding a shop to shop table of places db
	 * @param shop
	 * @return
	 */
	public boolean addPlacetoPlaceDb(Shop shop){
		boolean isValid=false;
		try {
			TempDbHandler tempdbh=new TempDbHandler();
			PlacesDbHandler pldbh=new PlacesDbHandler();
			
			pldbh.insertShop(shop);
			
			Shop shopWithId=pldbh.getShopWithId(shop);
			
			List<Entry> entryList=convertShopToEntry(shopWithId);
			
			for(Entry entry:entryList){
			pldbh.insertEntry(entry);}
			
			tempdbh.deleteShop(shopWithId);
			
			
			
			
			isValid=true;
			
		} catch (Exception e) {
			// TODO: handle exception
                    System.out.println("Problem with adding shop to places db. shop: "+e.toString());
		}
		return isValid;
		
	}

	/**
	 * putting a shop details in to an entry
	 * @param shopWithId
	 * @return
	 */
	private List<Entry> convertShopToEntry(Shop shopWithId) {
		// TODO Auto-generated method stub
		
		List<Entry> entryList=new ArrayList<Entry>(); 
		String[] needs_types=shopWithId.getNeed_type().split(":");
		
		for(String s:needs_types){
			
			String need=s.split(",")[0];
			String type=s.split(",")[1];
			
			Entry entry=new Entry(need, type, shopWithId.getLongitude(), shopWithId.getLatitude());
			entry.setShop_id(shopWithId.getShop_id());
			entryList.add(entry);
			
		}
		
		
		
		return entryList;
	}
	
}
