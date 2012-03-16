/**
 * 
 */
package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import objects.AndroidUser;

/**
 * @author BUDDHIMA
 *
 */
public class UsersDbHandler {
	private final Connection conn;
	private final String url = "jdbc:mysql://localhost:3306/";//3306//8080
	private final String dbName = "gsun_users_db";
	private final String driver = "com.mysql.jdbc.Driver";
	private final String userName = "root";
	private final String password = "";
	//private String table;
	private PreparedStatement prepstmnt;
	/**
	 * 
	 */
	public UsersDbHandler() throws Exception {
		Class.forName(driver).newInstance();
		conn = DriverManager
				.getConnection(url + dbName, userName, password);

	}
	
	/**
	 * inserting an android user
	 * @param androidUser
	 * @return
	 */
	public synchronized boolean insertAndroidUser(AndroidUser androidUser) {

		String updateString = "INSERT INTO android_users (user_name,password,email,discription) VALUES (?,?,?,?)";
		boolean result;

		try {
			prepstmnt = conn.prepareStatement(updateString);

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
	 * get user list 
	 * @return
	 */
	public List<AndroidUser> getAndroidUsersList() {
		List<AndroidUser> androidUsers=new ArrayList<AndroidUser>();
		String getString="SELECT * FROM android_users";
		
		try {
			prepstmnt=conn.prepareStatement(getString);
									
			ResultSet result=prepstmnt.executeQuery();
			
			//0-user_id, 1-user_name, 2-password, 3-email, 4-discription
			while(result.next()){
				AndroidUser Auser=new AndroidUser(
						result.getString(1), 
						result.getString(2), 
						result.getString(3), 
						result.getString(4),
						result.getString(5),
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
	 * @param androidUser
	 * @return
	 */
	public AndroidUser getAndroidUser(AndroidUser androidUser) {
		AndroidUser Auser;
		String getString="SELECT * FROM android_users WHERE user_name=? AND password=?";
		
		try {
			prepstmnt=conn.prepareStatement(getString);
				                
                        
                        
			prepstmnt.setString(1,androidUser.getUsername() );//
			prepstmnt.setString(2,androidUser.getPassword() );//
			
			ResultSet result=prepstmnt.executeQuery();
			result.next();
			
			//0-user_id, 1-user_name, 2-password, 3-email, 4-discription
			
				Auser=new AndroidUser(
						result.getString(1), 
						result.getString(2), 
						result.getString(3), 
						result.getString(4),
						result.getString(5),
						"", "");	// longitude and latitude of android user not used
				
			
		} catch (Exception e) {
			// TODO: handle exception
                    System.out.println("error in finding android user "+ e.toString());
                    Auser=null;
			
		}
		
		
		return Auser;
		
	}
	

	/**
	 * delete user from user db
	 * @param androidUser
	 * @return
	 */
	public synchronized boolean deleteAndroidUser(AndroidUser androidUser) {
		String deleteString="DELETE FROM android_users WHERE user_id=?, user_name=?, password=?, email=?";
		boolean result;
		
		try {
			prepstmnt=conn.prepareStatement(deleteString);
			
			prepstmnt.setString(1, androidUser.getUser_id());
			prepstmnt.setString(2, androidUser.getUsername());
			prepstmnt.setString(3, androidUser.getPassword());
			prepstmnt.setString(4, androidUser.getEmail());
			
			result = prepstmnt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in inserting androidUser" + e.toString());
			result = false;
		}
		return result;
	}


}
