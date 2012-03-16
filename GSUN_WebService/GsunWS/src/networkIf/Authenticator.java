package networkIf;

import logic.UserAuthenticator;
import objects.Administrator;
import objects.AndroidUser;

public class Authenticator {

	/**
	 * this method authenticate a administrator user in the system
	 * @param admin
	 */
	public boolean authenticate(Administrator admin){
		UserAuthenticator ua=new UserAuthenticator();
		boolean isValid=false;
		try {
			isValid=ua.authenticate(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	
	/**
	 * this method authenticate an Android user in the system
	 * @param androidUser
	 */
	public boolean authenticate(AndroidUser androidUser) {
		UserAuthenticator ua=new UserAuthenticator();
		boolean isValid=false;
		try {
			isValid=ua.authenticate(androidUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	
	
}
