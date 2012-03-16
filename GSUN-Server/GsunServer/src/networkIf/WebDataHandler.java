package networkIf;

import java.util.List;

import objects.Shop;
import logic.ExternalRequestHandler;

public class WebDataHandler {

	public void addShopTemp(Shop shop){
		ExternalRequestHandler erh=new ExternalRequestHandler();
		try {
			erh.addToTempDbPlaces(shop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
                        
                        System.out.println("problem occoured adding shop to temp DB:"+e.toString());
		}
	}
	
	/**
	 * adding a shop from web page
	 * @param shop
	 */
	public void addShopPlace(Shop shop){
		
		ExternalRequestHandler erh=new ExternalRequestHandler();
		try {
			erh.addPlacetoPlaceDb(shop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * get tempory shop list
	 * @return
	 */
	public List<Shop> getTempShopList(){
		ExternalRequestHandler erh=new ExternalRequestHandler();
		try {
			return erh.getAllTempShops();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        
        
	
	
}
