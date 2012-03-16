/**
 * This class is to handle lower level operations with Places database
 * 
 */
package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import objects.Entry;
import objects.Shop;



/**
 * @author BUDDHIMA
 * 
 */
public class PlacesDbHandler {

	private final Connection conn;
	private final String url = "jdbc:mysql://localhost:3306/";
	private final String dbName = "gsun_places_db";
	private final String driver = "com.mysql.jdbc.Driver";
	private final String userName = "root";
	private final String password = "";
	// private String table;
	private PreparedStatement prepstmnt;

	/**
	 * 
	 */
	public PlacesDbHandler() throws Exception {

		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, password);
	}

	/**
	 * Create a new shop item in shop table - use by admin
	 * @param shop
	 * @return
	 */
	public synchronized boolean insertShop(Shop shop) {
		String updateString = "INSERT INTO shops (shop_name,longitude,latitude,address,telephone_no,email,discription) VALUES (?,?,?,?,?,?,?)";
		boolean result;

		try {
			prepstmnt = conn.prepareStatement(updateString);

			prepstmnt.setString(1, shop.getShop_name());
			prepstmnt.setString(2, shop.getLongitude());
			prepstmnt.setString(3, shop.getLatitude());
			prepstmnt.setString(4, shop.getAddress());
			prepstmnt.setString(5, shop.getTelephone_no());
			prepstmnt.setString(6, shop.getEmail());
			prepstmnt.setString(7, shop.getDiscription());

			result = prepstmnt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in inserting shop" + e.toString());
			result = false;

		}

		return result;

	}

	/**
	 * get a list of all shops in shop list - redundand method
	 * @return
	 */
	public List<Shop> getShopsList() {
		List<Shop> shops = new ArrayList<Shop>();
		String getString = "SELECT * FROM shops";

		try {
			prepstmnt = conn.prepareStatement(getString);

			ResultSet result = prepstmnt.executeQuery();

			// 0-shop_id, 1-shop_name, 2-longitude, 3-latitude, 4-address,
			// 5-telephone_no, 6-email, 7-discription
			while (result.next()) {
				Shop Ashop = new Shop(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4),
						result.getString(5), result.getString(6),
						result.getString(7), result.getString(8));

				shops.add(Ashop);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in creating android shop list"
					+ e.toString());
			shops = null;

		}

		return shops;
	}

	/**
	 * Deleting a shop - to be used by admin
	 * @param shop
	 * @return
	 */
	public synchronized boolean deleteShop(Shop shop) {

		String deleteString = "DELETE FROM shops WHERE shop_id=?";
		boolean result;

		try {
			prepstmnt = conn.prepareStatement(deleteString);

			prepstmnt.setString(1, shop.getShop_id());

			result = prepstmnt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in deleting shop" + e.toString());
			result = false;
		}
		return result;

	}

	/**
	 * to get list of shops for a given list of shop_ids
	 * 
	 * @param shopIdList
	 * @return
	 */
	public List<Shop> getShopsList(List<Shop> shopIdList) {
		String getString = "SELECT * FROM shops WHERE shop_id=?";
		ResultSet result = null;
		List<Shop> newShopList = new ArrayList<Shop>();
		try {
			for (Shop id : shopIdList) {
				prepstmnt = conn.prepareStatement(getString);

				prepstmnt.setString(1, id.getShop_id());

				result = prepstmnt.executeQuery();

				if (result.next()) {

					Shop shop = new Shop(
							result.getString(1), // same as shop_id in id object
							result.getString(2), result.getString(3),
							result.getString(4), result.getString(5),
							result.getString(6), result.getString(7),
							result.getString(8));

					newShopList.add(shop);

				}

			}

		} catch (Exception e) {

			System.out.println("Error in getting shops using id:"
					+ e.toString());
			shopIdList = null;
		}
		return newShopList;
	}
	
	
	/**
	 * find a ID number of a shop 
	 * @param shop
	 * @return
	 */
	public Shop getShopWithId(Shop shop) {
		String getString = "SELECT * FROM shops WHERE shop_name=? AND longitude=? AND latitude=? ";
		ResultSet result = null;
		Shop shopWithId=null;
		
		try {
			
				prepstmnt = conn.prepareStatement(getString);

				prepstmnt.setString(1, shop.getShop_name());
				prepstmnt.setString(2, shop.getLongitude());
				prepstmnt.setString(3, shop.getLatitude());

				result = prepstmnt.executeQuery();

				if (result.next()) {

					shopWithId = new Shop(
							result.getString(1), // same as shop_id in id object
							result.getString(2), result.getString(3),
							result.getString(4), result.getString(5),
							result.getString(6), result.getString(7),
							result.getString(8));

					shopWithId.setNeed_type(shop.getNeed_type());

				}

			

		} catch (Exception e) {

			System.out.println("Error in getting shops using id:"
					+ e.toString());
			
		}
		return shopWithId;
	}
	
	
	
	/////////////////////////////////// Dictionary ///////////////////////////////////////////

	/**
	 * inserting an entry into dictionary table
	 * @param entry
	 * @return
	 */
	public synchronized boolean insertEntry(Entry entry) { // need methods to
															// use with
															// dictionary

		boolean result;
		String insertString = "INSERT INTO dictionary  VALUES (?,?,?,?,?)";

		try {
			prepstmnt = conn.prepareStatement(insertString);

			prepstmnt.setString(1, entry.getNeed());
			prepstmnt.setString(2, entry.getType());
			prepstmnt.setString(3, entry.getLongitude());
			prepstmnt.setString(4, entry.getLatitude());
			prepstmnt.setString(5, entry.getShop_id());

			result = prepstmnt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in inserting dictionary index"
					+ e.toString());
			result = false;

		}

		return result;
	}

	/**
	 * Getting the type for a need from dictionary table
	 * @param entry
	 * @return
	 */
	public synchronized Entry getType(Entry entry) {

		String getTypeString = "SELECT type FROM dictionary WHERE need=?";
		Entry newEntry;

		try {
			prepstmnt = conn.prepareStatement(getTypeString);

			prepstmnt.setString(1, entry.getNeed());

			ResultSet result = prepstmnt.executeQuery();

			result.next();

			newEntry = new Entry(entry.getNeed(), result.getString(1),
					entry.getLongitude(), entry.getLatitude());
                    System.out.println("");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selecting type failed" + e.toString());
			newEntry = null;
		}

		return newEntry;

	}

	// get by need -- matches both type and need

	/**
	 * get a list of entries which matches both Type and Need requested by user
	 * @param entry
	 * @param range
	 * @return
	 */
	public List<Entry> getByNeed(Entry entry, int range) {

		double longitude = Double.parseDouble(entry.getLongitude());
		double latitude = Double.parseDouble(entry.getLatitude());
		List<Entry> entryList = new ArrayList<Entry>();

		String getByNeedString = "SELECT * FROM dictionary WHERE need=? AND type=? AND longitude BETWEEN "
				+ (longitude - range)
				+ " AND "
				+ (longitude + range)
				+ " AND latitude BETWEEN "
				+ (latitude - range)
				+ " AND "
				+ (latitude + range);

		try {
			prepstmnt = conn.prepareStatement(getByNeedString);

			prepstmnt.setString(1, entry.getNeed());
			prepstmnt.setString(2, entry.getType());

			ResultSet result = prepstmnt.executeQuery();// more to do

			while (result.next()) {

				Entry newEntry = new Entry(entry.getNeed(), entry.getType(),
						result.getString("longitude"),
						result.getString("latitude"));
                                newEntry.setShop_id(result.getString("shop_id"));
				entryList.add(newEntry);
                                System.out.println("");
			}

			// get the need mentioned in entry by list
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Problem with getBy need entry");
		}

		return entryList;
	}

	// get by type -- matches only the type in a range

	/**
	 * get a list of entries which matches  Type requested by user
	 * @param entry
	 * @param range
	 * @return
	 */
	public List<Entry> getByType(Entry entry, int range) {

		double longitude = Double.parseDouble(entry.getLongitude());
		double latitude = Double.parseDouble(entry.getLatitude());
		List<Entry> entryList = new ArrayList<Entry>();

		String getByNeedString = "SELECT * FROM dictionary WHERE type=? AND longitude BETWEEN "
				+ (longitude - range)
				+ " AND "
				+ (longitude + range)
				+ " AND latitude BETWEEN "
				+ (latitude - range)
				+ " AND "
				+ (latitude + range);

		try {
			prepstmnt = conn.prepareStatement(getByNeedString);

			// prepstmnt.setString(0,entry.getNeed());
			prepstmnt.setString(1, entry.getType());

			ResultSet result = prepstmnt.executeQuery();// more to do

			while (result.next()) {

				Entry newEntry = new Entry(entry.getNeed(), entry.getType(),
						result.getString("longitude"),
						result.getString("latitude"));
				entryList.add(newEntry);
			}

			// get the need mentioned in entry by list
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Problem with getBy need entry");
		}

		return entryList;

	}
        
        /**
         * give list of entries with all needs in the dictionary table
         * @param entry
         * @return
         */
        public List<Entry> getAllNeeds(Entry entry){
        String getAllNeeds="SELECT need FROM dictionary";
        List<Entry> needList=new ArrayList<Entry>();
        
        try {
			prepstmnt = conn.prepareStatement(getAllNeeds);

			// prepstmnt.setString(0,entry.getNeed());
			//prepstmnt.setString(1, entry.getType());

			ResultSet result = prepstmnt.executeQuery();// more to do

			while (result.next()) {

				Entry newEntry = new Entry(result.getString("need"), "",
						"","");
				needList.add(newEntry);
			}

			// get the need mentioned in entry by list
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Problem with getBy need entry");
		}
        
        return needList;
        }

}
