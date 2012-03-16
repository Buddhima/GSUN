/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbms;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.DriverManager;
//import java.sql.DriverManager;
//import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;






import objects.*;

/**
 * 
 * @author BUDDHIMA
 */
public class TempDbHandler {
	private final Connection conn;
	private final String url = "jdbc:mysql://localhost:3306/";
	private final String dbName = "gsun_temp_db";
	private final String driver = "com.mysql.jdbc.Driver";
	private final String userName = "root";
	private final String password = "";
	//private String table;
	private PreparedStatement prepstmnt;

	/**
	 * 
	 */
	public TempDbHandler() throws Exception{

		//try {
			Class.forName(driver).newInstance();
			conn =   DriverManager.getConnection(url + dbName, userName, password);

		//} catch (Exception e) {
			// TODO: handle exception
		//	System.out.println("Error in connecting to tempDB" + e.toString());

		//}
	}

	/**
	 * insert an android user - to be used by admin
	 * @param androidUser
	 * @return
	 */
	public synchronized boolean insertAndroidUser(AndroidUser androidUser) {

		String updateString = "INSERT INTO users VALUES (?,?,?,?)";
		boolean result;

		try {
			prepstmnt =  conn.prepareStatement(updateString);

			prepstmnt.setString(1, androidUser.getUsername());
			prepstmnt.setString(2, androidUser.getPassword());
			prepstmnt.setString(3, androidUser.getEmail());
			prepstmnt.setString(4, androidUser.getDiscription());

			result = prepstmnt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in inserting androidUser" + e.toString());
			result = false;

		}

		return result;
	}

	/**
	 * get details of android user
	 * @param androidUser
	 * @return
	 */
	public AndroidUser getAndroidUser(AndroidUser androidUser) {

		System.out.println("method not impliemnted yet");
		return null;

	}

	
	/**
	 * get a list of Android user
	 * @return
	 */
	public List<AndroidUser> getAndroidUsersList() {
		List<AndroidUser> androidUsers=new ArrayList<AndroidUser>();
		String getString="SELECT * FROM users";
		
		try {
			prepstmnt=conn.prepareStatement(getString);
									
			ResultSet result=prepstmnt.executeQuery();
			
			// 0-user_name, 1-password, 2-email, 3-discription
			while(result.next()){
				AndroidUser Auser=new AndroidUser(
						"",	// user_id is not needed
						result.getString(1), 
						result.getString(2), 
						result.getString(3), 
						result.getString(4),
						"", "");	// longitude and latitude of android user not used
				
				androidUsers.add(Auser);
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
                    System.out.println("error in creating android user list"+ e.toString());
                    androidUsers=null;
			
		}
		
		
		return androidUsers;
		
	}

	/**
	 *  delete android user
	 * @param androidUser
	 * @return
	 */
	public synchronized boolean deleteAndroidUser(AndroidUser androidUser) {
		String deleteString="DELETE FROM users WHERE user_name=?, password=?, email=?";
		boolean result;
		
		try {
			prepstmnt=conn.prepareStatement(deleteString);
			
			prepstmnt.setString(1, androidUser.getUsername());
			prepstmnt.setString(2, androidUser.getPassword());
			prepstmnt.setString(3, androidUser.getEmail());
			
			result = prepstmnt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in inserting androidUser" + e.toString());
			result = false;
		}
		return result;
	}

	/**
	 * insert a shop by open community
	 * @param shop
	 * @return
	 */
	public synchronized boolean insertShop(Shop shop) {
		String updateString = "INSERT INTO shops VALUES (?,?,?,?,?,?,?,?)";
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
			prepstmnt.setString(8, shop.getNeed_type());
			

			result = prepstmnt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in inserting shop" + e.toString());
			result = false;

		}

		return result;
		
	}

	/**
	 * get info about a shop 
	 * @param shop
	 * @return
	 */
	public Shop getShop(Shop shop) {
		
		System.out.println("Not implimented yet!");
		return null;
	}

	/**
	 * get shop list in temp database
	 * @return
	 */
	public List<Shop> getShopsList() {
		List<Shop> shops=new ArrayList<Shop>();
		String getString="SELECT * FROM shops";
		
		try {
			prepstmnt=conn.prepareStatement(getString);
									
			ResultSet result=prepstmnt.executeQuery();
			
			// 0-shop_name, 1-longitude, 2-latitude, 3-address, 4-telephone_no, 5-email, 6-discription
			while(result.next()){
				Shop Ashop=new Shop("",	// shop_id not using here
						result.getString(1), 
						result.getString(2), 
						result.getString(3), 
						result.getString(4),
						result.getString(5), 
						result.getString(6), 
						result.getString(7));
				
				Ashop.setNeed_type(result.getString(8));
				
				shops.add(Ashop);
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
                    System.out.println("error in creating android shop list"+ e.toString());
                    shops=null;
			
		}
		
		
		return shops;
	}

	/**
	 * delete a shop in temp db
	 * @param shop
	 * @return
	 */
	public synchronized boolean deleteShop(Shop shop) {
		
		String deleteString="DELETE FROM shops WHERE shop_name=? AND longitude=?  AND latitude=?";
		boolean result;
		
		try {
			prepstmnt=conn.prepareStatement(deleteString);
			
			prepstmnt.setString(1, shop.getShop_name());
			prepstmnt.setString(2, shop.getLongitude());
			prepstmnt.setString(3, shop.getLatitude());
			
			result = prepstmnt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in deleting shop" + e.toString());
			result = false;
		}
		return result;
		
	}

}
