package logic;

import java.util.ArrayList;
import java.util.List;

import dbms.PlacesDbHandler;

import objects.Entry;
import objects.Shop;

public class EntryHandler {

	//public boolean addEntry(Entry entry){}
	
	//public boolean deleteEntry(Entry entry){}
	
	//public Entry getEntry(Entry entry){}
	
	/**
	 * this method will return the list of entry objects WITH shop_id after matching the need with type and range
	 * @param entry
	 * @param range
	 * @return
	 */
	//public List<Entry> getShopId(Entry entry,int range){
	//	return entry;}
	
	
	/**
	 * This will process the entry with dictionary table  ; after that, query shops table and return list of suggested shops
	 * @param entry
	 * @param range
	 * @return
	 */
	public List<Shop> prepareSuggestionList(Entry entry, int range) throws Exception{
		
		PlacesDbHandler placesDB=new PlacesDbHandler();
		
		List<Entry> entryList=placesDB.getByType(placesDB.getType(entry), range);
		
		
		List<Shop> shopIdList=convertEntryToShop(entryList);
						
		
		return placesDB.getShopsList(shopIdList);
		}
	
	
	/**
	 * this method is to convert a list of entries in to list of shops
	 * transfer data from dictionary table to shops table.
	 * @param entryList
	 * @return
	 */
	private List<Shop> convertEntryToShop(List<Entry> entryList) {
		// TODO Auto-generated method stub
		List<Shop> shopList=new ArrayList<Shop>();
		
		for(Entry entry:entryList){
			Shop shop=new Shop(entry.getShop_id(), "", "", "", "", "", "", "");
			shopList.add(shop);
			
		}
		
		return shopList;
	}


	/**
	 * This will process the entry with dictionary table  ; after that, query shops table and return list of result shops
	 * @param entry
	 * @param range
	 * @return
	 */
	public List<Shop> prepareResultList(Entry entry, int range) throws Exception{
		
		PlacesDbHandler placesDB=new PlacesDbHandler();
		
		List<Entry> entryList=placesDB.getByNeed(placesDB.getType(entry), range);
		List<Shop> shopIdList=convertEntryToShop(entryList);
							
		return placesDB.getShopsList(shopIdList);
		
		}
	
	
	
}
